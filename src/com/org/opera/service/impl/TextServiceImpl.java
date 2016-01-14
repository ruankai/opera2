package com.org.opera.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.org.opera.base.DaoSupportImpl;
import com.org.opera.domain.PageBean;
import com.org.opera.domain.Text;
import com.org.opera.service.TextService;
@Service
@Transactional
public class TextServiceImpl extends DaoSupportImpl<Text> implements TextService {

	public List<Text> findByWord(String keyWord, int currentPage, int pageSize) {
		// TODO 自动生成的方法存根
		String hql="from Text as t where t.title like ? or t.themes like ? " +
				"or t.author like ? ";
		Query q=getSession().createQuery(hql).setString(0,"%"+keyWord+"%").
				setString(1,"%"+keyWord+"%").setString(2, "%"+keyWord+"%")
				.setFirstResult((currentPage-1)*pageSize).setMaxResults(pageSize);

		return q.list();
	}

	public int getTextNumber(String keyWord) {
		// TODO 自动生成的方法存根
		String hql="from Text as t where t.title like ? or t.themes like ? " +
				"or t.author like ? ";
		Query q=getSession().createQuery(hql).setString(0,"%"+keyWord+"%").
				setString(1,"%"+keyWord+"%").setString(2, "%"+keyWord+"%");
		
		return q.list().size();
	}

	public PageBean getPageBean(int currentPage, int pageSize, String keyword) {
		// TODO 自动生成的方法存根
		List list=getSession().createQuery(//
				"FROM Text as t WHERE t.title like ? or t.themes like ?" +
				" or t.author like ?").setString(0,"%"+keyword+"%")
				.setString(1,"%"+keyword+"%").setString(2,"%"+keyword+"%")
				.setFirstResult((currentPage-1)*pageSize)
				.setMaxResults(pageSize).list();
		Long count=(Long)getSession().createQuery(//
				"SELECT count(*) FROM Text as t WHERE t.title like ? or t.themes like ?" +
				" or t.author like ?").setString(0,"%"+keyword+"%")
				.setString(1,"%"+keyword+"%").setString(2,"%"+keyword+"%")
				.uniqueResult();
		return new PageBean(currentPage,pageSize,count.intValue(),list);
	}

}