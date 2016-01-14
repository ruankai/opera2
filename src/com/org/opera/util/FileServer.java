package com.org.opera.util;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


import com.org.opera.domain.FileLog;
import com.org.opera.domain.Video;
import com.org.opera.service.FileLogService;
import com.org.opera.service.VideoService;

public class FileServer {
	private int port;// 监听端口
	// private boolean quit=false;//用于判断是否退出
	private ExecutorService executorService;// 线程池
	private ServerSocket server;
	private FileLogService fls;
	private VideoService vs;
	private String rootPath;// 项目的根目录

	public FileServer(int port, FileLogService fls, VideoService vs,
			String rootPath) {
		this.fls = fls;
		this.port = port;
		this.vs = vs;
		this.rootPath = rootPath;
		executorService = Executors.newFixedThreadPool(Runtime.getRuntime()
				.availableProcessors() * 50);
	}

	/*	*//**
	 * 退出
	 * 
	 * @throws Exception
	 */
	/*
	 * public void quit(){ try{ server.close(); }catch(IOException e){
	 * 
	 * } }
	 */
	public void start() throws Exception {
		server = new ServerSocket(this.port);
		while(true){
		Socket socket = server.accept();
		// 为支持多用户并发访问，采用线程池管理每一个用户的连接请求
		executorService.execute(new SocketTask(socket));
		}
	}

	private final class SocketTask implements Runnable {
		private Socket socket = null;

		public SocketTask(Socket socket) {
			this.socket = socket;
		}

		public void run() {
			try {
				System.out.println("accepted connection "
						+ socket.getInetAddress() + ":" + socket.getPort());
				PushbackInputStream inStream = new PushbackInputStream(
						socket.getInputStream());
				// 得到客户端发来的第一行协议数据：Content-Length=143253434;filename=xxx.3gp;sourceid=
				// 如果用户初次上传文件，id的值为空。
				String head = StreamTool.readLine(inStream);
				String str =new String(head.getBytes("iso-8859-1"), 
						"utf-8");
				//System.out.println(head);
				System.out.println(str);
				if (str != null) {
					// 下面从协议数据中提取各项参数值
					String[] items = str.split(";");
					String id = items[0].substring(items[0].indexOf("=") + 1);
					FileLog log = null;// 无论是否有上传记录，初始化log
					File file = null;// 无论是否有上传记录，初始化file
					if (id == null || "".equals(id)) {
						// 视频的名称
						System.out.println("运行到这里1");
						String initiateName = items[1].substring(items[1]
								.indexOf("=") + 1);
						// 视频大小
						Long size = Long.parseLong(items[2].substring(items[2]
								.indexOf("=") + 1));
						// 版权所属
						String copyright = items[3].substring(items[3]
								.indexOf("=") + 1);
						// 视频描述
						String description = items[4].substring(items[4]
								.indexOf("=") + 1);
						String photographer = items[5].substring(items[5]
								.indexOf("=") + 1);
						File dir = new File(rootPath);
						if (!dir.exists())
							dir.mkdirs();
						// 使用时间戳重命名视频文件
						String uploadName = new IPTimeStamp("127.0.0.1")
								.getIPTimeStampRand()
								+ initiateName.substring(initiateName
										.indexOf("."));
						file = new File(dir, uploadName);
						System.out.print(file.getAbsolutePath());
						log = new FileLog();
						log.setSourceId(UUID.randomUUID().toString());// 生成一个ID
						log.setCopyright(copyright);
						log.setDescription(description);
						log.setInitiateName(initiateName);
						log.setPosition(0L);
						log.setSize(size);
						log.setPhotographer(photographer);
						log.setPath(uploadName);// 保存的路径，默认是upload/video/+uploadname
						log.setUploadName(uploadName);
					} else {
						System.out.println("运行到这里4");
						log = fls.findBySourceId(id);
						file = new File("upload/video", log.getUploadName());

					}

					// 初始化上传记录log后，上传视频文件
					long position = log.getPosition();
					OutputStream outStream = socket.getOutputStream();
					// String sourceid=System.currentTimeMillis()+ new
					// Random().nextInt(10);
					String response = "sourceid=" + log.getSourceId() + ";position=" + position
							+ "\r\n";
					// 服务器收到客户端的请求信息后，给客户端返回响应信息：sourceid=1274773833264;position=0
					// sourceid由服务器端生成，唯一标识上传的文件，position指示客户端从文件的什么位置开始上传
					outStream.write(response.getBytes());

					RandomAccessFile fileOutStream = new RandomAccessFile(file,
							"rwd");
					if (position == 0)
						fileOutStream.setLength(log.getSize());// 设置文件长度
					fileOutStream.seek(position);// 指定从文件的特定位置开始写入数据
					byte[] buffer = new byte[1024];
					int len = -1;
					long length = position;
					System.out.println("那里----->>>>>>>");
					while ((len = inStream.read(buffer)) != -1) {// 从输入流中读取数据写入到文件中
						fileOutStream.write(buffer, 0, len);
					//	 System.out.println("这里----->>>>>>>");
						length += len;
					}
					//测试
					if(len==-1){
						System.out.println("结束传输");
					}
					if (length ==log.getSize()) {
						System.out.println("运行到这里2");
						if (position != 0) {
							fls.delete(log.getId());
						}
						Video video = new Video();
						video.setCopyright(log.getCopyright());
						video.setDescription(log.getDescription());
						video.setInitiateName(log.getInitiateName());
						video.setPhotographer(log.getPhotographer());
						video.setSize(log.getSize());
						video.setDate(new Date());
						String uploadName = log.getUploadName();
						video.setFormat(uploadName.substring(uploadName.lastIndexOf(".")+1, uploadName.length()));
						video.setVideo(uploadName);
						video.setUploadName(uploadName);
						String preview = uploadName.substring(0,
								uploadName.indexOf("."))
								+ ".jpg";// 上传视频的预览图
						video.setPreview(preview);
						vs.save(video);
						/**
						 * 调用截图方法
						 */
						// 将“\”替换成“/”D:/apache-tomcat-7.0.52/webapps/opera2/upload/video
						System.out.println(rootPath);
						String ffmpegPath = "D:/ffmpeg/ffmpeg.bat";// ffmpeg.bat所在路径,运行ffmpeg.bat命令
						String fileNamePath = rootPath + java.io.File.separator
								+ uploadName;// 上传后视频所在路径
						// System.out.println(fileNamePath);
						String targetImgNamePath = rootPath
								+ java.io.File.separator + preview;
						// System.out.println(targetImgNamePath);
						FfmpegTool.converToImg(ffmpegPath, fileNamePath,
								targetImgNamePath);
						/**
						 * 
						 */
					} else {
						System.out.println("运行到这里3");
						log.setPosition(length);
					//	fls.save(log);
						if(log.getId()==null){
							fls.save(log);
						}else{
							fls.update(log);
						}
					}
					fileOutStream.close();
					inStream.close();
					outStream.close();

				}
			} catch (Exception e) {
				
				e.printStackTrace();
			} finally {
				
				try {
					if (socket != null && !socket.isClosed())
						socket.close();
				} catch (IOException e) {
				}
			}
		}
	}
}
