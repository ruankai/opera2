package com.org.opera.domain;

import java.util.Date;


/**
 * 微课�?
 * 
 * @author tao
 * 
 */
public class Course {
	//id	name 	time	description	 movUrl  resUrl  userId(发起�?
	
	private Long id;
	private String name;
	private Date time;
	private String description;
	private String movUrl;
	private String resUrl;
	private String imgUrl;
	//------------------------
	private User user;//user属�?，本类与User多对�?
	//------------------------
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
	
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getMovUrl() {
		return movUrl;
	}
	public void setMovUrl(String movUrl) {
		this.movUrl = movUrl;
	}
	public String getResUrl() {
		return resUrl;
	}
	public void setResUrl(String resUrl) {
		this.resUrl = resUrl;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
