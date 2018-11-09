package com.ruffo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ruffo.entidades.Raza;
import com.ruffo.utils.BaseDao;

public class RazaDao extends BaseDao<Raza> {

	@PersistenceContext(unitName = "ruffo")
	private EntityManager em;
	
	public RazaDao(Class<Raza> entityClass) {
		super(entityClass);
	}
	
	public RazaDao() {
		super(Raza.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public List<Raza> obtenerRazasPorTipoDeMascota(String tipoMascota) {
		String query = "Mascota.obtenerRazasPorTipoDeMascota";
		Query q = getEntityManager().createNamedQuery(query);
		q.setParameter("tipoMascota", tipoMascota);
		List<Raza> list = (List<Raza>) q.getResultList();
		if (list == null || list.size() < 1)
			return null;
		return list;
	}

	public List<Raza> obtenerRazasDeMascotasAutocompletar(String tipoMascota, String texto) {
		String query = "Mascota.obtenerRazasDeMascotasAutocompletar";
		Query q = getEntityManager().createNamedQuery(query);
		q.setParameter("tipoMascota", tipoMascota);
		q.setParameter("texto", "%"+texto+"%");
		q.setMaxResults(10);
		List<Raza> list = (List<Raza>) q.getResultList();
		if (list == null || list.size() < 1)
			return null;
		return list;
	}

}
