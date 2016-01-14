package com.org.opera.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Photo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long photoId;
	private String roleName;
	private String photographer;
/*	
*/  private Date date;                           // datetime
    private Long size;                           // 大小
    private String type;                           // 类型
    private String copyright;                      //版权所属
    private String keyword;                        // 关键字
    private String description;                    // text，描述
    private String photo;							//保存路径
    private String initiateName;                   // 上传前的名称
    private String uploadName;                     //上传后的名称
    private Set<OtherPhoto> others=new HashSet<OtherPhoto>();
	public Long getPhotoId() {
		return photoId;
	}
	public void setPhotoId(Long photoId) {
		this.photoId = photoId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getPhotographer() {
		return photographer;
	}
	public void setPhotographer(String photographer) {
		this.photographer = photographer;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Long getSize() {
		return size;
	}
	public void setSize(Long size) {
		this.size = size;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCopyright() {
		return copyright;
	}
	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getInitiateName() {
		return initiateName;
	}
	public void setInitiateName(String initiateName) {
		this.initiateName = initiateName;
	}
	public String getUploadName() {
		return uploadName;
	}
	public void setUploadName(String uploadName) {
		this.uploadName = uploadName;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Set<OtherPhoto> getOthers() {
		return others;
	}
	public void setOthers(Set<OtherPhoto> others) {
		this.others = others;
	}                                
}