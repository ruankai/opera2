package com.org.opera.service.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.org.opera.base.DaoSupportImpl;
import com.org.opera.domain.User;
import com.org.opera.domain.Vip;
import com.org.opera.service.UserService;

@Service
@Transactional
@SuppressWarnings("unchecked")
public class UserSerciveImpl extends DaoSupportImpl<User> implements UserService {

	public int getRowCount() {
		
		String hql = "select count(*) from User";
		
		Query query = getSession().createQuery(hql);
		
		return Integer.parseInt(query.list().get(0).toString());
	}
	
	public List<User> getList(int pageNow, int pageSize) {
		
		String hql = "from User";
		
		Query query = getSession().createQuery(hql);
		
		query.setFirstResult((pageNow - 1) * pageSize);
		query.setMaxResults(pageSize);
		
		return query.list();
	}

	public List<User> queryByTrueName(String trueName) {
		
		String hql = "from User u where u.trueName like ?";
		
		return getSession().createQuery(hql).setString(0, "%"+trueName+"%").list();
	}

	public User login(String tel, String password) {
		// TODO 鑷姩鐢熸垚鐨勬柟娉曞瓨鏍�
		String hql= "from User u where u.tel=? and u.password=?";
		return (User)getSession().createQuery(hql).setString(0, tel)
				.setString(1,password).uniqueResult();
	}

	public User check(String tel) {
		// TODO 鑷姩鐢熸垚鐨勬柟娉曞瓨鏍�
		String hql= "from User u where u.tel=?";
		return (User)getSession().createQuery(hql).setString(0, tel)
				.uniqueResult();
	}
	@Transactional(rollbackFor=Exception.class) 
	public void upGrade(Long id,Vip vip){
		delete(id);
		getSession().save(vip);
	}
	


}
