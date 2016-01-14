package com.org.opera.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * 绉佷紮灞�椿鍔ㄤ俊鎭�
 * 
 * @author tyg
 * 
 */
public class SihuojuInfo {
	//id	name	place	firstTime	userId(鍙戣捣浜�	description	type	count(鐐瑰嚮鍙傚姞鐨勪汉鏁�
	
	private Long id;
	private String name;
	private String place;
	private Date firstTime;
	private String description;
	private int type;
	private int count;
	//------------------------
	private User user;//user灞炴�锛屾湰绫讳笌User澶氬涓�
	private Set<SihuojuJoin> joins = new HashSet<SihuojuJoin>();//joins灞炴�锛屾湰绫讳笌SihuojuJoin鐨勪竴瀵瑰
	

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
