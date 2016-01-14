package com.org.opera.domain;

import java.io.Serializable;
import java.util.Date;

public class Song implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long songId;	//音频编号
//	private Long performanceId;//演出编号，暂不考虑
	private String recorder	;	//记录者
	private Date date;//上传时间
	private String format;//格式
	private String copyright;//版权所属
	private Long Size;//文件大小
	private String initiateName;//文件原始名称
	private String uploadName;//文件上传后的名称
	private String keyword;//文件关键字
	private String description;//音频描述
	private String singer;//演唱者
	private String path;//音频的保存路径
	private String photo;//音频图片
	public Long getSongId() {
		return songId;
	}
	public void setSongId(Long songId) {
		this.songId = songId;
	}
	public String getRecorder() {
		return recorder;
	}
	public void setRecorder(String recorder) {
		this.recorder = recorder;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public String getCopyright() {
		return copyright;
	}
	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}
	public Long getSize() {
		return Size;
	}
	public void setSize(Long size) {
		Size = size;
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
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
}
