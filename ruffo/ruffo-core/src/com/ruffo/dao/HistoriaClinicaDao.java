package com.ruffo.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ruffo.entidades.HistoriaClinica;
import com.ruffo.utils.BaseDao;

public class HistoriaClinicaDao extends BaseDao<HistoriaClinica> {

	@PersistenceContext(unitName = "ruffo")
	private EntityManager em;
	
	public HistoriaClinicaDao(Class<HistoriaClinica> entityClass) {
		super(entityClass);
	}
	
	public HistoriaClinicaDao() {
		super(HistoriaClinica.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public List<HistoriaClinica> obtenerHistoriaClinicaDeMascotaPaginado(Long idMascota, Integer nroPagina, Integer cantPorPagina) {
		if (nroPagina == null || cantPorPagina == null || nroPagina == 0)
			return new ArrayList<>();
				
		String query = "HistoriaClinica.obtenerHistoriasClinicasDeMascota";
		Query q = getEntityManager().createNamedQuery(query);
		q.setParameter("idMascota", idMascota);
		q.setFirstResult((nroPagina-1) * cantPorPagina); 
		q.setMaxResults(cantPorPagina);
		
		List<HistoriaClinica> list = (List<HistoriaClinica>) q.getResultList();
		if (list == null || list.size() < 1)
			return new ArrayList<>();
		return list;
	}

	public List<HistoriaClinica> obtenerHistoriaClinicaDeMascota(Long idMascota) {
		String query = "HistoriaClinica.obtenerHistoriasClinicasDeMascota";
		Query q = getEntityManager().createNamedQuery(query);
		q.setParameter("idMascota", idMascota);
		List<HistoriaClinica> list = (List<HistoriaClinica>) q.getResultList();
		if (list == null || list.size() < 1)
			return new ArrayList<>();
		return list;
	}
}
