package com.ruffo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ruffo.entidades.Persona;
import com.ruffo.utils.BaseDao;

public class PersonaDao extends BaseDao<Persona> {

	@PersistenceContext(unitName = "ruffo")
	private EntityManager em;
	
	public PersonaDao(Class<Persona> entityClass) {
		super(entityClass);
	}
	
	public PersonaDao() {
		super(Persona.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public List<String> obtenerTodosLosNombresDeLasPersonas() {
		Query q = getEntityManager().createQuery("SELECT e.nombre FROM Persona e ");
		List<String> list = (List<String>) q.getResultList();
		return list;
	}
}