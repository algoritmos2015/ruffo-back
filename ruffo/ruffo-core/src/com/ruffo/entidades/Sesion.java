package com.ruffo.entidades;

import java.util.Comparator;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Sesion implements java.io.Serializable {

	private static final long serialVersionUID = 1L;	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private Usuario usuario;
	
	@Column(name = "token", unique = true, nullable = false)
	private String token;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaInicio;
	
	@Temporal(TemporalType.TIMESTAMP)
    private Date fechaUltimoAcceso;

	private boolean activa;
	
	private String aplicacion;
	
	private String ipCliente;

	public Sesion() {
	}

	public Sesion(Long id, Usuario usuario, String token, Date fechaInicio, Date fechaUltimoAcceso,
			boolean activa, String aplicacion, String ipCliente) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.token = token;
		this.fechaInicio = fechaInicio;
		this.fechaUltimoAcceso = fechaUltimoAcceso;
		this.activa = activa;
		this.aplicacion = aplicacion;
		this.ipCliente = ipCliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaUltimoAcceso() {
		return fechaUltimoAcceso;
	}

	public void setFechaUltimoAcceso(Date fechaUltimoAcceso) {
		this.fechaUltimoAcceso = fechaUltimoAcceso;
	}

	public boolean isActiva() {
		return activa;
	}

	public void setActiva(boolean activa) {
		this.activa = activa;
	}

	public String getAplicacion() {
		return aplicacion;
	}

	public void setAplicacion(String aplicacion) {
		this.aplicacion = aplicacion;
	}

	public String getIpCliente() {
		return ipCliente;
	}

	public void setIpCliente(String ipCliente) {
		this.ipCliente = ipCliente;
	}
	
	public int compareTo(Sesion sesion) {
		 /* Ordena de mayor a menor por fecha de ultimo acceso **/
	        return this.fechaUltimoAcceso.before(sesion.fechaUltimoAcceso) ? -1 : this.fechaUltimoAcceso.after(sesion.fechaUltimoAcceso) ? 1 : 0;
	}
	
	public static Comparator<Sesion> SesionFechaUltimopAccesoComparator  = new Comparator<Sesion>() {

	public int compare(Sesion fruit1, Sesion fruit2) {
	
		Date fruitName1 = fruit1.getFechaUltimoAcceso();
		Date fruitName2 = fruit2.getFechaUltimoAcceso();		
		
		//ascending order
		return fruitName1.compareTo(fruitName2);		
		
		//descending order
		//return fruitName2.compareTo(fruitName1);
		}
	
	};
}