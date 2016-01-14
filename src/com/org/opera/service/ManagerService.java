package com.org.opera.service;

import java.util.List;

import com.org.opera.base.DaoSupport;
import com.org.opera.domain.Manager;

public interface ManagerService extends DaoSupport<Manager> {

	/**
	 * 管理员登录
	 * @param userName
	 * @param managerPwd
	 * @return
	 */
	Manager findByLoginNameAndPassword(String userName, String managerPwd);

	/**
	 * 查询管理员的记录数
	 * @return
	 */
	int getRowCount();

	/**
	 * 暗夜显示用户的记录(分页)
	 * @param pageNow
	 * @param pageSize
	 * @return
	 */
	List<Manager> getList(int pageNow, int pageSize);

	/**
	 * 根据真实姓名查询具体的管理员用户
	 * @param trueName
	 * @return
	 */
	List<Manager> queryByTrueName(String trueName);

	/**
	 * 管理员修改自己的密码
	 * @param userName
	 * @param managerPwd
	 * @param newPwd
	 * @return
	 */
	int updatePwd(String userName, String managerPwd, String newPwd);


}
