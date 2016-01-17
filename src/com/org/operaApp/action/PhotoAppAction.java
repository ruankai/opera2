package com.org.operaApp.action;

import java.io.File;
import java.util.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import sun.misc.BASE64Decoder;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.opensymphony.xwork2.ActionSupport;
import com.org.opera.domain.OtherPhoto;
import com.org.opera.domain.Photo;
import com.org.opera.service.OtherPhotoService;
import com.org.opera.service.PhotoService;
import com.org.opera.util.FileUpload;
import com.org.opera.util.ResponseUtil;
import com.org.opera.util.StreamTool;

@Controller
@Scope("prototype")
public class PhotoAppAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Resource(name = "photoServiceImpl")
	private PhotoService photoService;
	@Resource(name = "otherPhotoServiceImpl")
	private OtherPhotoService otherPhotoService;
	private List<Photo> photoList = new ArrayList<Photo>(); // 使用json返回list对象
	private String photoJson;// Photo的信息
	private String photoStream;// photo文件数据，用string装载
	private int status = 200;
	private Long photoId; // 用于关联photo与otherPhoto
	private String otherPhotos; // otherPhoto集合的json
	private String otherPhotoStreams;// otherPhoto文件数据，用String装载
	private int start = 0;
	private int num = 10;
	HttpServletRequest req = ServletActionContext.getRequest();
	HttpServletResponse resp = ServletActionContext.getResponse();

	public void list(){
		try {
			System.out.println("进入list方法");
			photoList = photoService.findAll(start, num);		
			ResponseUtil.writeToResp(resp, new Gson().toJson(photoList));
			resp.setStatus(200);
		} catch (Exception e) {
			e.printStackTrace();
			resp.setStatus(404);
		}
	}

	public void uploadPhoto() throws Exception {
		System.out.println(photoJson);
		String rootPath = ServletActionContext.getServletContext().getRealPath(
				getText("photoPath"));
		File dir = new File(rootPath);
		if (!dir.exists())
			dir.mkdirs();
		try {
			Photo p = null;
			p = new Gson().fromJson(photoJson, Photo.class);//
			// 生成上传后的名称
			String uploadName = new FileUpload().getNewFileName(
					p.getInitiateName(), "127.0.0.1");
			p.setUploadName(uploadName);
			p.setPhoto(uploadName);
			// System.out.println(p.getSize()+"图片大小");//图片大小
			if (photoStream != null) {
				String savePath = rootPath + java.io.File.separator
						+ uploadName;// 从资源文件中取得图片的存放路径
				byte[] input = new BASE64Decoder().decodeBuffer(photoStream);
				for (int i = 0; i < input.length; ++i) {
					if (input[i] < 0) {
						// 调整异常数据
						input[i] += 256;
					}
				}
					StreamTool.outputStream(input, savePath);// 往存放路径存放图片
					photoService.save(p);// 保存图片
				ResponseUtil.writeToResp(resp, p.getPhotoId().toString());// 返回photoId,用于添加附属图片
				resp.setStatus(200);
			} else {
				resp.setStatus(404);
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.setStatus(404);
		}
	}
/**
 * 上传附属图片会附带主图片Id,用于关联关系。插入附属图片一旦出错，会调用delete方法。
 * @throws Exception
 */
	public void uploadOthers() throws Exception {
		try {
			Photo p = photoService.getById(photoId);
			List<OtherPhoto> allotherPhotos = new Gson().fromJson(otherPhotos,
					new TypeToken<List<OtherPhoto>>() {
					}.getType());
			List<String> allOtherStreams = new Gson().fromJson(
					otherPhotoStreams, new TypeToken<List<String>>() {
					}.getType());
			String rootPath = ServletActionContext.getServletContext()
					.getRealPath(getText("othersPath"));
			File dir = new File(rootPath);
		//	System.out.print(dir.getAbsolutePath());
			if (!dir.exists()){
				dir.mkdirs();
				//System.out.println("這裡");
			}
			if (allotherPhotos.size() == allOtherStreams.size()) {
				for (int i = 0; i < allotherPhotos.size(); i++) {
					OtherPhoto op = allotherPhotos.get(i);
					String uploadName = new FileUpload().getUploadFileName(
							op.getType(), "127.0.0.1");
					op.setUploadName(uploadName);
					op.setPath(uploadName);
					String savePath = rootPath + java.io.File.separator
							+ uploadName;// 从资源文件中取得图片的存放路径
					byte[] input = new BASE64Decoder()
							.decodeBuffer(allOtherStreams.get(i));
					for (int j = 0; j < input.length; ++j) {
						if (input[j] < 0) {
							// 调整异常数据
							input[j] += 256;
						}
					}
					StreamTool.outputStream(input, savePath);// 往存放路径存放图片
					op.setPhoto(p);// 设置关联关系
					otherPhotoService.save(op);// 保存图片
				}
				ResponseUtil.writeToResp(resp, "SUCCESS");
				resp.setStatus(200);
			} else {
				resp.setStatus(404);
			}
			// 为对象进行持久化

		} catch (Exception e) {
			e.printStackTrace();
			resp.setStatus(404);
		}
	}

	/**
	 *  上传附属图片出错，客户端发送请求調用刪除方法,删除主图片及其附属图片。
	 * @throws Exception
	 */
	public void delete() throws Exception {
		// TODO 自动生成的方法存根
		try {
			System.out.println("删除主图片和附属图片");
			Photo p = photoService.getById(photoId);
			String filePath = ServletActionContext.getServletContext()
					.getRealPath(getText("photoPath"))
					+ java.io.File.separator
					+ p.getPhoto();

			File f = new File(filePath);
			if (f.exists()) {
				f.delete();
			}
			//刪除附屬圖片
			Set<OtherPhoto> others=p.getOthers();
			String othersPath=ServletActionContext.getServletContext()
					.getRealPath(getText("othersPath"))
					+ java.io.File.separator;
			for(OtherPhoto op:others){
				f=new File(othersPath+op.getPath());
				if (f.exists()) {
					f.delete();
				}
			}
			photoService.delete(p.getPhotoId());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 添加get和set方法
	public List<Photo> getPhotoList() {
		return photoList;
	}

	public void setPhotoList(List<Photo> photoList) {
		this.photoList = photoList;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getOtherPhotos() {
		return otherPhotos;
	}

	public void setOtherPhotos(String otherPhotos) {
		this.otherPhotos = otherPhotos;
	}

	public String getOtherPhotoStreams() {
		return otherPhotoStreams;
	}

	public void setOtherPhotoStreams(String otherPhotoStreams) {
		this.otherPhotoStreams = otherPhotoStreams;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getPhotoJson() {
		return photoJson;
	}

	public void setPhotoJson(String photoJson) {
		this.photoJson = photoJson;
	}

	public String getPhotoStream() {
		return photoStream;
	}

	public void setPhotoStream(String photoStream) {
		this.photoStream = photoStream;
	}

	public Long getPhotoId() {
		return photoId;
	}

	public void setPhotoId(Long photoId) {
		this.photoId = photoId;
	}

}
