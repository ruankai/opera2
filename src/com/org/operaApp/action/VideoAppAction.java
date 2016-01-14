package com.org.operaApp.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.org.opera.domain.Video;
import com.org.opera.service.VideoService;
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
	public String list()throws Exception{
		videoList=new ArrayList<Video>();
		videoList=videoService.findAll(start, num);
		System.out.println(videoList);
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
