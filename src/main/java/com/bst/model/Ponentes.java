package com.bst.model;

import java.sql.Blob;

public class Ponentes {
	
	private int id;
	private Blob foto;
	private String nombre;
	private String puesto;
	private String semblanza;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Blob getFoto() {
		return foto;
	}
	public void setFoto(Blob foto) {
		this.foto = foto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPuesto() {
		return puesto;
	}
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
	public String getSemblanza() {
		return semblanza;
	}
	public void setSemblanza(String semblanza) {
		this.semblanza = semblanza;
	}
}
