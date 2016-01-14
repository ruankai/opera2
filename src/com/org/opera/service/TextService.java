package com.org.opera.service;

import java.util.List;

import com.org.opera.base.DaoSupport;
import com.org.opera.domain.PageBean;
import com.org.opera.domain.Text;

public interface TextService extends DaoSupport<Text> {
	/**
	 * 分页查询
	 * @param keyWord
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	List<Text> findByWord(String keyWord,int currentPage,int pageSize);
	/**
	 * 统计Text实例的数目
	 * @param keyWord
	 * @return
	 */
	int getTextNumber(String keyWord);
	/**
	 * 查询分页信息
	 * @param currentPage
	 * @param pageSize
	 * @param keyword
	 * @return
	 */
	PageBean getPageBean(int currentPage, int pageSize, String keyword);
}
