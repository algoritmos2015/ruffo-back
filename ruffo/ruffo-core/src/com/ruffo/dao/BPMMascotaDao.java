package com.ruffo.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ruffo.entidades.BPMMascota;
import com.ruffo.entidades.Mascota;
import com.ruffo.utils.BaseDao;

public class BPMMascotaDao extends BaseDao<BPMMascota> {

	@PersistenceContext(unitName = "ruffo")
	private EntityManager em;
	
	public BPMMascotaDao(Class<BPMMascota> entityClass) {
		super(entityClass);
	}
	
	public BPMMascotaDao() {
		super(BPMMascota.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public Mascota buscarMascotaPerdidaPorBeacon(String nroBeacon) {
		String query = "Mascota.buscarMascotaPerdidaPorNroBeacon";
		Query q = getEntityManager().createNamedQuery(query);
		q.setParameter("nroBeacon", nroBeacon);
		List<Mascota> list = (List<Mascota>) q.getResultList();
		if (list == null || list.size() < 1)
			return null;
		return list.get(0);
	}
	
	public Mascota buscarMascotaPerdidaPorNroChip(String nroChip) {
		String query = "Mascota.buscarMascotaPerdidaPorNroChip";
		Query q = getEntityManager().createNamedQuery(query);
		q.setParameter("nroChip", nroChip);
		List<Mascota> list = (List<Mascota>) q.getResultList();
		if (list == null || list.size() < 1)
			return null;
		return list.get(0);
	}

	public List<BPMMascota> buscarPrimerAproximacionMascotaPerdida(String tipo, String colorPredominante) {
		String query = "Mascota.buscarPrimerAproximacionMascotaPerdida";
		Query q = getEntityManager().createNamedQuery(query);
		q.setParameter("tipoMascota", tipo);
		q.setParameter("colorPredominante", colorPredominante);		
		List<BPMMascota> list = (List<BPMMascota>) q.getResultList();
		if (list == null || list.size() < 1)
			return new ArrayList<>();
		return list;		
	}

	public Long existeMascotaEnActividad(Long idMascota, Long idActividad, Date fechaDesde) {
		String query = "Bpm.existeMascotaEnActividad";
		Query q = getEntityManager().createNamedQuery(query);
		q.setParameter("idMascota", idMascota);
		q.setParameter("idActividad", idActividad);
		q.setParameter("fechaDesde", fechaDesde);
		List<Long> list = (List<Long>) q.getResultList();
		if (list == null || list.size() < 1)
			return null;
		return (Long) q.getSingleResult();
	}
	
	public List<BPMMascota>  cerrarPeriodoAbiertoParaMascotaEnActividad(Long idMascota, Long idActividad) {
		String query = "Bpm.buscarPeriodosAbiertosParaMascotaEnActividad";
		Query q = getEntityManager().createNamedQuery(query);
		q.setParameter("idMascota", idMascota);
		q.setParameter("idActividad", idActividad);
		List<BPMMascota> list = (List<BPMMascota>) q.getResultList();
		if (list == null || list.size() < 1)
			return new ArrayList<>();
		return list;
	}

	public List<BPMMascota> obtenerMascotasDeBPM(Long idMascota) {
		String query = "Bpm.obtenerMascotasDeBPM";
		Query q = getEntityManager().createNamedQuery(query);
		q.setParameter("idMascota", idMascota);
		List<BPMMascota> list = (List<BPMMascota>) q.getResultList();
		if (list == null || list.size() < 1)
			return new ArrayList<>();
		return list;
	}

	public List<Mascota> obtenerMascotasDeBPMDeUsuario(Long id) {
		String query = "Bpm.obtenerMascotasDeBPMDeUsuario";
		Query q = getEntityManager().createNamedQuery(query);
		q.setParameter("idUsuario", id);
		List<Mascota> list = (List<Mascota>) q.getResultList();
		if (list == null || list.size() < 1)
			return new ArrayList<>();
		return list;		
	}

	public String obtenerUltimoEstadoDeMascotaPorIdMascota(Long id) {
		String query = "Mascota.estadoUltimoDeMascotaPorIdMascota";
		Query q = getEntityManager().createNamedQuery(query);
		q.setParameter("idMascota", id);
		List<String> list = (List<String>) q.getResultList();
		if (list == null || list.size() < 1)
			return null;
		return list.get(0);
	}

	public List<BPMMascota> MascotasDeBPMPorActividad(Long idMascota, String actividad) {
		String query = "Bpm.obtenerMascotasDeBPMPorActividad";
		Query q = getEntityManager().createNamedQuery(query);
		q.setParameter("idMascota", idMascota);
		q.setParameter("actividad", actividad);
		List<BPMMascota> list = (List<BPMMascota>) q.getResultList();
		if (list == null || list.size() < 1)
			return new ArrayList<>();
		return list;
	}

	public List<BPMMascota> obtenerMascotasPerdidasDeBPM(Long idMascotaPerdida) {
		String query = "Bpm.obtenerMascotasPerdidasDeBPM";
		Query q = getEntityManager().createNamedQuery(query);
		q.setParameter("idMascotaPerdida", idMascotaPerdida);
		List<BPMMascota> list = (List<BPMMascota>) q.getResultList();
		if (list == null || list.size() < 1)
			return new ArrayList<>();
		return list;
	}

	public List<BPMMascota> MascotasExtraviadasDeBPMPorActividad(Long idMascota, String actividad) {
		String query = "Bpm.obtenerMascotasExtraviadasDeBPMPorActividad";
		Query q = getEntityManager().createNamedQuery(query);
		q.setParameter("idMascota", idMascota);
		q.setParameter("actividad", actividad);
		List<BPMMascota> list = (List<BPMMascota>) q.getResultList();
		if (list == null || list.size() < 1)
			return new ArrayList<>();
		return list;
	}

	public Mascota buscarMascotaPerdidaPorIdMascota(Long idMascota) {
		String query = "Mascota.buscarMascotaPerdidaPorIdMascota";
		Query q = getEntityManager().createNamedQuery(query);
		q.setParameter("idMascota", idMascota);
		List<Mascota> list = (List<Mascota>) q.getResultList();
		if (list == null || list.size() < 1)
			return null;
		return list.get(0);
	}

	public BPMMascota obtenerBPMDeMascotaExtraviada(Long idMascota) {
		String query = "Bpm.obtenerBPMDeMascotaExtraviada";
		Query q = getEntityManager().createNamedQuery(query);
		q.setParameter("idMascota", idMascota);
		List<BPMMascota> list = (List<BPMMascota>) q.getResultList();
		if (list == null || list.size() < 1)
			return null;
		return list.get(0);
	}
}
