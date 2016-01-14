package com.org.opera.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.org.opera.base.DaoSupportImpl;
import com.org.opera.domain.PageBean;
import com.org.opera.domain.Photo;
import com.org.opera.service.PhotoService;
@Service
@Transactional
public class PhotoServiceImpl extends DaoSupportImpl<Photo> implements PhotoService{

	public PageBean getPageBean(int currentPage, int pageSize) {
		// TODO 自动生成的方法存根
		List list=getSession().createQuery("FROM Photo")
				.setFirstResult((currentPage-1)*pageSize)
				.setMaxResults(pageSize).list();
		Long count=(Long)getSession().createQuery("SELECT count(*) FROM Photo")
				.uniqueResult();
		return new PageBean(currentPage, pageSize,count.intValue(),list);
	}

}
