package com.org.opera.service;

import java.util.List;

import com.org.opera.base.DaoSupport;
import com.org.opera.domain.User;
import com.org.opera.domain.Vip;

public interface UserService extends DaoSupport<User> {

	/**
	 * ��ѯ���ж�������ͨ�û���¼
	 * @return
	 */
	int getRowCount();

	/**
	 * ��ѯ��ͨ�û�����Ϣ����ӷ�ҳ���ܣ�
	 * @param pageNow
	 * @param pageSize
	 * @return
	 */
	List<User> getList(int pageNow, int pageSize);

	/**
	 * �����ʵ�����ѯ�������ͨ�û�
	 * @param trueName
	 * @return
	 */
	List<User> queryByTrueName(String trueName);
/**
 * 根据用户的电话和密码查找用户
 * @param tel 用户的电话
 * @param password用户密码
 * @return
 */
	User login(String tel,String password);
/**
 * 查询电话号码是否已存在
 * @param tel
 * @return
 */
	User check(String tel);
	/**
	 * 普通用户升级为高级用户
	 * @param user	普通用户
	 * @param vip	高级用户
	 */
	void upGrade(Long id,Vip vip);
}