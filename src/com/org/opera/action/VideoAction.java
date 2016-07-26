package com.org.opera.action;

import java.io.File;
import java.util.Date;


import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.org.opera.base.BaseAction;
import com.org.opera.domain.PageBean;
import com.org.opera.domain.Video;
import com.org.opera.util.FfmpegTool;
import com.org.opera.util.FileUpload;
@Controller
@Scope("prototype")
public class VideoAction extends BaseAction<Video> {
	//分页属性
		private int currentPage=1;
		private int pageSize=9;
		//上传属性
		private File upload;//封装上传文件域的属性
		private String uploadContentType;//封装上传文件类型的属性，upload是表单定义文件域 name属性值
		private String uploadFileName;//封装上传文件名的属性
		private String savePath;//保存路径，在struts.xml文件中配置的属性
		/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	
	/** 列表 */
	public String list() throws Exception {
		PageBean pageBean=videoService.getPageBean(currentPage, pageSize);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "list";
	}

	/** 删除 */
	public String delete() throws Exception {
		Video video=videoService.getById(model.getVideoId());
		videoService.delete(model.getVideoId());
		String filePath=ServletActionContext.getServletContext()
				.getRealPath(savePath)+java.io.File.separator
				+video.getVideo();
		File f=new File(filePath);
		if(f.exists()){
			f.delete();
		}
		String previewPath=ServletActionContext.getServletContext()
				.getRealPath(savePath)+java.io.File.separator
				+video.getPreview();
		File p=new File(previewPath);
		if(p.exists()){
			p.delete();//删除视频预览图
		}
		return "toList";
	}

	/** 添加页面 */
	public String addUI() throws Exception {
		return "addUI";
	}

	/** 添加 */
	public String add() throws Exception {
		if(upload!=null){
			Video video=new Video();
			FileUpload videoUpload=new FileUpload(savePath,upload);
			video.setPhotographer(model.getPhotographer());
			video.setCopyright(model.getCopyright());
			video.setDescription(model.getDescription());
			video.setKeyword(model.getKeyword());
			video.setDate(new Date());
			video.setFormat(uploadContentType);
			video.setSize(upload.length());
			video.setInitiateName(uploadFileName);
			String ip=ServletActionContext.getRequest().getRemoteAddr();//取得ip;
			String videoName=videoUpload.getNewFileName(uploadFileName, ip);
			videoUpload.uploadFile(videoName);
			video.setUploadName(videoName);
			video.setVideo(videoName);
			String preview=videoName.substring(0, videoName.indexOf("."))+".jpg";//上传视频的预览图
			/**
			 * 调用截图方法
			 */
		//	ServletContext servletContext = (ServletContext)ActionContext.getContext().get(ServletActionContext.SERVLET_CONTEXT);
		//	String rootPath = servletContext.getRealPath("");D:\apache-tomcat-7.0.52\webapps\opera2
			String rootPath=videoUpload.getSavePath().replace("\\", "/");
		//	System.out.println(rootPath);
			String ffmpegPath=this.getText("ffmpegPath");//ffmpeg.bat所在路径,运行ffmpeg.bat命令
			String fileNamePath=rootPath+java.io.File.separator+videoName;//上传后视频所在路径
		//	System.out.println(fileNamePath);
			String targetImgNamePath=rootPath+java.io.File.separator+preview;
		//	System.out.println(targetImgNamePath);
			FfmpegTool.converToImg(ffmpegPath, fileNamePath, targetImgNamePath);
			/**
			 * 
			 */
			video.setPreview(preview);
			videoService.save(video);
		}else{
			addFieldError("null","请选择要上传的视频");
		}
		return "toList";
	}
	/**显示视频的截图*/
	
	public String show()throws Exception{
		String preview=model.getPreview();
		String url=ServletActionContext.getServletContext().
				getContextPath()+savePath+java.io.File.separator+preview;
	//	System.out.println(url);
		ActionContext.getContext().put("url",url);
		return "show";
	}
	public String play()throws Exception{
		String videoPath=model.getVideo();
		String rootPath=ServletActionContext.getServletContext().getRealPath(savePath);
		//songPath 该粤曲的路径
		String songPath=rootPath+java.io.File.separator+videoPath;
		Runtime r=Runtime.getRuntime();
		 String[] cmd = new String[3];
		 cmd[0]="cmd";
		 cmd[1]="/c";
		 cmd[2]="start "+songPath;
		 r.exec(cmd);
		return "toList";
	}
	/** 修改页面 */
	public String editUI() throws Exception {
		Video video=videoService.getById(model.getVideoId());
		ActionContext.getContext().getValueStack().push(video);
		return "editUI";
	}

	/** 修改 */
	public String edit() throws Exception {
		Video video=videoService.getById(model.getVideoId());
		if(getUpload()!=null){
			FileUpload videoUpload=new FileUpload(getSavePath(),getUpload());
			video.setCopyright(model.getCopyright());
			video.setDescription(model.getDescription());
			video.setPhotographer(model.getPhotographer());
			video.setKeyword(model.getKeyword());
			video.setDate(new Date());
			video.setFormat(getUploadContentType());
			video.setInitiateName(getUploadFileName());
			video.setSize(upload.length());
			String ip=ServletActionContext.getRequest().getRemoteAddr();//取得ip;
			String videoName=videoUpload.getNewFileName(uploadFileName, ip);
			videoUpload.uploadFile(videoName);
			String filePath=ServletActionContext.getServletContext()
					.getRealPath(savePath)+java.io.File.separator
					+video.getUploadName();
			File f=new File(filePath);
			if(f.exists()){
				f.delete();//删除视频
			}
			String previewPath=ServletActionContext.getServletContext()
					.getRealPath(savePath)+java.io.File.separator
					+video.getPreview();
			File p=new File(previewPath);
			if(p.exists()){
				p.delete();//删除视频预览图
			}
			String preview=videoName.substring(0, videoName.indexOf("."))+".jpg";//上传视频的预览图

			/**
			 * 调用截图方法
			 */
			//将“\”替换成“/”D:/apache-tomcat-7.0.52/webapps/opera2/upload/video
			String rootPath=videoUpload.getSavePath().replace("\\", "/");
			System.out.println(rootPath);
			String ffmpegPath=this.getText("ffmpegPath");//ffmpeg.bat所在路径,运行ffmpeg.bat命令
			String fileNamePath=rootPath+java.io.File.separator+videoName;//上传后视频所在路径
			System.out.println(fileNamePath);
			String targetImgNamePath=rootPath+java.io.File.separator+preview;
			System.out.println(targetImgNamePath);
			FfmpegTool.converToImg(ffmpegPath, fileNamePath, targetImgNamePath);
			/**
			 * 
			 */
			video.setPreview(preview);
			video.setUploadName(videoName);
			video.setVideo(videoName);
			videoService.update(video);
		}else{
			video.setCopyright(model.getCopyright());
			video.setDescription(model.getDescription());
			video.setPhotographer(model.getPhotographer());
			video.setKeyword(model.getKeyword());
			videoService.update(video);
		}
		return "toList";
	}
	//添加get和set方法
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	
}
