package com.org.operaApp.action;

import java.io.PushbackInputStream;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.org.opera.domain.Vip;
import com.org.opera.service.VipService;
import com.org.opera.util.ResponseUtil;
import com.org.opera.util.StreamTool;
@Controller
@Scope("prototype")
public class VipAppAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String tel;//电话号码
	private String password;//密码
	private Vip vip;//id
	@Resource
	private VipService vipService;
	HttpServletResponse resp=ServletActionContext.getResponse();
	/**
	 * 登录
	 */
	public void login()throws Exception{
		System.out.println(tel+","+password);		
			Vip vip=vipService.login(tel, password);//根据电话和密码查找
			if(vip==null){
				resp.setStatus(404);
			}else{
				ResponseUtil.writeToResp(resp, new Gson().toJson(vip));
				resp.setStatus(200);
			}
		//return SUCCESS;
	}
	/**
	 * 注册
	 */
	/*public void register(){
			Vip vip=vipService.check(tel);
			if(vip==null){
				vip=new Vip();
				vip.setTel(tel);
				vip.setPassword(password);
				vipService.save(vip);
				resp.setStatus(200);
				ResponseUtil.writeToResp(resp, "1");//没有注册过
			}else{
				resp.setStatus(200);
				ResponseUtil.writeToResp(resp, "0");//已注册过
			}
	}*/
	/**
	 * 忘记密码
	 */
	public void forgotpwd(){
		Vip vip=vipService.check(tel);
		if(vip==null){
			resp.setStatus(400);//没有注册过
		}else{
			vip.setPassword(password);//重新修改密码
			vipService.save(vip);
			resp.setStatus(200);
		}
	} 
	public void memInfo(){
		Gson gson=new Gson();
		HttpServletRequest req=ServletActionContext.getRequest();
		Vip vip=null;
		try {
			PushbackInputStream input=new PushbackInputStream(req.getInputStream());
			String obj=StreamTool.readLine(input);
			String vipObject=new String(obj.getBytes("iso-8859-1"),"utf-8");
			vip=gson.fromJson(vipObject,Vip.class);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		if(vip!=null){
			try{
			vipService.update(vip);
			}catch(Exception e){
				e.printStackTrace();
			}
			resp.setStatus(200);
		}else{
			resp.setStatus(404);
		}
	}
//添加get和set方法
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Vip getVip() {
		return vip;
	}
	public void setVip(Vip vip) {
		this.vip = vip;
	}


	
	
}
