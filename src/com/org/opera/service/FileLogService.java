package com.org.opera.service;

import com.org.opera.base.DaoSupport;
import com.org.opera.domain.FileLog;

public interface FileLogService extends DaoSupport<FileLog> {
	FileLog findBySourceId(String souceId);
}
