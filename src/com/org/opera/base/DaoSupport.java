package com.org.opera.base;

import java.util.List;

import com.org.opera.domain.PageBean2;
import com.org.opera.util.QueryHelper;

public interface DaoSupport<T> {

	/**
	 * 保存实体
	 * @param entity
	 */
	void save(T entity);
	
	/**
	 * 删除实体
	 * @param id
	 */
	void delete(Long id);
	
	/**
	 * 更新实体
	 * @param entity
	 */
	void update(T entity);
	
	/**
	 * 查询实体
	 * @param i
	 * @return
	 */
	T getById(Long i);
	
	/**
	 * 查询实体
	 * @param ids
	 * @return
	 */
	List<T> getByIds(Long[] ids);
	
	/**
	 * 查询所有
	 * @return
	 */
	List<T> findAll();

	/**
	 * 公共的查询分页信息的方法
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @param hql
	 *            查询数据列表的HQL
	 * @param parameters
	 *            参数列表，与HQL中问号一一对应
	 * @return
	 */
	@Deprecated
	PageBean2 getPageBean(int pageNum, int pageSize, String hql, List<Object> parameters);

	/**
	 * 公共的查询分页信息的方法（最终版）
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @param queryHelper
	 *            HQL语句与参数列表
	 * @return
	 */
	PageBean2 getPageBean(int pageNum, int pageSize, QueryHelper queryHelper);
	
	/**
	 * 
	 * @param firstResult 开始的记录数
	 * @param maxResult	取得的记录数
	 * @return
	 */
	List<T> findAll(int firstResult,int maxResult);
	
}
