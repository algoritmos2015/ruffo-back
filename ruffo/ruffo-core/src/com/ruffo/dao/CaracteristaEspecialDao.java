package com.ruffo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ruffo.entidades.CaracteristicaEspecial;
import com.ruffo.utils.BaseDao;

public class CaracteristaEspecialDao extends BaseDao<CaracteristicaEspecial> {

	@PersistenceContext(unitName = "ruffo")
	private EntityManager em;
	
	public CaracteristaEspecialDao(Class<CaracteristicaEspecial> entityClass) {
		super(entityClass);
	}
	
	public CaracteristaEspecialDao() {
		super(CaracteristicaEspecial.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public List<CaracteristicaEspecial> obtenerCaracteristicasEspecialesDeMascotasPorParte(String parte) {
		String query = "Mascota.obtenerCaracteristicasEspecialesDeMascotasPorParte";
		Query q = getEntityManager().createNamedQuery(query);
		q.setParameter("parte", parte);
		List<CaracteristicaEspecial> list = (List<CaracteristicaEspecial>) q.getResultList();
		if (list == null || list.size() < 1)
			return null;
		return list;	
	}

}
