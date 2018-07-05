package com.bst.dao;

import java.sql.Blob;
import java.util.List;

import com.bst.model.Ponentes;

public interface PonentesDao {
	
	public List getListaPonentes();

	public Ponentes getPonenteId(String idPonente);

	public void updatePonente(String idPonente, String nombre, String puesto, String semblanza,String foto);

	public void deletePonentes(String idPonente);

	public void addPonente(String nombre, String puesto, String semblanza, String b);

}
