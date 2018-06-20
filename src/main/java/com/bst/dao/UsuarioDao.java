package com.bst.dao;

import java.sql.Date;
import java.util.List;

import com.bst.model.Usuario;

public interface UsuarioDao {

	public void registrar(String nombre, String email, String contrasena, String telefono
			, Date fechaNacimiento, int idCentroOperativo , int idCategoria);
	
	public int logeo(String email, String codigo);
	
	@SuppressWarnings("rawtypes")
	public List getUsuarios();
	
	public Usuario getUsuario(String idUsuario);
}
