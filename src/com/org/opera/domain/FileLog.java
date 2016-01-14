package com.org.opera.domain;

import java.io.Serializable;
/**
 * 该类用于保存断点数据，
 * @Path	断点数据保存的路径
 * @author Administrator
 *
 */
public class FileLog implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String sourceId;//用于验证上传记录是否存在
	private String path;
	private String initiateName;//视频原来的名称
	private String uploadName;//上传后的名称
	private String description;//视频的描述
	private String copyright;//版权所属
	private Long size;//视频大小（B)
	private Long position;//已上传的大小(B)
	private String photographer;//拍摄者
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getInitiateName() {
		return initiateName;
	}
	public void setInitiateName(String initiateName) {
		this.initiateName = initiateName;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCopyright() {
		return copyright;
	}
	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}
	public Long getSize() {
		return size;
	}
	public void setSize(Long size) {
		this.size = size;
	}
	public Long getPosition() {
		return position;
	}
	public void setPosition(Long position) {
		this.position = position;
	}
	public String getUploadName() {
		return uploadName;
	}
	public void setUploadName(String uploadName) {
		this.uploadName = uploadName;
	}
	public String getPhotographer() {
		return photographer;
	}
	public void setPhotographer(String photographer) {
		this.photographer = photographer;
	}
	public String getSourceId() {
		return sourceId;
	}
	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}
	
}
