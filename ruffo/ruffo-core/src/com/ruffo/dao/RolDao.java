package com.ruffo.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ruffo.entidades.Rol;
import com.ruffo.utils.BaseDao;

public class RolDao extends BaseDao<Rol> {

	@PersistenceContext(unitName = "ruffo")
	private EntityManager em;
	
	public RolDao(Class<Rol> entityClass) {
		super(entityClass);
	}
	
	public RolDao() {
		super(Rol.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
}
