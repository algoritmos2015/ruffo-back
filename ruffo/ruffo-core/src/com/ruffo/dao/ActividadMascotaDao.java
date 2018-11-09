package com.ruffo.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ruffo.entidades.ActividadMascota;
import com.ruffo.utils.BaseDao;

public class ActividadMascotaDao extends BaseDao<ActividadMascota> {

	@PersistenceContext(unitName = "ruffo")
	private EntityManager em;
	
	public ActividadMascotaDao(Class<ActividadMascota> entityClass) {
		super(entityClass);
	}
	
	public ActividadMascotaDao() {
		super(ActividadMascota.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
	
//	public List<CaracteristaEspecial> obtenerCaracteristicasEspecialesDeMascotasPorParte(String parte) {
//		String query = "Mascota.obtenerCaracteristicasEspecialesDeMascotasPorParte";
//		Query q = getEntityManager().createNamedQuery(query);
//		q.setParameter("parte", parte);
//		List<CaracteristaEspecial> list = (List<CaracteristaEspecial>) q.getResultList();
//		if (list == null || list.size() < 1)
//			return null;
//		return list;	
//	}


}
