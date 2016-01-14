package com.org.opera.base;

import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.org.opera.domain.PageBean2;
import com.org.opera.util.QueryHelper;

@Transactional
@SuppressWarnings("unchecked")
public class DaoSupportImpl<T> implements DaoSupport<T> {

	@Resource
	private SessionFactory sessionFactory;

	protected Class<T> clazz;

	/**
	 * ͨ�����������õ�T����ʵ����
	 */
	public DaoSupportImpl() {

		ParameterizedType pt = (ParameterizedType) this.getClass()
				.getGenericSuperclass();

		this.clazz = (Class) pt.getActualTypeArguments()[0];

		System.out.println("clazz = " + clazz.getName());
	}

	/**
	 * ��ȡ��ǰ���õ�Session
	 * 
	 * @return
	 */
	protected Session getSession() {

		return sessionFactory.getCurrentSession();
	}

	public void delete(Long id) {

		Object object = getSession().get(clazz, id);

		getSession().delete(object);
	}

	public List<T> findAll() {

		return getSession().createQuery("from " + clazz.getSimpleName()).list();
	}

	public T getById(Long id) {

		if (id == null) {
			return null;
		} else {
			return (T) getSession().get(clazz, id);
		}
	}

	public List<T> getByIds(Long[] ids) {

		if (ids == null || ids.length == 0) {

			return Collections.EMPTY_LIST;
		} else {

			return getSession()
					.createQuery(
							"from " + clazz.getSimpleName()
									+ " where id in (:ids)")
					.setParameterList("ids", ids).list();
		}
	}

	public void save(T entity) {

		getSession().save(entity);
	}

	public void update(T entity) {

		getSession().update(entity);
	}

	// �����Ĳ�ѯ��ҳ��Ϣ�ķ���
	@Deprecated
	public PageBean2 getPageBean(int pageNum, int pageSize, String hql,
			List<Object> parameters) {
		System.out.println("-------> DaoSupportImpl.getPageBean()");

		// ��ѯ��ҳ�������б�
		Query listQuery = getSession().createQuery(hql); // ������ѯ����
		if (parameters != null) { // ���ò���
			for (int i = 0; i < parameters.size(); i++) {
				listQuery.setParameter(i, parameters.get(i));
			}
		}
		listQuery.setFirstResult((pageNum - 1) * pageSize);
		listQuery.setMaxResults(pageSize);
		List list = listQuery.list(); // ִ�в�ѯ

		// ��ѯ�ܼ�¼����
		Query countQuery = getSession().createQuery("SELECT COUNT(*) " + hql);
		if (parameters != null) { // ���ò���
			for (int i = 0; i < parameters.size(); i++) {
				countQuery.setParameter(i, parameters.get(i));
			}
		}
		Long count = (Long) countQuery.uniqueResult(); // ִ�в�ѯ

		return new PageBean2(pageNum, pageSize, count.intValue(), list);
	}

	// �����Ĳ�ѯ��ҳ��Ϣ�ķ��������հ棩
	public PageBean2 getPageBean(int pageNum, int pageSize,
			QueryHelper queryHelper) {
		System.out
				.println("-------> DaoSupportImpl.getPageBean( int pageNum, int pageSize, QueryHelper queryHelper )");

		// �����б�
		List<Object> parameters = queryHelper.getParameters();

		// ��ѯ��ҳ�������б�
		Query listQuery = getSession().createQuery(
				queryHelper.getListQueryHql()); // ������ѯ����
		if (parameters != null) { // ���ò���
			for (int i = 0; i < parameters.size(); i++) {
				listQuery.setParameter(i, parameters.get(i));
			}
		}
		listQuery.setFirstResult((pageNum - 1) * pageSize);
		listQuery.setMaxResults(pageSize);
		List list = listQuery.list(); // ִ�в�ѯ

		// ��ѯ�ܼ�¼����
		Query countQuery = getSession().createQuery(
				queryHelper.getCountQueryHql());
		if (parameters != null) { // ���ò���
			for (int i = 0; i < parameters.size(); i++) {
				countQuery.setParameter(i, parameters.get(i));
			}
		}
		Long count = (Long) countQuery.uniqueResult(); // ִ�в�ѯ

		return new PageBean2(pageNum, pageSize, count.intValue(), list);
	}

	public List<T> findAll(int firstResult, int maxResult) {
		return getSession().createQuery(//
				"FROM " + clazz.getSimpleName())//
				.setFirstResult(firstResult).setMaxResults(maxResult).list();
	}
}
