package com.org.opera.domain;

import java.io.Serializable;
import java.util.Date;

public class Video implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long videoId;			
	private Date  date;//上传时间
	private String photographer;//拍摄者
	private String  copyright;//版权所属
	private String format;//格式
	private Long  size;//大小
	private String initiateName;//视频原来的名称
	private String  uploadName;//上传后的名称
	private String keyword;//关键词
	private String description;
	private String video;//视频保存路径
	private String preview;//视频预览图路径
	public Long getVideoId() {
		return videoId;
	}
	public void setVideoId(Long videoId) {
		this.videoId = videoId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getPhotographer() {
		return photographer;
	}
	public void setPhotographer(String photographer) {
		this.photographer = photographer;
	}
	public String getCopyright() {
		return copyright;
	}
	public void setCopyright(String copyright) {
		this.copyright = copyright;
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
	public String getVideo() {
		return video;
	}
	public void setVideo(String video) {
		this.video = video;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public Long getSize() {
		return size;
	}
	public void setSize(Long size) {
		this.size = size;
	}
	public String getPreview() {
		return preview;
	}
	public void setPreview(String preview) {
		this.preview = preview;
	}
	
}
