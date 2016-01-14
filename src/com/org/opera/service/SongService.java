package com.org.opera.service;

import com.org.opera.base.DaoSupport;
import com.org.opera.domain.PageBean;
import com.org.opera.domain.Song;

public interface SongService extends DaoSupport<Song>{
	PageBean getPageBean(int currentPage, int pageSize);
}
