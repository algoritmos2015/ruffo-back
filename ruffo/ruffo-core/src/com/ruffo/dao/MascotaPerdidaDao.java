package com.ruffo.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ruffo.entidades.MascotaPerdida;
import com.ruffo.utils.BaseDao;

public class MascotaPerdidaDao extends BaseDao<MascotaPerdida> {

	@PersistenceContext(unitName = "ruffo")
	private EntityManager em;
	
	public MascotaPerdidaDao(Class<MascotaPerdida> entityClass) {
		super(entityClass);
	}
	
	public MascotaPerdidaDao() {
		super(MascotaPerdida.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public MascotaPerdida buscarMascotaPropiaPerdidaPorBeacon(String nroBeacon) {
		String query = "MascotaPerdida.buscarMascotaPropiaPerdidaPorBeacon";
		Query q = getEntityManager().createNamedQuery(query);
		q.setParameter("nroBeacon", nroBeacon);
		List<MascotaPerdida> list = (List<MascotaPerdida>) q.getResultList();
		if (list == null || list.size() < 1)
			return null;
		return list.get(0);
	}

	public MascotaPerdida buscarMascotaPropiaPerdidaPorNroChip(String numeroChip) {
		String query = "MascotaPerdida.buscarMascotaPropiaPerdidaPorNroChip";
		Query q = getEntityManager().createNamedQuery(query);
		q.setParameter("nroChip", numeroChip);
		List<MascotaPerdida> list = (List<MascotaPerdida>) q.getResultList();
		if (list == null || list.size() < 1)
			return null;
		return list.get(0);
	}

	public List<MascotaPerdida> buscarPrimerAproximacionMascotaPerdidaPropia(String tipo, String colorPredominante) {
		String query = "MascotaPerdida.buscarPrimerAproximacionMascotaPerdidaPropia";
		Query q = getEntityManager().createNamedQuery(query);
		q.setParameter("tipoMascota", tipo);
		q.setParameter("colorPredominante", colorPredominante);		
		List<MascotaPerdida> list = (List<MascotaPerdida>) q.getResultList();
		if (list == null || list.size() < 1)
			return new ArrayList<>();
		return list;
	}

	public List<MascotaPerdida> obtenerMascotasBusquedaActivaPorAtributo(String atributo, String nombreAtributo) {
		Query q = getEntityManager().createQuery("SELECT e FROM MascotaPerdida e where e." + nombreAtributo + " = :atributo and e.busquedaActiva = 1");
		q.setParameter("atributo", atributo);
		List<MascotaPerdida> list = (List<MascotaPerdida>) q.getResultList();
		return list;
	}

}
