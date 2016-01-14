package com.org.opera.service;

import java.util.List;

import com.org.opera.base.DaoSupport;
import com.org.opera.domain.News;


public interface NewsService extends DaoSupport<News> {

	/**
	 * 按照时间查询所有新闻
	 * @return
	 */
	List<News> findAllDesc();

	/**
	 * 查询共有多少条记录
	 * @return
	 */
	int getRowCount();

	/**
	 * 查询所有新闻、带分页
	 * @param pageNow
	 * @param pageSize
	 * @return
	 */
	List<News> getList(int pageNow, int pageSize);

	/**
	 * 根据新闻标题查询
	 * @param title
	 * @return
	 */
	List<News> getByTitle(String title);

	/**
	 * 查询最后2条新闻，由于前台显示
	 */
	List<News> queryById1();

}
