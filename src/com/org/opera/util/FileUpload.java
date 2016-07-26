package com.org.opera.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.struts2.ServletActionContext;

import com.org.opera.util.IPTimeStamp;

public class FileUpload{
	//上传属性
	private File upload;//封装上传文件域的属性
	private String savePath;//保存路径，在struts.xml文件中配置的属性
	private String uploadName;//上传后名称
	public FileUpload(String savePath,File upload){
		this.savePath=savePath;
		this.upload=upload;
	}
	public FileUpload(){}
	// 返回上传文件的保存位置
	public String getSavePath() {
		//System.out.println(savePath);
		return ServletActionContext.getServletContext().getRealPath(savePath);
	}

	// 重写上传文件名，用当前时间+3位随机数构成无重复的文件名
	public String getNewFileName(String uploadFileName, String ip) {
		this.uploadName=new IPTimeStamp(ip).getIPTimeStampRand() +uploadFileName
				.substring(uploadFileName.lastIndexOf("."),
				uploadFileName.length());
		//取得上传文件的后缀名
		return this.uploadName;
	}
	//path由getNewFileName方法算的
	public void uploadFile(String path) throws Exception {
	//	System.out.println(getSavePath() + "\\" +	getNewFileName(uploadFileName,ip));
		FileOutputStream fos = new FileOutputStream(new File(getSavePath(),
				path));
		FileInputStream fis = new FileInputStream(upload);
		byte[] buffer = new byte[1024];
		int len = 0;
		while ((len = fis.read(buffer)) > 0) {
			fos.write(buffer, 0, len);
		}
		fos.close();
		fis.close();
	}


	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	public String getUploadName() {
		return uploadName;
	}
	public void setUploadName(String uploadName) {
		this.uploadName = uploadName;
	}
	
}
