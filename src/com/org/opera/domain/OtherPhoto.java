package com.org.opera.domain;

public class OtherPhoto {
	private Long otherPid;	//标识符
	private String title;    //标题            
	private String uploadName;//上传 后的名称    
	private String description;//描述
	private String path;//存储的路径
	private Photo photo;
	public Long getOtherPid() {
		return otherPid;
	}
	public void setOtherPid(Long otherPid) {
		this.otherPid = otherPid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUploadName() {
		return uploadName;
	}
	public void setUploadName(String uploadName) {
		this.uploadName = uploadName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Photo getPhoto() {
		return photo;
	}
	public void setPhoto(Photo photo) {
		this.photo = photo;
	}
	
}
