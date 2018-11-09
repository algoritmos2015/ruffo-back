package com.ruffo.utils;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * 
 * @author Gonzalo
 *
 * @see Las clases que implementen esta clase abstracta deben redefinir el constructor
 * public BaseDAO(Class<T> entityClass) {
		this.entityClass = entityClass;
	}	
	y el public BaseDAO() {}
 */

public abstract class BaseDao<T> {

	private Class<T> entityClass;

	public BaseDao(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	protected abstract EntityManager getEntityManager();

	public T persist(T entity) {
		getEntityManager().persist(entity);
		return entity;
	}

	public T edit(T entity) {
		getEntityManager().merge(entity);
		return entity;
	}

	public T remove(T entity) {
		getEntityManager().remove(entity);
		return entity;
	}

	public List<T> findAll(Integer nroPagina, Integer cantPorPagina) {
		if (nroPagina == null || cantPorPagina == null || nroPagina == 0)
			return null;
		Query q = getEntityManager().createQuery("SELECT e FROM " + entityClass.getName() + " e");
		q.setFirstResult((nroPagina-1) * cantPorPagina); 
		q.setMaxResults(cantPorPagina);
		List<T> list = (List<T>) q.getResultList();
		return list;
	}

	public Long totalCountFindAll() {
		Query q = getEntityManager().createQuery("SELECT count (*) FROM " + entityClass.getName() + " e");
		Long list = (Long) q.getSingleResult();
		return list;
	}
	
	public T find(Long id) {
		T e = getEntityManager().find(entityClass, id);
		return e;
	}
	
	public List<T> findByAttribute(String attribute, String attributeName) {
		Query q = getEntityManager().createQuery("SELECT e FROM " + entityClass.getName() + " e where e." + attributeName + " = :attribute");
		q.setParameter("attribute", attribute);
		List<T> list = (List<T>) q.getResultList();
		return list;
	}
}