package com.org.operaApp.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.org.opera.domain.Video;
import com.org.opera.service.VideoService;
import com.org.opera.util.ResponseUtil;
@Controller
@Scope("prototype")
public class VideoAppAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Resource(name="videoServiceImpl")
	private  VideoService videoService;
	private List<Video> videoList;
	private int start=0;
	private int num=10;
	/**
	 * 使用Struts2自带的json类型，详情可看Struts.xml。推荐使用gson格式，
	 * 不过因为是较早之前的代码，就不修改了。相同的情况还有SongAPPAction。
	 * 上传方法在InitListener监听器
	 * @return
	 * @throws Exception
	 */
	public String list()throws Exception{
		videoList=new ArrayList<Video>();
		videoList=videoService.findAll(start, num);
		//System.out.println(videoList);
		/**注释的部分是gson的使用方法。
		 * ResponseUtil完成将字符串转换成字节流输出。
		 * ResponseUtil.writeToResp(resp, new Gson().toJson(photoList));
		 */
		return SUCCESS;
	}
	//添加get和set方法	
	public List<Video> getVideoList() {
		return videoList;
	}
	public void setVideoList(List<Video> videoList) {
		this.videoList = videoList;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}

	
}
