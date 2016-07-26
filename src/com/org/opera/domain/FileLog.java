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
	private String path;
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
	
}
