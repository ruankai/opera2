package com.org.opera.service;

import java.util.List;

import com.org.opera.base.DaoSupport;
import com.org.opera.domain.News;


public interface NewsService extends DaoSupport<News> {

	/**
	 * ����ʱ���ѯ��������
	 * @return
	 */
	List<News> findAllDesc();

	/**
	 * ��ѯ���ж�������¼
	 * @return
	 */
	int getRowCount();

	/**
	 * ��ѯ�������š�����ҳ
	 * @param pageNow
	 * @param pageSize
	 * @return
	 */
	List<News> getList(int pageNow, int pageSize);

	/**
	 * �������ű����ѯ
	 * @param title
	 * @return
	 */
	List<News> getByTitle(String title);

	/**
	 * ��ѯ���2�����ţ�����ǰ̨��ʾ
	 */
	List<News> queryById1();

}
