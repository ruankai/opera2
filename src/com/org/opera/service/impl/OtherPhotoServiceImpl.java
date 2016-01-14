package com.org.opera.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.org.opera.base.DaoSupportImpl;
import com.org.opera.domain.OtherPhoto;
import com.org.opera.service.OtherPhotoService;
@Service
@Transactional
public class OtherPhotoServiceImpl extends DaoSupportImpl<OtherPhoto>implements OtherPhotoService {
	
}
