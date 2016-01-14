package com.org.opera.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.org.opera.base.DaoSupportImpl;
import com.org.opera.domain.Course;
import com.org.opera.service.CourseService;

@Service
@Transactional
public class CourseServiceImpl extends DaoSupportImpl<Course> implements CourseService {

	@SuppressWarnings("unchecked")
	public List<Course> find8() {
//		String hql = "FROM SihuojuInfo WHERE userId = '"+userId+"'";
		String sql = "select * from course where id between 1 and 8";
		return getSession().createSQLQuery(sql).addEntity(Course.class).list();
	}


	public List<Course> getByName(String name){
//		String hql = "FROM SihuojuInfo WHERE name = '"+name+"'";
		String sql = "select * from course where name like '%"+name+"%'";
		return getSession().createSQLQuery(sql).addEntity(Course.class).list();
	}
	
	public List<Course> listMy(Long id){
//		String hql = "FROM SihuojuInfo WHERE name = '"+name+"'";
		String sql = "select * from course where userId = '"+id+"'";
		return getSession().createSQLQuery(sql).addEntity(Course.class).list();
	}
	
	public int getCount(){
//		String hql = "FROM SihuojuInfo WHERE name = '"+name+"'";
		String sql = "select count(*) from course ";
		return ((Number)getSession().createSQLQuery(sql).uniqueResult()).intValue();
	}
}
