package com.ruffo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ruffo.entidades.Sesion;
import com.ruffo.utils.BaseDao;

public class SesionDao extends BaseDao<Sesion> {

	@PersistenceContext(unitName = "ruffo")
	private EntityManager em;
	
	public SesionDao(Class<Sesion> entityClass) {
		super(entityClass);
	}
	
	public SesionDao() {
		super(Sesion.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public List<Sesion> obtenerSesionesDeUsuario(Long id, boolean activa) {
		String query = "Sesion.obtenerSesionesActivaDeUsuario";
		Query q = getEntityManager().createNamedQuery(query);
		q.setParameter("idUsuario", id);
		q.setParameter("activa", activa);
		List<Sesion> list = (List<Sesion>) q.getResultList();
		if (list == null || list.size() < 1)
			return null;
		return list;
	}	
}
