package com.org.opera.action;

import java.io.File;
import java.util.Date;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.org.opera.base.BaseAction;
import com.org.opera.domain.PageBean;
import com.org.opera.domain.Song;
import com.org.opera.domain.Video;
import com.org.opera.util.FileUpload;
@Controller
@Scope("prototype")
public class SongAction extends BaseAction<Song> {
	//分页属性
	private int currentPage=1;
	private int pageSize=10;
	//上传属性
	private File upload;//封装上传文件域的属性
	private String uploadContentType;//封装上传文件类型的属性，upload是表单定义文件域 name属性值
	private String uploadFileName;//封装上传文件名的属性
	//保存路径
	private String savePath;
	/** 列表 */
	public String list() throws Exception {
		PageBean pageBean=songService.getPageBean(currentPage, pageSize);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "list";
	}
	/** 添加页面 */
	public String addUI() throws Exception {
		return "addUI";
	}
	/** 删除 */
	public String delete() throws Exception {
		Song song=songService.getById(model.getSongId());
		songService.delete(song.getSongId());
		String filePath=ServletActionContext.getServletContext()
				.getRealPath(savePath)+java.io.File.separator
				+song.getPath();
		System.out.println(filePath);
		File f=new File(filePath);
		if(f.exists()){
			f.delete();
		}
		return "toList";
	}
	/** 添加 */
	public String add() throws Exception {
		if(upload!=null){
			Song song=new Song();
			FileUpload songUpload=new FileUpload(savePath,upload);
			song.setRecorder(model.getRecorder());
			song.setCopyright(model.getCopyright());
			song.setDescription(model.getDescription());
			song.setKeyword(model.getKeyword());
			song.setSinger(model.getSinger());
			song.setDate(new Date());
			song.setFormat(uploadContentType);
			song.setSize(upload.length());
			song.setInitiateName(uploadFileName);
			String ip=ServletActionContext.getRequest().getRemoteAddr();//取得ip;
			String songName=songUpload.getNewFileName(uploadFileName, ip);
			songUpload.uploadFile(songName);
			song.setUploadName(songName);
			song.setPath(songName);
			songService.save(song);
		}else{
			addFieldError("null","请选择要上传的音频");
		}
		return "toList";
	}
	/**查看"粤曲*/
	public String show()throws Exception{
		String path=model.getPath();
		//rootPath 存放粤曲的文件夹路径
		String rootPath=ServletActionContext.getServletContext().getRealPath(savePath);
		//songPath 该粤曲的路径
		String songPath=rootPath+java.io.File.separator+path;
		Runtime r=Runtime.getRuntime();
		 String[] cmd = new String[3];
		 cmd[0]="cmd";
		 cmd[1]="/c";
		 cmd[2]="start "+songPath;
		 r.exec(cmd);
		 return "toList";
	}
	
	/** 修改页面 */
	public String editUI() throws Exception {
		Song song=songService.getById(model.getSongId());
		ActionContext.getContext().getValueStack().push(song);
		return "editUI";
	}
	/** 修改*/
	public String edit() throws Exception {
		Song song=songService.getById(model.getSongId());
		if(getUpload()!=null){
			FileUpload songUpload=new FileUpload(getSavePath(),getUpload());
			song.setCopyright(model.getCopyright());
			song.setDescription(model.getDescription());
			song.setRecorder(model.getRecorder());
			song.setSinger(model.getSinger());
			song.setKeyword(model.getKeyword());
			song.setDate(new Date());
			song.setFormat(getUploadContentType());
			song.setInitiateName(getUploadFileName());
			song.setSize(upload.length());
			String ip=ServletActionContext.getRequest().getRemoteAddr();//取得ip;
			String songName=songUpload.getNewFileName(uploadFileName, ip);
			songUpload.uploadFile(songName);
			String filePath=ServletActionContext.getServletContext()
					.getRealPath(savePath)+java.io.File.separator
					+song.getUploadName();
			File f=new File(filePath);
			if(f.exists()){
				f.delete();
			}
			song.setUploadName(songName);
			song.setPath(songName);
			songService.update(song);
		}else{
			song.setCopyright(model.getCopyright());
			song.setDescription(model.getDescription());
			song.setRecorder(model.getRecorder());
			song.setKeyword(model.getKeyword());
			song.setSinger(model.getSinger());
			songService.update(song);
		}
		return "toList";
	}
//添加get和set方法
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public String getSavePath() {
		return savePath;
	}
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	
}
