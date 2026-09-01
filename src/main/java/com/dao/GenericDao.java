package com.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.Criterion;

public interface GenericDao<T,K extends Serializable> {
	public void save (T entity) throws Exception;
	public void upDate (T entity) throws Exception;
	public void delete (T entity) throws Exception;

		
		public List<T> findAll() throws Exception;
		public List<T> findByCriteria(Criterion crit) throws Exception;
	
	public T findById(K id) throws Exception;
	

	

}
