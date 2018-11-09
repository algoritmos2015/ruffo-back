package com.ruffo.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ruffo.entidades.Sexo;
import com.ruffo.utils.BaseDao;

public class SexoDao extends BaseDao<Sexo> {

	@PersistenceContext(unitName = "ruffo")
	private EntityManager em;
	
	public SexoDao(Class<Sexo> entityClass) {
		super(entityClass);
	}
	
	public SexoDao() {
		super(Sexo.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
}