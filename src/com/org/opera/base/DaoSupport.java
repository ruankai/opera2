package com.org.opera.base;

import java.util.List;

import com.org.opera.domain.PageBean2;
import com.org.opera.util.QueryHelper;

public interface DaoSupport<T> {

	/**
	 * ����ʵ��
	 * @param entity
	 */
	void save(T entity);
	
	/**
	 * ɾ��ʵ��
	 * @param id
	 */
	void delete(Long id);
	
	/**
	 * ����ʵ��
	 * @param entity
	 */
	void update(T entity);
	
	/**
	 * ��ѯʵ��
	 * @param i
	 * @return
	 */
	T getById(Long i);
	
	/**
	 * ��ѯʵ��
	 * @param ids
	 * @return
	 */
	List<T> getByIds(Long[] ids);
	
	/**
	 * ��ѯ����
	 * @return
	 */
	List<T> findAll();

	/**
	 * �����Ĳ�ѯ��ҳ��Ϣ�ķ���
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @param hql
	 *            ��ѯ�����б��HQL
	 * @param parameters
	 *            �����б���HQL���ʺ�һһ��Ӧ
	 * @return
	 */
	@Deprecated
	PageBean2 getPageBean(int pageNum, int pageSize, String hql, List<Object> parameters);

	/**
	 * �����Ĳ�ѯ��ҳ��Ϣ�ķ��������հ棩
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @param queryHelper
	 *            HQL���������б�
	 * @return
	 */
	PageBean2 getPageBean(int pageNum, int pageSize, QueryHelper queryHelper);
	
	/**
	 * 
	 * @param firstResult ��ʼ�ļ�¼��
	 * @param maxResult	ȡ�õļ�¼��
	 * @return
	 */
	List<T> findAll(int firstResult,int maxResult);
	
}
