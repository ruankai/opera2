package com.org.operaApp.action;


import java.io.PushbackInputStream;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.bind.DateTypeAdapter;
import com.opensymphony.xwork2.ActionSupport;
import com.org.opera.domain.User;
import com.org.opera.domain.Vip;
import com.org.opera.service.*;
import com.org.opera.util.ResponseUtil;
import com.org.opera.util.StreamTool;
@Controller
@Scope("prototype")
public class UserAppAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Resource
	private UserService userService;
	private String telephone;//电话号码
	private String password;//密码
	private Long userId; //用户id
	private User user;
	HttpServletResponse resp=ServletActionContext.getResponse();
	HttpServletRequest req=ServletActionContext.getRequest();
	/**
	 * 登录
	 */
	public void login(){
			User user=userService.login(telephone, password);//根据电话和密码查找
			if(user==null){
				System.out.println("出错了");
				
				resp.setStatus(404);
			}else{
				this.user=user;
			//	System.out.println(this.user);
				System.out.println("登录成功");
				System.out.println("成功了");
				ResponseUtil.writeToResp(resp,new Gson().toJson(this.user));
				resp.setStatus(200);
			}
		//return SUCCESS;
	}
	/**
	 * 注册
	 */
	public void register(){
			User user=userService.check(telephone);
			System.out.println("注册信息");
			if(user==null){
				System.out.println("还未注册的");
				user=new User();
				user.setTel(telephone);
				user.setPassword(password);
				userService.save(user);
			//	this.status="1";//还未注册的
				//this.user =null;
				
				resp.setStatus(200);
				ResponseUtil.writeToResp(resp, "1");
			}else{		
				System.out.println("已注册的");		
				resp.setStatus(200);
				ResponseUtil.writeToResp(resp, "0");
			}
	}
	/**
	 * 获取个人
	 * @param telephone
	 */
	public void getMemInfo(){
		User user=userService.check(telephone);
		System.out.println(telephone);
		if(user!=null){
			resp.setStatus(200);
		}else{
			resp.setStatus(404);
		}
	}
	/**
	 * 忘记密码
	 */
	public void forgotpwd(){
		User user=userService.check(telephone);
		if(user==null){
			resp.setStatus(404);//没有注册过
		}else{
			user.setPassword(password);//重新修改密码
			userService.save(user);
			resp.setStatus(200);
		}
	}
	/**
	 * 修改个人信息
	 */
	public void memInfo(){
		System.out.print("运行到这里");		
		User u=null;
			try {
			//	System.out.println("进入try方法");
				//使用BufferedReader提高效率
				PushbackInputStream inStream = new PushbackInputStream(
						req.getInputStream());
				String obj=StreamTool.readLine(inStream);
				/*Gson jsonUser=new Gson();*/
				String userObject=new String(new String(obj).getBytes("iso-8859-1"),"utf-8");
			//	String userObject=new String(obj);
				Gson jsonUser = new GsonBuilder().setDateFormat("yyyy-MM-dd")
					    .registerTypeAdapter(Date.class, new DateTypeAdapter()).create();
				u=jsonUser.fromJson(userObject, User.class);				
				obj=null;//垃圾回收
				/*JSONUtils.getMorpherRegistry().registerMorpher(
						new DateMorpher(new String[] {"yyyy-MM-dd","yyyy-MM-dd HH:mm:ss"}) );
				u=(User)JSONObject.toBean(jsonUser, User.class);*/
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
		}finally{
		if(u!=null){
		//	System.out.print(u.getBirthday());
		//	System.out.println(u.getGender());
			userService.update(u);
			resp.setStatus(200);
		}else{
			resp.setStatus(404);
		}
		}
	}
	/**
	 * 升级普通用户为高级用户
	 */
	public void upGrade(){
		Gson gson=new Gson();
		System.out.println("升级用户");
		Vip v=null;
		try {
			PushbackInputStream inStream = new PushbackInputStream(
					req.getInputStream());
			String obj=StreamTool.readLine(inStream);
			String userObject=new String(new String(obj).getBytes("iso-8859-1"),"utf-8");
			v=gson.fromJson(userObject, Vip.class);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally{
		if(v!=null){
			userService.upGrade(userId, v);
			resp.setStatus(200);
		}else{
			resp.setStatus(404);
		}
		}
	}
//添加get和set方法
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
/*	public String getVip() {
		return vip;
	}
	public void setVip(String vip) {
		this.vip = vip;
	}*/
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	/*public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}*/
	
}
