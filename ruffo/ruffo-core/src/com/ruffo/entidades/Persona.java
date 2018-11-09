package com.ruffo.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Entity implementation class for Entity: Persona
 *
 */
@Entity
public class Persona implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nombre;
	
	private String apellido;
	
	@Column(unique=true)
	private String ci;
	
	private String domicilio;
	
	private String telefono;
	
	@Column(unique=true)
	private String celular;
	
	@Column(unique=true, nullable = false)
	private String eMail;
	
	private Date fechaNacimiento;	
	//@JoinColumn(name="id_pago")//Indico el dueño y nombre del atributo de la relación. Es decir, en qué tabla se almacena el id
	//(mappedBy="persona")//Persona no es dueña de la relación, pero indico el campo que hago el mapeo para obtener la relacion direccional.
	//OneToMany por defecto es lazy
	//@OneToMany(mappedBy = "persona", cascade = {CascadeType.ALL})
//	private List<Long> idsMascotas = new ArrayList<>();	
	@Column(nullable = true)
	private String rutaImagen;

	public Persona() {
		super();
	}   	
	
	public Persona(Long id, String nombre, String apellido, String ci, String domicilio, String telefono,
			String celular, String eMail, Date fechaNacimiento, String rutaImagen) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.ci = ci;
		this.domicilio = domicilio;
		this.telefono = telefono;
		this.celular = celular;
		this.eMail = eMail;
		this.fechaNacimiento = fechaNacimiento;
		this.rutaImagen = rutaImagen;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	
	public String getCi() {
		return ci;
	}

	public void setCi(String ci) {
		this.ci = ci;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getRutaImagen() {
		return rutaImagen;
	}

	public void setRutaImagen(String rutaImagen) {
		this.rutaImagen = rutaImagen;
	}	
   
}