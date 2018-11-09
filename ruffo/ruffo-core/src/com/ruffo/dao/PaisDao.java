package com.ruffo.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ruffo.entidades.Pais;
import com.ruffo.utils.BaseDao;

public class PaisDao extends BaseDao<Pais> {

	@PersistenceContext(unitName = "ruffo")
	private EntityManager em;
	
	public PaisDao(Class<Pais> entityClass) {
		super(entityClass);
	}
	
	public PaisDao() {
		super(Pais.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
}
