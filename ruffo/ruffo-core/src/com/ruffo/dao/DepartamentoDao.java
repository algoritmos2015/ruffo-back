package com.ruffo.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ruffo.entidades.Departamento;
import com.ruffo.utils.BaseDao;

public class DepartamentoDao extends BaseDao<Departamento> {

	@PersistenceContext(unitName = "ruffo")
	private EntityManager em;
	
	public DepartamentoDao(Class<Departamento> entityClass) {
		super(entityClass);
	}
	
	public DepartamentoDao() {
		super(Departamento.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public List<Departamento> obtenerDeparamentosPorPais(Long idPais, Integer nroPagina, Integer cantPorPagina) {
		if (nroPagina < 1 || cantPorPagina < 1)
			return new ArrayList<>();
		String query = "Codiguera.obtenerDeparamentosPorPais";
		Query q = getEntityManager().createNamedQuery(query);
		q.setParameter("idPais", idPais);
		q.setFirstResult((nroPagina-1) * cantPorPagina); 
		q.setMaxResults(cantPorPagina);
		List<Departamento> list = (List<Departamento>) q.getResultList();
		if (list == null || list.size() < 1)
			return new ArrayList<>();
		return list;		
	}
}
