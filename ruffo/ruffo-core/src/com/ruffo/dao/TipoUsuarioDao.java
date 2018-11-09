package com.ruffo.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ruffo.entidades.TipoUsuario;
import com.ruffo.utils.BaseDao;

public class TipoUsuarioDao extends BaseDao<TipoUsuario> {

	@PersistenceContext(unitName = "ruffo")
	private EntityManager em;
	
	public TipoUsuarioDao(Class<TipoUsuario> entityClass) {
		super(entityClass);
	}
	
	public TipoUsuarioDao() {
		super(TipoUsuario.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

}
