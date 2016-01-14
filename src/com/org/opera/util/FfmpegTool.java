package com.org.opera.util;

import java.io.IOException;

public class FfmpegTool {
	/**
	 * 
	 * @param ffmpegPath	ffmpeg.bat所在目录(包含文件)
	 * @param fileNamePath		视频所在路径（包含文件名）
	 * @param targetImgNamePath	目标图片所在路径（包含文件名）
	 * @param order	完整命令（注意空格）
start

D:/ffmpeg/ffmpeg.exe -i %1 -ss 20 -vframes 1 -r 1 -ac 1 -ab 2 -s 160*120 -f  image2 %2  

exit		解决不弹框只需要“start”后面加一个参数“/b”就行： 
	 */
	public static void converToImg(String ffmpegPath,String fileNamePath,String targetImgNamePath){
	        try {       
	   
	            //调用批处理文件       
	   
	            Runtime.getRuntime().exec("cmd /c start /b "+ffmpegPath+" "+fileNamePath + " " + targetImgNamePath);       
	   
	        } catch (IOException e) {       
	   
	            // TODO Auto-generated catch block       
	   
	            e.printStackTrace();       
	   
	        }     
	}
}
