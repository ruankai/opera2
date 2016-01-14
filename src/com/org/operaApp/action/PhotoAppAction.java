package com.org.operaApp.action;

import java.io.File;
import java.io.InputStream;
import java.util.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;
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
public class PhotoAppAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Resource(name="photoServiceImpl")
	private PhotoService photoService;
	@Resource(name="otherPhotoServiceImpl")
	private OtherPhotoService otherPhotoService;
	private List<Photo> photoList;		//使用json返回list对象
	private String photoJson;
	private int status=200;
	private String otherPhoto;
	private int start=0;
	private int num=10;
	
	
	HttpServletRequest req=ServletActionContext.getRequest();
	HttpServletResponse resp=ServletActionContext.getResponse();
	
	
	public String list()throws Exception{
		photoList=new ArrayList<Photo>();
		photoList=photoService.findAll(start, num);
		return SUCCESS;
	}
	public void uploadPhoto()throws Exception{
		
		try{
		Photo p=null;
		p=new Gson().fromJson(photoJson, Photo.class);//
		p.setDate(new Date());
		//生成上传后的名称
		String uploadName=new FileUpload().getNewFileName
				(p.getInitiateName(), req.getRemoteAddr());
		p.setUploadName(uploadName);
		p.setPhoto(uploadName);
		InputStream input=req.getInputStream();
		String rootPath=ServletActionContext.getServletContext()
			.getRealPath(getText("photoPath"));
		File dir=new File(getText("photoPath"));
		if(!dir.exists()) dir.mkdirs();
		String savePath=rootPath+java.io.File.separator+uploadName;//从资源文件中取得图片的存放路�?
		StreamTool.readStream(input, savePath);//�?��放路径存放图�?
		photoService.save(p);//保存图片
		ResponseUtil.writeToResp(resp, p.getPhotoId().toString());//返回给移动端主图片id
		resp.setStatus(200);
		}catch(Exception e){		
			e.printStackTrace();
			resp.setStatus(404);
		}
	}
	public void uploadOthers()throws Exception{
		Long photoId=Long.parseLong(req.getParameter("photoId"));
		OtherPhoto op=null;
		try{
		op=new Gson().fromJson(otherPhoto, OtherPhoto.class);
		String uploadName=new FileUpload().getNewFileName
				(op.getTitle(), req.getRemoteAddr());
		op.setUploadName(uploadName);
		op.setPath(uploadName);
		InputStream input=req.getInputStream();
		String rootPath=ServletActionContext.getServletContext()
			.getRealPath(getText("othersPath"));
		File dir=new File(getText("othersPath"));
		if(!dir.exists()) dir.mkdirs();
		String savePath=rootPath+java.io.File.separator+uploadName;//从资源文件中取得图片的存放路�?
		StreamTool.readStream(input, savePath);//�?��放路径存放图�?
		
		//为对象进行持久化
		Photo p=photoService.getById(photoId);
		op.setPhoto(p);//设置关联关系
		otherPhotoService.save(op);//保存图片
		resp.setStatus(200);
		}catch(Exception e){		
			e.printStackTrace();
			resp.setStatus(404);
		}
	}
	
//添加get和set方法
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
	public String getOtherPhoto() {
		return otherPhoto;
	}
	public void setOtherPhoto(String otherPhoto) {
		this.otherPhoto = otherPhoto;
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

	
	
}
