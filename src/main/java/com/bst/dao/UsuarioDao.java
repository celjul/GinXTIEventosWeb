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
	
	public void registrarCliente(String nombre, String email, String contrasena, String telefono
			, Date fechaNacimiento, String empresa , int idCategoria);
	
	public void editarUsuario(String nombre, String email, String telefono, Date fechaNacimiento, String centro, int categoria, int status, String empresa, String idUsuario);
	
	public Usuario logeoapp(String email, String codigo);

}
