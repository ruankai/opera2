package com.org.opera.service.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.org.opera.base.DaoSupportImpl;
import com.org.opera.domain.News;
import com.org.opera.service.NewsService;

@Service
@Transactional
@SuppressWarnings("unchecked")
public class NewsServiceImpl extends DaoSupportImpl<News> implements
		NewsService {

	public List<News> findAllDesc() {

		String hql = "from News n order by n.id desc";

		return getSession().createQuery(hql).list();
	}

	public int getRowCount() {
		
		String hql = "select count(*) from News";
		
		Query query = getSession().createQuery(hql);
		
		return Integer.parseInt(query.list().get(0).toString());
	}

	public List<News> getList(int pageNow, int pageSize) {
		
		String hql = "from News";

		return getSession().createQuery(hql).setFirstResult(
				(pageNow - 1) * pageSize).setMaxResults(pageSize).list();
	}

	public List<News> getByTitle(String title) {
		
		String hql = "from News n where n.title like ?";
		
		return getSession().createQuery(hql).setParameter(0, "%"+title+"%").list();
	}

	public List<News> queryById1() {

		String hql = "from News n order by n.id desc";
		
		return getSession().createQuery(hql).setFirstResult(0).setMaxResults(2).list();
	}

}
