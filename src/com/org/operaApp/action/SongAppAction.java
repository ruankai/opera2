package com.org.operaApp.action;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.org.opera.domain.Song;
import com.org.opera.service.FileLogService;
import com.org.opera.service.SongService;
import com.org.opera.util.FileServer;
import com.org.opera.util.SongServer;
import com.org.opera.util.StreamTool;

@Controller
@Scope("prototype")
public class SongAppAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Resource
	private SongService songService;
	@Resource
	private FileLogService fileLogService;
	private String song;
	private List<Song> songList=new ArrayList<Song>();
	private int start=0;
	private int num=8;
	HttpServletRequest req=ServletActionContext.getRequest();
	HttpServletResponse resp=ServletActionContext.getResponse();
	/**
	 * /**
	 * 使用Struts2自带的json类型，详情可看Struts.xml。推荐使用gson格式，
	 * 不过因为是较早之前的代码，就不修改了。相同的情况还有VideoAPPAction。
	 * 上传方法在InitListener监听器
	 * @return
	 * @throws Exception
	 * 返回请求的song数据
	 */
	public String list(){
		songList=songService.findAll(start, num);
		return SUCCESS;
	}			
	//上传方法在InitListener监听器
	//添加set,get方法
	public List<Song> getSongList() {
		return songList;
	}
	public void setSongList(List<Song> songList) {
		this.songList = songList;
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

	public String getSong() {
		return song;
	}

	public void setSong(String song) {
		this.song = song;
	}
	
}
