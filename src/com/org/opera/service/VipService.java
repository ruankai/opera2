package com.org.opera.service;

import java.util.List;

import com.org.opera.base.DaoSupport;
import com.org.opera.domain.Vip;

public interface VipService extends DaoSupport<Vip> {

	/**
	 * ��ѯ���ж������߼��û���¼
	 * @return
	 */
	int getRowCount();
	
	/**
	 * ��ѯ��ͨ�û�����Ϣ����ӷ�ҳ���ܣ�
	 * @param pageNow
	 * @param pageSize
	 * @return
	 */
	List<Vip> getList(int pageNow, int pageSize);

	/**
	 * ����û�����ʵ�����ѯVIP������û�
	 * @param trueName
	 * @return
	 */
	List<Vip> queryByTrueName(String trueName);
/**
 * 登录
 * @param tel	电话
 * @param password	密码
 * @return
 */
	Vip login(String tel, String password);
/**
 * 判断该电话号码是否已被注册
 * @param tel
 * @return
 */
Vip check(String tel);
	
	

}
