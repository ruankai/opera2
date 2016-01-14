package com.org.opera.util;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.org.opera.service.FileLogService;
import com.org.opera.service.VideoService;

public class InitListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO 自动生成的方法存根

	}

	public void contextInitialized(ServletContextEvent arg0) {
		// 获取容器与相关的Service对象
		final ServletContext sc=arg0.getServletContext();
		new Thread(new Runnable(){

			public void run() {
				// TODO 自动生成的方法存根
				ApplicationContext ac=WebApplicationContextUtils.
						getWebApplicationContext(sc);
				VideoService videoService=(VideoService)ac.getBean("videoServiceImpl");		
				FileLogService fileLogService=(FileLogService)ac.getBean("fileLogServiceImpl");
				String rootPath=sc.getRealPath("upload/video")
						.replace("\\", "/");
				FileServer fs=new FileServer(7879, fileLogService, videoService,rootPath);
				System.out.print("初始化监听器，监听7879端口，准备传输视频数据");
				try {
					fs.start();
				} catch (Exception e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
			
		}).start();
		
	}

}
