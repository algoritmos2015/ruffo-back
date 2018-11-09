package com.ruffo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ruffo.entidades.Mascota;
import com.ruffo.entidades.Rol;
import com.ruffo.entidades.Usuario;
import com.ruffo.utils.BaseDao;

public class UsuarioDao extends BaseDao<Usuario> {

	@PersistenceContext(unitName = "ruffo")
	private EntityManager em;
	
	public UsuarioDao(Class<Usuario> entityClass) {
		super(entityClass);
	}
	
	public UsuarioDao() {
		super(Usuario.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public Usuario obtenerUsuarioPorNombreYClave(String nombreUsuario, String clave) {
		String query = "Usuario.obtenerUsuarioPorNombreYClave";
		Query q = getEntityManager().createNamedQuery(query);
		q.setParameter("nombreUsuario", nombreUsuario);
		q.setParameter("clave", clave);
		List<Usuario> list = (List<Usuario>) q.getResultList();
		if (list == null || list.size() < 1)
			return null;
		return list.get(0);
	}

	public List<Rol> obtenerRolesDeUsuario(String nombreUsuario) {
		String query = "Usuario.obtenerRolesDeUsuario";
		Query q = getEntityManager().createNamedQuery(query);
		q.setParameter("nombre", nombreUsuario);
		List<Rol> list = (List<Rol>) q.getResultList();
		if (list == null || list.size() < 1)
			return null;
		return list;
	}

	public List<Mascota> obtenerMascotasDeUsuario(Long idUsuarioPropietario) {
		String query = "Usuario.obtenerMascotasDeUsuario";
		Query q = getEntityManager().createNamedQuery(query);
		q.setParameter("idUsuario", idUsuarioPropietario);
		List<Mascota> list = (List<Mascota>) q.getResultList();
		if (list == null || list.size() < 1)
			return null;
		return list;
	}

}
