package com.ruffo.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ruffo.entidades.Tamanio;
import com.ruffo.utils.BaseDao;

public class TamanioDao extends BaseDao<Tamanio> {

	@PersistenceContext(unitName = "ruffo")
	private EntityManager em;
	
	public TamanioDao(Class<Tamanio> entityClass) {
		super(entityClass);
	}
	
	public TamanioDao() {
		super(Tamanio.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

}
