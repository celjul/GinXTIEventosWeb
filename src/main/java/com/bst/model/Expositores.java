package com.bst.model;

import java.sql.Blob;

public class Expositores {
	
	private int id;
	private String logo;
	private String nombre;
	private String paginainternet;
	private String twitter;
	private String facebook;
	private String google;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPaginainternet() {
		return paginainternet;
	}
	public void setPaginainternet(String paginainternet) {
		this.paginainternet = paginainternet;
	}
	public String getTwitter() {
		return twitter;
	}
	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}
	public String getFacebook() {
		return facebook;
	}
	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}
	public String getGoogle() {
		return google;
	}
	public void setGoogle(String google) {
		this.google = google;
	}
		
}
