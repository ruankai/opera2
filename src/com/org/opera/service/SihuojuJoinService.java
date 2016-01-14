package com.org.opera.service;

import java.util.List;

import com.org.opera.base.DaoSupport;
import com.org.opera.domain.SihuojuJoin;

public interface SihuojuJoinService extends DaoSupport<SihuojuJoin> {

	int findCount(Long infoId, Long userId);

	List<SihuojuJoin> findPeople(Long infoId);

	List<SihuojuJoin> getType(Long infoId);

	void changeType(Long typeId, Long joinId);

	Long getInfoIdByJoinId(Long joinId);

	List<SihuojuJoin> showJoin(Long id);



}
