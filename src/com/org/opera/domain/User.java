package com.org.opera.domain;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String password;
	private String name;
	private String trueName;
	private String gender;
	private Date birthday;
	private String place;
	private String tel;
	private String email;
	private String wechat;
	private String qq;

	public User() {
		
	}
	
	public User(Long id, String password, String name,
			String trueName, String gender, Date birthday, String place,
			String tel, String email, String wechat, String qq) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.trueName = trueName;
		this.gender = gender;
		this.birthday = birthday;
		this.place = place;
		this.tel = tel;
		this.email = email;
		this.wechat = wechat;
		this.qq = qq;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWechat() {
		return wechat;
	}

	public void setWechat(String wechat) {
		this.wechat = wechat;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	@Override
	public String toString() {
		return "User [birthday=" + birthday + ", email=" + email + ", gender="
				+ gender + ", place=" + place + ", qq=" + qq + ", tel=" + tel
				+ ", trueName=" + trueName + ", id=" + id
				+ ", name=" + name + ", password=" + password
				+ ", wechat=" + wechat + "]";
	}

}
