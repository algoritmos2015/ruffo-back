package com.ruffo.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UsuarioDto {

	private Long id;
	private String eMail;	
	private String clave;
	private String nombreUsuario;
	private String nombre;
	private String apellido;
	private String ci;	
	private String domicilio;	
	private String telefono;	
	private String celular;	
	private Date fechaNacimiento;
	private String fechaNacimientoString;
	private String tipoUsuario;	
	private String imagen;	
	private String pais;	
	private Integer cantLogeosPermitidos;	
	private Integer cantLogeosFallidos;	
	private List<RolDto> roles = new ArrayList<>();
	private List<MascotaDto> mascotas;
	private String sexo;
	
	public UsuarioDto() {
	}
	
	public UsuarioDto(Long id, String nombreUsuario, String clave, String nombre, String apellido, String ci,
			String domicilio, String telefono, String celular, String eMail, Date fechaNacimiento, String fechaNacimientoString, String tipoUsuario,
			String imagen, String pais, Integer cantLogeosPermitidos, Integer cantLogeosFallidos, List<RolDto> roles,
			List<MascotaDto> mascotas, String sexo) {
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
		this.roles = roles;
		this.mascotas = mascotas;
		this.sexo = sexo;
		this.fechaNacimientoString = fechaNacimientoString;
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
	public String getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
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
	public void setCantLogeosFallidos(Integer cantLogeosFallidos) {
		this.cantLogeosFallidos = cantLogeosFallidos;
	}
	public List<RolDto> getRoles() {
		return roles;
	}
	public void setRoles(List<RolDto> roles) {
		this.roles = roles;
	}
	public List<MascotaDto> getMascotas() {
		return mascotas;
	}
	public void setMascotas(List<MascotaDto> mascotas) {
		this.mascotas = mascotas;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getFechaNacimientoString() {
		return fechaNacimientoString;
	}

	public void setFechaNacimientoString(String fechaNacimientoString) {
		this.fechaNacimientoString = fechaNacimientoString;
	}	
}
