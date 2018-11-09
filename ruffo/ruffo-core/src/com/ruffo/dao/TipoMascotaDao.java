package com.ruffo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ruffo.entidades.TipoMascota;
import com.ruffo.utils.BaseDao;

public class TipoMascotaDao extends BaseDao<TipoMascota> {

	@PersistenceContext(unitName = "ruffo")
	private EntityManager em;
	
	public TipoMascotaDao(Class<TipoMascota> entityClass) {
		super(entityClass);
	}
	
	public TipoMascotaDao() {
		super(TipoMascota.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
	
	public List<TipoMascota> obtenerTiposDeMascotas() {
		String query = "TipoMascota.obtenerTiposDeMascotas";
		Query q = getEntityManager().createNamedQuery(query);
		List<TipoMascota> list = (List<TipoMascota>) q.getResultList();
		if (list == null || list.size() < 1)
			return null;
		return list;
	}
}