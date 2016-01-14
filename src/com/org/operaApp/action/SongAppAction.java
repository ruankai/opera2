package com.org.operaApp.action;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.org.opera.domain.Song;
import com.org.opera.service.SongService;
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
	private List<Song> songList=new ArrayList<Song>();
	private int start=0;
	private int num=8;
	
	/**
	 * 返回请求的song数据
	 */
	public String list(){
		songList=songService.findAll(start, num);
	//	System.out.print("zheyang"+start+"�?+num+songList);
		return SUCCESS;
	}
	
	public void addSong(){
		HttpServletRequest req=ServletActionContext.getRequest();
		HttpServletResponse resp=ServletActionContext.getResponse();
		ObjectMapper mapper=new ObjectMapper();
		String song=req.getParameter("song");
		Song songObject=null;
		try {
			 songObject=mapper.readValue(song, Song.class);
		} catch (Exception e) {
			// TODO 自动生成�?catch �?
			e.printStackTrace();
		}
		if(songObject!=null){
			try {
				InputStream input=req.getInputStream();
				String savePath=ServletActionContext.getServletContext()
						.getRealPath("/upload/song").replace("\\", "/");
				StreamTool.readStream(input, savePath);
			} catch (Exception e) {
				// TODO 自动生成�?catch �?
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	
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
}
