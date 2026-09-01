package com.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;

import com.dao.GenericDao;
import com.gc.utils.HibernateUtil;

public class GenericDaoImpl<T, K extends Serializable> implements GenericDao<T, K  > {
	protected Session hibernateSession;
	private Transaction tx;
	private Class<T> clazz;

	public GenericDaoImpl() {
		
		
		this.clazz =(Class<T>) ((ParameterizedType)
				this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	

		
	}

	protected void startOperation() {
		hibernateSession = HibernateUtil.getInstance().getSessionFactory().openSession();
		tx = hibernateSession.beginTransaction();

	}

	protected void endOperation() {
		tx.commit();
		hibernateSession.close();
	}

	@Override
	public void save(T entity) throws Exception {
		startOperation();
		hibernateSession.save(entity);
		endOperation();

	}

	@Override
	public void upDate(T entity) throws Exception {
		startOperation();
		hibernateSession.update(entity);
		endOperation();

	}

	@Override
	public void delete(T entity) throws Exception {
		startOperation();
		hibernateSession.delete(entity);
		endOperation();

	}

	@Override
	public List<T> findAll() throws Exception {
		startOperation();
		List<T> list=hibernateSession.createCriteria(clazz).list();
		hibernateSession.close();
		return list;
	}

	@Override
	public List<T> findByCriteria(Criterion crit) throws Exception {
		startOperation();
		List<T> list=hibernateSession.createCriteria(clazz).add(crit).list();
		hibernateSession.close();
		return list;
	}

	@Override
	public T findById(K id) throws Exception {
		startOperation();
		T entity = (T) hibernateSession.get(clazz,  id);
		hibernateSession.close();

		return entity;
	}

}
