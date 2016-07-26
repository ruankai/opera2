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
	//鍒嗛〉灞炴�
	private int currentPage=1;
	private int pageSize=9;
	//涓婁紶灞炴�
	private File upload;//灏佽涓婁紶鏂囦欢鍩熺殑灞炴�
	private String uploadContentType;//灏佽涓婁紶鏂囦欢绫诲瀷鐨勫睘鎬э紝upload鏄〃鍗曞畾涔夋枃浠跺煙 name灞炴�鍊�
	private String uploadFileName;//灏佽涓婁紶鏂囦欢鍚嶇殑灞炴�
	private String savePath;//淇濆瓨璺緞锛屽湪struts.xml鏂囦欢涓厤缃殑灞炴�
	public String list() throws Exception {
		// TODO 鑷姩鐢熸垚鐨勬柟娉曞瓨鏍�
		PageBean pageBean=photoService.getPageBean(currentPage, pageSize);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "list";
	}
	public String addUI() throws Exception {
		// TODO 鑷姩鐢熸垚鐨勬柟娉曞瓨鏍�
		return "addUI";
	}
	public String editUI() throws Exception {
		// TODO 鑷姩鐢熸垚鐨勬柟娉曞瓨鏍�
		Photo photo=photoService.getById(model.getPhotoId());
		ActionContext.getContext().getValueStack().push(photo);
		return "editUI";
	}
	public String edit() throws Exception {
		// TODO 鑷姩鐢熸垚鐨勬柟娉曞瓨鏍�
		Photo photo=photoService.getById(model.getPhotoId());
		photo.setCopyright(model.getCopyright());
		photo.setKeyword(model.getKeyword());
		photo.setDescription(model.getDescription());
		photo.setPhotographer(model.getPhotographer());
		if(getUpload()!=null){
			try {
				//鍒濆鍖杙hotoUpload锛屽噯澶囦笂浼�
				FileUpload photoUpload=new FileUpload(savePath,upload);
				String ip=ServletActionContext.getRequest().getRemoteAddr();//鍙栧緱ip;
				//璁剧疆鍥剧墖涓婁紶鐨勬渶缁堝悕绉�
				String photoName=photoUpload.getNewFileName(getUploadFileName(),ip);		
				photoUpload.uploadFile(photoName);//涓婁紶鍥剧墖
				//鍥剧墖鐨勮矾寰勶紝涔熸槸鍚嶇О
				photo.setPhoto(photoName);
				photo.setSize(upload.length());//涓婁紶鏂囦欢鐨勫ぇ灏�
				photo.setInitiateName(getUploadFileName());
				photo.setDate(new Date());//鏇存敼涓婁紶鍥剧墖鐨勬椂闂�
				photo.setType(getUploadContentType());//涓婁紶鍥剧墖鐨勭被鍨�
				//鍙栧緱鏃х殑鍥剧墖鐨勮矾寰�
				String filePath=ServletActionContext.getServletContext()
						.getRealPath(savePath)+java.io.File.separator
						+photo.getUploadName();
				//涓婁紶鍚庣殑鍚嶇О,蹇呴』鍏堝彇寰楁棫鍥剧墖鐨勮矾寰�
				photo.setUploadName(photoName);
				File f=new File(filePath);
				if(f.exists()){
					f.delete();
				}
				photoService.update(photo);
				return "toList";
			} catch (Exception e) {
				// TODO 鑷姩鐢熸垚鐨�catch 鍧�
				throw e;
			}
		}else{
			photoService.update(photo);
		}
		return "toList";
	}
	public String show() throws Exception {
		// TODO 鑷姩鐢熸垚鐨勬柟娉曞瓨鏍�
		Photo photo=photoService.getById(model.getPhotoId());
		String url=ServletActionContext.getServletContext().
				getContextPath()+savePath+"/"+photo.getPhoto();
		//System.out.println(url);
		ActionContext.getContext().put("url",url);
		return "show";
	}	
	public String add() throws Exception {
		// TODO 鑷姩鐢熸垚鐨勬柟娉曞瓨鏍�
		Photo photo=new Photo();
		FileUpload photoUpload=new FileUpload(savePath,upload);
		photo.setCopyright(model.getCopyright());
		photo.setKeyword(model.getKeyword());
		photo.setDescription(model.getDescription());
		photo.setPhotographer(model.getPhotographer());
		photo.setDate(new Date());		
		String ip=ServletActionContext.getRequest().getRemoteAddr();//鍙栧緱ip;
		if(getUpload()!=null){
			try {
				//璁剧疆鍥剧墖涓婁紶鐨勬渶缁堝悕绉�
				String photoName=photoUpload.getNewFileName(getUploadFileName(),ip);
				photo.setPhoto(photoName);
				photo.setInitiateName(getUploadFileName());//涓婁紶鍥剧墖鐨勫師濮嬪悕绉�
				photo.setType(getUploadContentType());//涓婁紶鍥剧墖鐨勭被鍨�
				photo.setSize(upload.length());//涓婁紶鏂囦欢鐨勫ぇ灏�
				//涓婁紶鍚庣殑鍚嶇О
				photo.setUploadName(photoName);
				photoUpload.uploadFile(photoName);//涓婁紶鍥剧墖
				photoService.save(photo);
				return "toList";
			} catch (Exception e) {
				// TODO 鑷姩鐢熸垚鐨�catch 鍧�
				throw e;
			}
		}else{
		//	System.out.print(this.getUpload());
			addFieldError("null","璇烽�鎷╄涓婁紶鐨勫浘鐗�");
			return "addUI";
		}
		//
	}
	public String delete() throws Exception {
		// TODO 鑷姩鐢熸垚鐨勬柟娉曞瓨鏍�
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
//娣诲姞get鍜宻et鏂规硶
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
