package com.org.opera.domain;

import java.io.Serializable;
import java.util.Date;

public class Video implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long videoId;			
	private Date  date;
	private String photographer;
	private String  copyright;
	private String format;
	private Long  size;
	private String initiateName;
	private String  uploadName;
	private String keyword;
	private String description;
	private String video;//视频保存路径
	private String preview;//视频预览图
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
