package com.bst.dao;

import java.sql.Date;
import java.util.List;

public interface UsuarioDao {

	public void registrar(String nombre, String email, String contrasena, String telefono
			, Date fechaNacimiento, int idCentroOperativo , int idCategoria);
	
	public int logeo(String email, String codigo);
	
	public List getUsuariosDao();
}
