package com.org.opera.service;


import java.util.List;

import com.org.opera.base.DaoSupport;
import com.org.opera.domain.Course;

public interface CourseService extends DaoSupport<Course> {

	List<Course> find8();

	List<Course> getByName(String name);

	List<Course> listMy(Long id);

	int getCount();

}
