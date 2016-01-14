package com.org.opera.service;

import java.util.List;

import com.org.opera.base.DaoSupport;
import com.org.opera.domain.Manager;

public interface ManagerService extends DaoSupport<Manager> {

	/**
	 * ����Ա��¼
	 * @param userName
	 * @param managerPwd
	 * @return
	 */
	Manager findByLoginNameAndPassword(String userName, String managerPwd);

	/**
	 * ��ѯ����Ա�ļ�¼��
	 * @return
	 */
	int getRowCount();

	/**
	 * ��ҹ��ʾ�û��ļ�¼(��ҳ)
	 * @param pageNow
	 * @param pageSize
	 * @return
	 */
	List<Manager> getList(int pageNow, int pageSize);

	/**
	 * ������ʵ������ѯ����Ĺ���Ա�û�
	 * @param trueName
	 * @return
	 */
	List<Manager> queryByTrueName(String trueName);

	/**
	 * ����Ա�޸��Լ�������
	 * @param userName
	 * @param managerPwd
	 * @param newPwd
	 * @return
	 */
	int updatePwd(String userName, String managerPwd, String newPwd);


}
