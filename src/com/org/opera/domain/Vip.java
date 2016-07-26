package com.org.opera.domain;

import java.util.Date;

public class Vip {

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
	private String organizationId;
	private String companyTel;
	private String companyPlace;
	private String duty;
	private String rank;
	private String school;
	private String tenureClock;
	private String education;
	private String degree;
	private String pose;
	private String remark;
	private String type;

	public Vip() {
		
	}
	
	public Vip(Long id, String password, String name, String trueName,
			String gender, Date birthday, String place, String tel,
			String email, String wechat, String qq, String organizationId,
			String companyTel, String companyPlace, String duty, String rank,
			String school, String tenureClock, String education, String degree,
			String pose, String remark, String type) {
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
		this.organizationId = organizationId;
		this.companyTel = companyTel;
		this.companyPlace = companyPlace;
		this.duty = duty;
		this.rank = rank;
		this.school = school;
		this.tenureClock = tenureClock;
		this.education = education;
		this.degree = degree;
		this.pose = pose;
		this.remark = remark;
		this.type = type;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
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

	public String getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}

	public String getCompanyTel() {
		return companyTel;
	}

	public void setCompanyTel(String companyTel) {
		this.companyTel = companyTel;
	}

	public String getCompanyPlace() {
		return companyPlace;
	}

	public void setCompanyPlace(String companyPlace) {
		this.companyPlace = companyPlace;
	}

	public String getDuty() {
		return duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getTenureClock() {
		return tenureClock;
	}

	public void setTenureClock(String tenureClock) {
		this.tenureClock = tenureClock;
	}

	public String getPose() {
		return pose;
	}

	public void setPose(String pose) {
		this.pose = pose;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Vip [birthday=" + birthday + ", companyPlace=" + companyPlace
				+ ", companyTel=" + companyTel + ", degree=" + degree
				+ ", duty=" + duty + ", education=" + education + ", email="
				+ email + ", gender=" + gender + ", organizationId="
				+ organizationId + ", place=" + place + ", pose=" + pose
				+ ", qq=" + qq + ", rank=" + rank + ", remark=" + remark
				+ ", school=" + school + ", tel=" + tel + ", tenureClock="
				+ tenureClock + ", trueName=" + trueName + ", type=" + type
				+ ", id=" + id + ", name=" + name + ", password="
				+ password + ", wechat=" + wechat + "]";
	}

}
