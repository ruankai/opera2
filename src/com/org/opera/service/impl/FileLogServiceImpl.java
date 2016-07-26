package com.org.opera.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.org.opera.base.DaoSupportImpl;
import com.org.opera.domain.FileLog;
@Service
@Transactional
public class FileLogServiceImpl extends DaoSupportImpl<FileLog> {

}
