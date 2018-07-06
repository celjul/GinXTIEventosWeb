package com.bst.dao;

import java.util.List;

import com.bst.model.Galeria;

public interface GaleriaDao {

	public List<Galeria> getGaleria();

	public void addFoto(String foto);

	public void deleteFoto(String id);

	
}
