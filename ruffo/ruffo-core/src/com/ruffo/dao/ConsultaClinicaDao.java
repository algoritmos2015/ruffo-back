package com.ruffo.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ruffo.entidades.ConsultaClinica;
import com.ruffo.utils.BaseDao;

public class ConsultaClinicaDao extends BaseDao<ConsultaClinica> {

	@PersistenceContext(unitName = "ruffo")
	private EntityManager em;
	
	public ConsultaClinicaDao(Class<ConsultaClinica> entityClass) {
		super(entityClass);
	}
	
	public ConsultaClinicaDao() {
		super(ConsultaClinica.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public List<ConsultaClinica> obtenerConsultasClinicaDeMascota(Long idMascota, Integer nroPagina, Integer cantPorPagina) {
		if (nroPagina == null || cantPorPagina == null || nroPagina == 0)
			return new ArrayList<>();
				
		String query = "ConsultaClinica.obtenerConsultasClinicaDeMascota";
		Query q = getEntityManager().createNamedQuery(query);
		q.setParameter("idMascota", idMascota);
		q.setFirstResult((nroPagina-1) * cantPorPagina); 
		q.setMaxResults(cantPorPagina);
		
		List<ConsultaClinica> list = (List<ConsultaClinica>) q.getResultList();
		if (list == null || list.size() < 1)
			return new ArrayList<>();
		return list;
	}

	public List<ConsultaClinica> obtenerConsultasClinicasRealizadasPorElUsuario(Long idUsuario) {				
		String query = "ConsultaClinica.obtenerConsultasClinicasRealizadasPorElUsuario";
		Query q = getEntityManager().createNamedQuery(query);
		q.setParameter("idUsuario", idUsuario);		
		List<ConsultaClinica> list = (List<ConsultaClinica>) q.getResultList();
		if (list == null || list.size() < 1)
			return new ArrayList<>();
		return list;
	}
}
