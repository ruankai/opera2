package com.org.opera.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * 私伙局活动信息
 * 
 * @author tyg
 * 
 */
public class SihuojuInfo {
	//id	name	place	firstTime	userId(发起人)	description	type	count(点击参加的人数)
	
	private Long id;
	private String name;
	private String place;
	private Date firstTime;
	private String description;
	private int type;
	private int count;
	//------------------------
	private User user;//user属性，本类与User多对一
	private Set<SihuojuJoin> joins = new HashSet<SihuojuJoin>();//joins属性，本类与SihuojuJoin的一对多
	

	public Set<SihuojuJoin> getJoins() {
		return joins;
	}

	public void setJoins(Set<SihuojuJoin> joins) {
		this.joins = joins;
	}

	//------------------------
	
	public Long getId() {
		return id;
	}

	public Date getFirstTime() {
		return firstTime;
	}

	public void setFirstTime(Date firstTime) {
		this.firstTime = firstTime;
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

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
