package com.org.opera.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.org.opera.base.DaoSupportImpl;
import com.org.opera.domain.PageBean;
import com.org.opera.domain.Song;
import com.org.opera.service.SongService;
@Service
@Transactional
public class SongServiceImpl extends DaoSupportImpl<Song>implements SongService {

	public PageBean getPageBean(int currentPage, int pageSize) {
		// TODO 自动生成的方法存根
		List list=getSession().createQuery("FROM Song")
				.setFirstResult((currentPage-1)*pageSize)
				.setMaxResults(pageSize).list();
		Long count=(Long)getSession().createQuery("SELECT count(*) FROM Song")
				.uniqueResult();
		return new PageBean(currentPage, pageSize,count.intValue(),list);
	}

}
