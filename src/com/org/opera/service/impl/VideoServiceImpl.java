package com.org.opera.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.org.opera.base.DaoSupportImpl;
import com.org.opera.domain.PageBean;
import com.org.opera.domain.Video;
import com.org.opera.service.VideoService;
@Service
@Transactional
public class VideoServiceImpl extends DaoSupportImpl<Video> implements VideoService{

	public PageBean getPageBean(int currentPage, int pageSize) {
		// TODO 自动生成的方法存根
		List list=getSession().createQuery("FROM Video")
				.setFirstResult((currentPage-1)*pageSize)
				.setMaxResults(pageSize).list();
		Long count=(Long)getSession().createQuery("SELECT count(*) FROM Video")
				.uniqueResult();
		return new PageBean(currentPage, pageSize,count.intValue(),list);
	}
	
}
