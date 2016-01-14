package com.org.opera.service;

import com.org.opera.base.DaoSupport;
import com.org.opera.domain.PageBean;
import com.org.opera.domain.Photo;

public interface PhotoService extends DaoSupport<Photo> {
	PageBean getPageBean(int currentPage, int pageSize);
}
