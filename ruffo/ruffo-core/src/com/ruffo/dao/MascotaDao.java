package com.ruffo.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ruffo.entidades.Mascota;
import com.ruffo.utils.BaseDao;

public class MascotaDao extends BaseDao<Mascota> {

	@PersistenceContext(unitName = "ruffo")
	private EntityManager em;
	
	public MascotaDao(Class<Mascota> entityClass) {
		super(entityClass);
	}
	
	public MascotaDao() {
		super(Mascota.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public List<Mascota> obtenerMascotaPorNombreUsuario(String nombreUsuario) {
		String query = "Mascota.obtenerMascotaPorNombreUsuario";
		Query q = getEntityManager().createNamedQuery(query);
		q.setParameter("nombreUsuario", nombreUsuario);
		List<Mascota> list = (List<Mascota>) q.getResultList();
		if (list == null || list.size() < 1)
			return new ArrayList<>();
		return list;
	}

	public List<Mascota> obtenerMascotasPorIdUsuario(Long idUsuario) {
		String query = "Mascota.obtenerMascotasPorIdUsuario";
		Query q = getEntityManager().createNamedQuery(query);
		q.setParameter("idUsuario", idUsuario);
		List<Mascota> list = (List<Mascota>) q.getResultList();
		if (list == null || list.size() < 1)
			return new ArrayList<>();
		return list;
	}
}
