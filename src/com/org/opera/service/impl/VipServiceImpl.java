package com.org.opera.service.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.org.opera.base.DaoSupportImpl;
import com.org.opera.domain.Vip;
import com.org.opera.service.VipService;

@Service
@Transactional
@SuppressWarnings("unchecked")
public class VipServiceImpl extends DaoSupportImpl<Vip> implements VipService {

	public int getRowCount() {
		
		String hql = "select count(*) from Vip";
		
		Query query = getSession().createQuery(hql);
		
		return Integer.parseInt(query.list().get(0).toString());
	}
	
	public List<Vip> getList(int pageNow, int pageSize) {
		
		String hql = "from Vip";
		
		Query query = getSession().createQuery(hql);
		
		query.setFirstResult((pageNow - 1) * pageSize);
		query.setMaxResults(pageSize);
		
		return query.list();
	}

	public List<Vip> queryByTrueName(String trueName) {

		String hql = "from Vip v where v.trueName like ?";
		
		return getSession().createQuery(hql).setString(0, "%"+trueName+"%").list();
	}

	public Vip login(String tel, String password) {
		// TODO 鑷姩鐢熸垚鐨勬柟娉曞瓨鏍�
		String hql="from Vip v where v.tel=? and v.password=?";
		return (Vip)getSession().createQuery(hql).setString(0, tel)
				.setString(1, password).uniqueResult();
	}

	public Vip check(String tel) {
		// TODO 鑷姩鐢熸垚鐨勬柟娉曞瓨鏍�
		String hql="from Vip v where v.tel=?";
		return (Vip)getSession().createQuery(hql).setString(0, tel)
				.uniqueResult();
	}

	

}
