package com.org.opera.service.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.org.opera.base.DaoSupportImpl;
import com.org.opera.domain.Manager;
import com.org.opera.service.ManagerService;

@Service
@Transactional
@SuppressWarnings("unchecked")
public class ManagerServiceImpl extends DaoSupportImpl<Manager> implements ManagerService {

	public Manager findByLoginNameAndPassword(String userName, String managerPwd) {
		
		String hql = "from Manager m where m.name=? and m.password=?";

		return (Manager) getSession().createQuery(hql).setParameter(0,
				userName).setParameter(1, managerPwd).uniqueResult();
	}

	public int getRowCount() {
		
		String hql = "select count(*) from Manager";
		
		Query query = getSession().createQuery(hql);
		
		return Integer.parseInt(query.list().get(0).toString());
	}

	public List<Manager> getList(int pageNow, int pageSize) {
		
		String hql = "from Manager";
		
		Query query = getSession().createQuery(hql);
		
		query.setFirstResult((pageNow - 1) * pageSize);
		query.setMaxResults(pageSize);
		
		return query.list();
	}

	public List<Manager> queryByTrueName(String trueName) {
		
		String hql = "from Manager m where m.trueName like?";
		
		return getSession().createQuery(hql).setString(0, "%"+trueName+"%").list();
	}

	public int updatePwd(String userName, String managerPwd, String newPwd) {
		
		String hql = "update Manager set password=? where name=? and password=?";

		return getSession().createQuery(hql).setParameter(0, newPwd)
				.setParameter(1, userName).setParameter(2, managerPwd)
				.executeUpdate();
	}

	
	

}
