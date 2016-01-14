package com.org.opera.service.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.org.opera.base.DaoSupportImpl;
import com.org.opera.domain.SihuojuJoin;
import com.org.opera.service.SihuojuJoinService;

@Service
@Transactional
public class SihuojuJoinServiceImpl extends DaoSupportImpl<SihuojuJoin> implements SihuojuJoinService {
	
	public int findCount(Long infoId, Long userId){
		
		String hql = "SELECT COUNT(*) FROM SihuojuJoin WHERE sihuojuinfoId = '"+infoId+"' and userId = '"+userId+"'";
		Query query = this.getSession().createQuery(hql);  
		System.out.println(((Number)query.uniqueResult()).intValue()+"1122");
	    return ((Number)query.uniqueResult()).intValue(); 
		
	}
	
	
	public List<SihuojuJoin> findPeople(Long infoId){
		
		String hql = "FROM SihuojuJoin WHERE sihuojuinfoId = '"+infoId+"'";
		
		return getSession().createQuery(hql).list();
		
		
	}

	public List<SihuojuJoin> getType(Long infoId){
		String sql="select * from sihuojujoin where sihuojuInfoId = '"+infoId+"'";
		return getSession().createSQLQuery(sql).addEntity(SihuojuJoin.class).list();
		
	}
	
	public void changeType(Long typeId, Long joinId){
		String sql="update sihuojujoin set type='"+typeId+"' where id='"+joinId+"'";
		
		getSession().createSQLQuery(sql).executeUpdate();
//		Query query = getSession().createSQLQuery(sql);
//		query.setInteger("type", 2);
//		System.out.println("标志位---0811");		
	}
	
	public Long getInfoIdByJoinId(Long joinId){
		String sql= "select sihuojuinfoId from sihuojujoin where id='"+joinId+"'";
		Query query=getSession().createSQLQuery(sql);
		System.out.println("---->>>"+((Number)query.uniqueResult()).longValue());
		return ((Number)query.uniqueResult()).longValue();
	}
	
	public List<SihuojuJoin> showJoin(Long id){
		String sql="select * from  sihuojujoin where userId = '"+id+"'";
		return getSession().createSQLQuery(sql).addEntity(SihuojuJoin.class).list();
		
	}
}
