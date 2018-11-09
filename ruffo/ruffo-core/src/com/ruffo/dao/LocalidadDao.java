package com.ruffo.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ruffo.entidades.Localidad;
import com.ruffo.utils.BaseDao;

public class LocalidadDao extends BaseDao<Localidad> {

	@PersistenceContext(unitName = "ruffo")
	private EntityManager em;
	
	public LocalidadDao(Class<Localidad> entityClass) {
		super(entityClass);
	}
	
	public LocalidadDao() {
		super(Localidad.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public List<Localidad> obtenerLocalidadesPorDepartamento(Long idDepartamento, Integer nroPagina, Integer cantPorPagina) {
		if (nroPagina < 1 || cantPorPagina < 1)
			return new ArrayList<>();
		String query = "Codiguera.obtenerLocalidadesPorDepartamento";
		Query q = getEntityManager().createNamedQuery(query);
		q.setParameter("idDepartamento", idDepartamento);
		q.setFirstResult((nroPagina-1) * cantPorPagina); 
		q.setMaxResults(cantPorPagina);
		List<Localidad> list = (List<Localidad>) q.getResultList();
		if (list == null || list.size() < 1)
			return new ArrayList<>();
		return list;	
	}

	public Localidad obtenerLocalidDeDepartamento(String localidad, Long idDepartamento) {
		String query = "Codiguera.obtenerLocalidDeDepartamento";
		Query q = getEntityManager().createNamedQuery(query);
		q.setParameter("idDepartamento", idDepartamento);
		q.setParameter("descripcion", localidad);
		List<Localidad> list = (List<Localidad>) q.getResultList();
		if (list == null || list.size() < 1)
			return null;
		return list.get(0);
	}
	
//	public List<Localidad> obtenerLocalidadPorTipo(String tipoLocalidad) {
//		String query = "Mascota.obtenerLocalidadPorTipo";
//		Query q = getEntityManager().createNamedQuery(query);
//		q.setParameter("tipoLocalidad", tipoLocalidad);
//		List<Localidad> list = (List<Localidad>) q.getResultList();
//		if (list == null || list.size() < 1)
//			return null;
//		return list;
//	}

}
