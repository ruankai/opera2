package com.org.opera.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.org.opera.base.DaoSupportImpl;
import com.org.opera.domain.MinrenInfo;
import com.org.opera.service.MinrenInfoService;

@Service
@Transactional
public class MinrenInfoServiceImpl extends DaoSupportImpl<MinrenInfo> implements MinrenInfoService {
	public void love(Long minrenId){
		String sql="update minreninfo set count=count+1 where id="+minrenId;
		getSession().createSQLQuery(sql).executeUpdate();
	}
}
