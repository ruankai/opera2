package com.org.opera.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.org.opera.base.DaoSupportImpl;
import com.org.opera.domain.FileLog;
import com.org.opera.service.FileLogService;
@Service
@Transactional
public class FileLogServiceImpl extends DaoSupportImpl<FileLog> implements FileLogService {

	public FileLog findBySourceId(String souceId) {
		// TODO 自动生成的方法存根
		 return (FileLog)getSession()
				 .createQuery("FROM FileLog f where f.sourceId=?")
				 .setString(0, souceId).uniqueResult();
	}

}
