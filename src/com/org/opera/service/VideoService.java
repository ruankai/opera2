package com.org.opera.service;

import com.org.opera.base.DaoSupport;
import com.org.opera.domain.PageBean;
import com.org.opera.domain.Video;

public interface VideoService extends DaoSupport<Video> {
	PageBean getPageBean(int currentPage, int pageSize);
}
