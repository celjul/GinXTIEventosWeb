package com.bst.model;

import java.sql.Date;

public class Usuario {

	private int id;
	
	private String nombre;
	
	private String email;
	
	private String telefono;
	
	private Date fechaNacimiento;
	
	private CentroOperativo centro;
	
	private CategoriaUsuario categoria;
	
	private EstatusUsuario estatus;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public CentroOperativo getCentro() {
		return centro;
	}

	public void setCentro(CentroOperativo centro) {
		this.centro = centro;
	}

	public CategoriaUsuario getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaUsuario categoria) {
		this.categoria = categoria;
	}

	public EstatusUsuario getEstatus() {
		return estatus;
	}

	public void setEstatus(EstatusUsuario estatus) {
		this.estatus = estatus;
	}
}
