package com.ruffo.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ruffo.entidades.ParteMascota;
import com.ruffo.utils.BaseDao;

public class ParteMascotaDao extends BaseDao<ParteMascota> {

	@PersistenceContext(unitName = "ruffo")
	private EntityManager em;
	
	public ParteMascotaDao(Class<ParteMascota> entityClass) {
		super(entityClass);
	}
	
	public ParteMascotaDao() {
		super(ParteMascota.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

}
