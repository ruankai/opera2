package com.org.opera.action;

import java.io.File;
import java.util.Date;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.opensymphony.xwork2.ActionContext;
import com.org.opera.base.BaseAction;
import com.org.opera.domain.*;
import com.org.opera.util.FileUpload;
@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class PhotoAction extends BaseAction<Photo> {
	//分页属性
	private int currentPage=1;
	private int pageSize=9;
	//上传属性
	private File upload;//封装上传文件域的属性
	private String uploadContentType;//封装上传文件类型的属性，upload是表单定义文件域 name属性值
	private String uploadFileName;//封装上传文件名的属性
	private String savePath;//保存路径，在struts.xml文件中配置的属性
	public String list() throws Exception {
		// TODO 自动生成的方法存根
		PageBean pageBean=photoService.getPageBean(currentPage, pageSize);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "list";
	}
	public String addUI() throws Exception {
		// TODO 自动生成的方法存根
		return "addUI";
	}
	public String editUI() throws Exception {
		// TODO 自动生成的方法存根
		Photo photo=photoService.getById(model.getPhotoId());
		ActionContext.getContext().getValueStack().push(photo);
		return "editUI";
	}
	public String edit() throws Exception {
		// TODO 自动生成的方法存根
		Photo photo=photoService.getById(model.getPhotoId());
		photo.setCopyright(model.getCopyright());
		photo.setKeyword(model.getKeyword());
		photo.setDescription(model.getDescription());
		photo.setPhotographer(model.getPhotographer());
		if(getUpload()!=null){
			try {
				//初始化photoUpload，准备上传
				FileUpload photoUpload=new FileUpload(savePath,upload);
				String ip=ServletActionContext.getRequest().getRemoteAddr();//取得ip;
				//设置图片上传的最终名称
				String photoName=photoUpload.getNewFileName(getUploadFileName(),ip);		
				photoUpload.uploadFile(photoName);//上传图片
				//图片的路径，也是名称
				photo.setPhoto(photoName);
				photo.setSize(upload.length());//上传文件的大小
				photo.setInitiateName(getUploadFileName());
				photo.setDate(new Date());//更改上传图片的时间
				photo.setType(getUploadContentType());//上传图片的类型
				//取得旧的图片的路径
				String filePath=ServletActionContext.getServletContext()
						.getRealPath(savePath)+java.io.File.separator
						+photo.getUploadName();
				//上传后的名称,必须先取得旧图片的路径
				photo.setUploadName(photoName);
				File f=new File(filePath);
				if(f.exists()){
					f.delete();
				}
				photoService.update(photo);
				return "toList";
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				throw e;
			}
		}else{
			photoService.update(photo);
		}
		return "toList";
	}
	public String show() throws Exception {
		// TODO 自动生成的方法存根
		Photo photo=photoService.getById(model.getPhotoId());
		String url=ServletActionContext.getServletContext().
				getContextPath()+savePath+"/"+photo.getPhoto();
		//System.out.println(url);
		ActionContext.getContext().put("url",url);
		return "show";
	}	
	public String add() throws Exception {
		// TODO 自动生成的方法存根
		Photo photo=new Photo();
		FileUpload photoUpload=new FileUpload(savePath,upload);
		photo.setCopyright(model.getCopyright());
		photo.setKeyword(model.getKeyword());
		photo.setDescription(model.getDescription());
		photo.setPhotographer(model.getPhotographer());
		photo.setDate(new Date());		
		//String ip=ServletActionContext.getRequest().getRemoteAddr();//取得ip;
		if(getUpload()!=null){
			try {
				//设置图片上传的最终名称
				String photoName=photoUpload.getNewFileName(getUploadFileName(),"127.0.0.1");
				photo.setPhoto(photoName);
				photo.setInitiateName(getUploadFileName());//上传图片的原始名称
				photo.setType(getUploadContentType());//上传图片的类型
				photo.setSize(upload.length());//上传文件的大小
				//上传后的名称
				photo.setUploadName(photoName);
				photoUpload.uploadFile(photoName);//上传图片
				photoService.save(photo);
				return "toList";
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				throw e;
			}
		}else{
		//	System.out.print(this.getUpload());
			addFieldError("null","请选择要上传的图片");
			return "addUI";
		}
		//
	}
	public String delete() throws Exception {
		// TODO 自动生成的方法存根
		try{
		photoService.delete(model.getPhotoId());
		String filePath=ServletActionContext.getServletContext()
						.getRealPath(savePath)+java.io.File.separator
						+model.getPhoto();
		//System.out.print(filePath);
		File f=new File(filePath);
		if(f.exists()){
			f.delete();
		}
		}catch(Exception e){
			throw e;
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
	public void setSavePath(String value){
		this.savePath=value;
	}
	
}
