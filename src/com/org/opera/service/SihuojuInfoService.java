package com.org.opera.service;


import java.util.List;

import com.org.opera.base.DaoSupport;
import com.org.opera.domain.SihuojuInfo;

public interface SihuojuInfoService extends DaoSupport<SihuojuInfo> {

	List<SihuojuInfo> getIdByUser(Long userId);




}
