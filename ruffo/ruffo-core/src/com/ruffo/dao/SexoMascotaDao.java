package com.ruffo.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ruffo.entidades.SexoMascota;
import com.ruffo.utils.BaseDao;

public class SexoMascotaDao extends BaseDao<SexoMascota> {

	@PersistenceContext(unitName = "ruffo")
	private EntityManager em;
	
	public SexoMascotaDao(Class<SexoMascota> entityClass) {
		super(entityClass);
	}
	
	public SexoMascotaDao() {
		super(SexoMascota.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
}