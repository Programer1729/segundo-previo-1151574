package com.perez.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity 
@Table(name="tienda")
public class Tienda {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id; 
	
	@Column
	private String nombre; 

	@Column
	private String lema; 
	
	@Column
	private String descripcion;
	
	@Column
	private String email;
	
	@Column
	private String clave;
	
	@Column
	private String propietario;
	
	@Column
	private String facebook;
	
	@Column
	private String web;
	
	@Column
	private String imagen;
	
	/*@OneToMany(mappedBy="tienda")
	private List<Servicio> servicios = new ArrayList<Servicio>();*/
	
	/*@ManyToMany
	private List<Cliente> clientes = new ArrayList<Cliente>();*/

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLema() {
		return lema;
	}

	public void setLema(String lema) {
		this.lema = lema;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getPropietario() {
		return propietario;
	}

	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	/*public List<Servicio> getServicios() {
		return servicios;
	}

	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}*/

	@Override
	public String toString() {
		return "Tienda [id=" + id + ", nombre=" + nombre + ", lema=" + lema + ", descripcion=" + descripcion
				+ ", email=" + email + ", clave=" + clave + ", propietario=" + propietario + ", facebook=" + facebook
				+ ", web=" + web + ", imagen=" + imagen + "]";
	}
	
	
}
