package com.org.opera.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 私伙局参与人员信息
 * 
 * @author tyg
 * 
 */
public class SihuojuJoin {
	
	
	private Long id;
	private int type;
	
	//------------------------
	private User user;//user属性，本类与User多对一 ，一个人可以参加多个活动
	private SihuojuInfo sihuojuinfo;//sihuojuinfo属性，本类与SihuojuInfo多对一，一个活动可以有多个参加者
	
	//------------------------
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public SihuojuInfo getSihuojuinfo() {
		return sihuojuinfo;
	}
	public void setSihuojuinfo(SihuojuInfo sihuojuinfo) {
		this.sihuojuinfo = sihuojuinfo;
	}

	
	
	
}
