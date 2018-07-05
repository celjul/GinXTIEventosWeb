package com.bst.model;


import java.sql.Timestamp;
import java.util.List;

public class Agenda {

		private Timestamp horainicio;
		private Timestamp horafin;
		private String horainicioString;
		private String horafinString;
		
		private int id;
		private String titulo;
		private List<Ponentes> ponentes;
		
		
		public String getHorainicioString() {
			return horainicioString;
		}
		public void setHorainicioString(String horainicioString) {
			this.horainicioString = horainicioString;
		}
		public String getHorafinString() {
			return horafinString;
		}
		public void setHorafinString(String horafinString) {
			this.horafinString = horafinString;
		}

		public Timestamp getHorainicio() {
			return horainicio;
		}
		public void setHorainicio(Timestamp horainicio) {
			this.horainicio = horainicio;
		}
		public Timestamp getHorafin() {
			return horafin;
		}
		public void setHorafin(Timestamp horafin) {
			this.horafin = horafin;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getTitulo() {
			return titulo;
		}
		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}
		public List<Ponentes> getPonentes() {
			return ponentes;
		}
		public void setPonentes(List<Ponentes> ponentes) {
			this.ponentes = ponentes;
		}
		
		
	
}
