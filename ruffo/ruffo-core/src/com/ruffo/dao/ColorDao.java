package com.ruffo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ruffo.entidades.Color;
import com.ruffo.utils.BaseDao;

public class ColorDao extends BaseDao<Color> {

	@PersistenceContext(unitName = "ruffo")
	private EntityManager em;
	
	public ColorDao(Class<Color> entityClass) {
		super(entityClass);
	}
	
	public ColorDao() {
		super(Color.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
	
	public List<Color> obtenerColorPorTipo(String tipoColor) {
		String query = "Mascota.obtenerColorPorTipo";
		Query q = getEntityManager().createNamedQuery(query);
		q.setParameter("tipoColor", tipoColor);
		List<Color> list = (List<Color>) q.getResultList();
		if (list == null || list.size() < 1)
			return null;
		return list;
	}

	public List<Color> obtenerColorPorTipoYDescripcion(String tipoColor, String descripcion) {
		String query = "Mascota.obtenerColorPorTipoYDescripcion";
		Query q = getEntityManager().createNamedQuery(query);
		q.setParameter("tipoColor", tipoColor);
		q.setParameter("descripcion", descripcion);
		List<Color> list = (List<Color>) q.getResultList();
		if (list == null || list.size() < 1)
			return null;
		return list;
	}

}
