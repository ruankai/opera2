package com.org.opera.service;


import com.org.opera.base.DaoSupport;
import com.org.opera.domain.MinrenInfo;

public interface MinrenInfoService extends DaoSupport<MinrenInfo> {

	void love(Long minrenId);

}
