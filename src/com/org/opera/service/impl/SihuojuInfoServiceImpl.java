package com.org.opera.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.org.opera.base.DaoSupportImpl;
import com.org.opera.domain.SihuojuInfo;
import com.org.opera.service.SihuojuInfoService;

@Service
@Transactional
public class SihuojuInfoServiceImpl extends DaoSupportImpl<SihuojuInfo> implements SihuojuInfoService {
	
	@SuppressWarnings("unchecked")
	public List<SihuojuInfo> getIdByUser(Long userId){
		String hql = "FROM SihuojuInfo WHERE userId = '"+userId+"'";
		String sql = "select * from sihuojuinfo where userId='"+userId+"'";
		return getSession().createSQLQuery(sql).addEntity(SihuojuInfo.class).list();	
	}

	
	
}
