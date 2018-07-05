package com.bst.dao;

import java.util.List;

import com.bst.model.Agenda;

public interface AgendaDao {

	public List<Agenda> getAgenda(String Dia);

	public void addAgenda(String titulo, String fechainicio, String horainicio, String fechafin, String horafin,
			String[] ponentes);

	public Agenda getEvento(String id);

	public void deleteEvento(String id);

	public void updateAgenda(String titulo, String fechainicio, String horainicio, String fechafin, String horafin,
			String[] ponentes, String id);
	
}
