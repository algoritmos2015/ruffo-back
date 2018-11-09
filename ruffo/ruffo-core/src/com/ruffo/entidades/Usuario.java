package com.ruffo.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * Entity implementation class for Entity: Usuario
 *
//@JoinColumn(name="id_pago")//Indico el dueño y nombre del atributo de la relación. Es decir, en qué tabla se almacena el id
//(mappedBy="persona")//Persona no es dueña de la relación, pero indico el campo que hago el mapeo para obtener la relacion direccional.
//OneToMany por defecto es lazy
//@OneToMany(mappedBy = "persona", cascade = {CascadeType.ALL})
//	private List<Long> idsMascotas = new ArrayList<>();	
 */
@Entity
public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(unique=true, nullable = false)
	private String nombreUsuario;
	
	@Column(nullable = false)
	private String clave;
	
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
	
	@OneToOne
	private TipoUsuario tipoUsuario;
	
	@Lob
	private String imagen;
	
	@OneToOne
	private Pais pais;
	
	private Integer cantLogeosPermitidos;
	
	private Integer cantLogeosFallidos;
	
	private Boolean activo;
	
	private String codigoActivacion;
	
	@OneToOne
	private Sexo sexo;
	
	@OneToMany(cascade = {CascadeType.ALL}, fetch= FetchType.LAZY)
	private List<Rol> roles;
	
	@OneToMany(cascade = {CascadeType.ALL}, mappedBy="propietario")
	private List<Mascota> mascotas;
	
	private Boolean actualizarClave;
	
	public Usuario() {
		super();
	}

	public Usuario(Long id, String nombreUsuario, String clave, String nombre, String apellido, String ci,
			String domicilio, String telefono, String celular, String eMail, Date fechaNacimiento,
			TipoUsuario tipoUsuario, String imagen, Pais pais, Integer cantLogeosPermitidos, Integer cantLogeosFallidos,
			Boolean activo, String codigoActivacion, Sexo sexo, List<Rol> roles, List<Mascota> mascotas,
			Boolean actualizarClave) {
		super();
		this.id = id;
		this.nombreUsuario = nombreUsuario;
		this.clave = clave;
		this.nombre = nombre;
		this.apellido = apellido;
		this.ci = ci;
		this.domicilio = domicilio;
		this.telefono = telefono;
		this.celular = celular;
		this.eMail = eMail;
		this.fechaNacimiento = fechaNacimiento;
		this.tipoUsuario = tipoUsuario;
		this.imagen = imagen;
		this.pais = pais;
		this.cantLogeosPermitidos = cantLogeosPermitidos;
		this.cantLogeosFallidos = cantLogeosFallidos;
		this.activo = activo;
		this.codigoActivacion = codigoActivacion;
		this.sexo = sexo;
		this.roles = roles;
		this.mascotas = mascotas;
		this.actualizarClave = actualizarClave;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getNombre() {
		return nombre;
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

	public String getCi() {
		return ci;
	}

	public void setCi(String ci) {
		this.ci = ci;
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

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}



	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public Integer getCantLogeosPermitidos() {
		return cantLogeosPermitidos;
	}

	public void setCantLogeosPermitidos(Integer cantLogeosPermitidos) {
		this.cantLogeosPermitidos = cantLogeosPermitidos;
	}

	public Integer getCantLogeosFallidos() {
		return cantLogeosFallidos;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public void setCantLogeosFallidos(Integer cantLogeosFallidos) {
		this.cantLogeosFallidos = cantLogeosFallidos;
	}
	
	public String getCodigoActivacion() {
		return codigoActivacion;
	}

	public void setCodigoActivacion(String codigoActivacion) {
		this.codigoActivacion = codigoActivacion;
	}

	public List<Rol> getRoles() {
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}

	public List<Mascota> getMascotas() {
		return mascotas;
	}

	public void setMascotas(List<Mascota> mascotas) {
		this.mascotas = mascotas;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public Boolean getActualizarClave() {
		return actualizarClave;
	}

	public void setActualizarClave(Boolean actualizarClave) {
		this.actualizarClave = actualizarClave;
	}	
}
