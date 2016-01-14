package com.org.opera.util;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

public class ResponseUtil {
	public static void writeToResp(HttpServletResponse resp,String text){
		OutputStream out=null;
		try{
			out=resp.getOutputStream();
			out.write(text.getBytes("UTF-8"));
			out.flush();
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			if(out!=null){
				try{
					out.close();
				}catch(IOException e){
					e.printStackTrace();
				}
			}
		}
	}
}
