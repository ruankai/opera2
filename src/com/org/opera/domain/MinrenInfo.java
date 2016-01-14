package com.org.opera.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * 名人堂信息
 * 
 * @author tyg
 * 
 */
public class MinrenInfo {
	//id	name	content详情介绍	 count点赞数
	
	private Long id;
	private String name;
	private String content;
	private int count;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
}
