package com.bst.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.bst.controller.LlamadasController;
import com.bst.dao.UsuarioDao;
import com.bst.model.CategoriaUsuario;
import com.bst.model.CentroOperativo;
import com.bst.model.EstatusUsuario;
import com.bst.model.Usuario;


@Repository("usuarioDao")
public class UsuariosDaoImpl implements UsuarioDao {

	private DataSource dataSource;
	   
	public void setDataSource(DataSource dataSource) {
	      this.dataSource = dataSource;
	   }
	
	
	@Override
	public void registrar(String nombre, String email, String contrasena, String telefono
			, Date fechaNacimiento, int idCentroOperativo , int idCategoria) {
		Connection conn = null;
		int numero = (int) (Math.random() * 9999) + 1000;
		try {
			String sql = "insert into tblusuarios(nombre,email,contrasena,codigo,telefono,fechanacimiento,idcentrooperativo,idcategoria,idestatus)"
					+ " values('"+nombre+"','"+email+"','"+contrasena+"',"+numero+",'"+telefono+"','"+fechaNacimiento+"',"+idCentroOperativo+","+idCategoria+",1) ";
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.executeUpdate();
			ps.close();
			LlamadasController llamada = new LlamadasController();
			llamada.sendMensajeRegistro(nombre,telefono,numero);
			}catch (SQLException e) {
		throw new RuntimeException(e);
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}		
	}

	@Override
	public int logeo(String email, String codigo) {
		Connection conn = null;
		int a=0;
		try {
			String sql = "select idCategoria from tblusuarios where email = '"+email+"' and contrasena = '"+codigo+"' ";
			conn = dataSource.getConnection();
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.first()) {
				a = rs.getInt("idCategoria");
			}
			rs.close();
			ps.close();
			}catch (SQLException e) {
		throw new RuntimeException(e);
			
			}finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}		
		return a;
	}

	@Override
	public int logeoapp(String email, String codigo) {
		Connection conn = null;
		int a=0;
		try {
			String sql = "select idCategoria from tblusuarios where email = '"+email+"' and codigo = '"+codigo+"' ";
			conn = dataSource.getConnection();
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.first()) {
				a = rs.getInt("idCategoria");
			}
			rs.close();
			ps.close();
			}catch (SQLException e) {
		throw new RuntimeException(e);
			
			}finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}		
		return a;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List getUsuarios() {
		List lista = new ArrayList();
		Connection conn = null;
		try {
			String sql = "select tblusuarios.idUsuarios, tblusuarios.nombre , tblusuarios.email , tblusuarios.telefono , " + 
					"tblusuarios.fechanacimiento , tblcentrooperativo.nombre as centro , tblcategoriausuario.detalle as categoria, " + 
					"tblestatususuarios.detalle as estatus , tblusuarios.empresa as empresa from tblusuarios , tblcategoriausuario , tblcentrooperativo,tblestatususuarios where " + 
					"tblusuarios.idCategoria = tblcategoriausuario.idCategoria and tblusuarios.idCentroOperativo = tblcentrooperativo.idCentroOperativo and " + 
					"tblusuarios.idEstatus = tblestatususuarios.idEstatus;  ";
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setNombre(rs.getString("nombre"));
				usuario.setId(rs.getInt("idUsuarios"));
				usuario.setEmail(rs.getString("email"));
				usuario.setTelefono(rs.getString("telefono"));
				usuario.setFechaNacimiento(rs.getDate("fechanacimiento"));
				EstatusUsuario status = new EstatusUsuario();
				status.setDetalle(rs.getString("estatus"));
				usuario.setEstatus(status);
				CategoriaUsuario categoria = new CategoriaUsuario();
				categoria.setDetalle(rs.getString("categoria"));
				usuario.setCategoria(categoria);
				if(!categoria.getDetalle().equals("Cliente")) {
				CentroOperativo centro = new CentroOperativo();
				centro.setCentroOpeativo(rs.getString("centro"));
				usuario.setCentro(centro);
				usuario.setEmpresa(" ");}
				
				else {
					CentroOperativo centro = new CentroOperativo();
					centro.setCentroOpeativo("");
					usuario.setCentro(centro);
					usuario.setEmpresa(rs.getString("empresa"));
				}
				
				lista.add(usuario);
			}
			rs.close();
			ps.close();
		}catch (SQLException e) {
			throw new RuntimeException(e);
			
		}finally {
		if (conn != null) {
			try {
			conn.close();
			} catch (SQLException e) {}
		}
	}		
		return lista;
	}

	@Override
	public Usuario getUsuario(String idUsuario) {
		Connection conn = null;
		Usuario usuario = new Usuario();
		try {
			String sql = "select tblusuarios.idUsuarios, tblusuarios.nombre , tblusuarios.email , tblusuarios.telefono , tblusuarios.fechanacimiento , " + 
					"tblcentrooperativo.nombre as centro ,tblusuarios.empresa as empresa ,tblcentrooperativo.idCentroOperativo as idcentro , " + 
					"tblcategoriausuario.detalle as categoria, tblcategoriausuario.idCategoria as idcategoria," + 
					"tblestatususuarios.detalle as estatus , tblestatususuarios.idEstatus as idEstatus from tblusuarios , tblcategoriausuario , tblcentrooperativo,tblestatususuarios where " + 
					"tblusuarios.idCategoria = tblcategoriausuario.idCategoria and tblusuarios.idCentroOperativo = tblcentrooperativo.idCentroOperativo and " + 
					"tblusuarios.idEstatus = tblestatususuarios.idEstatus and tblusuarios.idUsuarios = "+idUsuario;
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				CentroOperativo centro = new CentroOperativo();
				CategoriaUsuario categoria = new CategoriaUsuario();
				EstatusUsuario status = new EstatusUsuario();
				usuario.setId(rs.getInt("idUsuarios"));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setEmail(rs.getString("email"));
				usuario.setTelefono(rs.getString("telefono"));
				usuario.setFechaNacimiento(rs.getDate("fechanacimiento"));
				categoria.setId(rs.getInt("idcategoria"));
				categoria.setDetalle(rs.getString("categoria"));
				status.setId(rs.getInt("idEstatus"));
				status.setDetalle(rs.getString("estatus"));
				usuario.setEmpresa(" ");
				centro.setCentroOpeativo(rs.getString("centro"));
				centro.setId(rs.getInt("idcentro"));
				usuario.setCentro(centro);
				usuario.setCategoria(categoria);
				if(usuario.getCategoria().getId()==2) {
					usuario.setEmpresa(rs.getString("empresa"));
				}
				usuario.setEstatus(status);
			}
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
			
		}finally {
		if (conn != null) {
			try {
			conn.close();
			} catch (SQLException e) {}
		}
	}		
		return usuario;
	}

	@Override
	public void registrarCliente(String nombre, String email, String contrasena, String telefono, Date fechaNacimiento,
			String empresa, int idCategoria) {
		Connection conn = null;
		int numero = (int) (Math.random() * 9999) + 1000;
		try {
			String sql = "insert into tblusuarios(nombre,email,codigo,contrasena,telefono,fechanacimiento,empresa,idcategoria,idestatus)"
					+ " values('"+nombre+"','"+email+"',"+numero+",'"+contrasena+"','"+telefono+"','"+fechaNacimiento+"','"+empresa+"',"+idCategoria+",1) ";
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.executeUpdate();
			ps.close();
			LlamadasController llamada = new LlamadasController();
			llamada.sendMensajeRegistro(nombre,telefono,numero);
			}catch (SQLException e) {
		throw new RuntimeException(e);
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}		
	}

	@Override
	public void editarUsuario(String nombre, String email, String telefono, Date fechaNacimiento, String centro,
			int categoria, int status, String empresa, String idUsuario) {
		Connection conn = null;
		try {
			String sql = "update tblusuarios set nombre = '"+nombre+"', email = '"+email+"', telefono='"+telefono+"', fechanacimiento='"+fechaNacimiento+"'"
					+ ", idCentroOperativo="+centro+" , idCategoria="+categoria+", idEstatus="+status+", empresa='"+empresa+"' where idUsuarios="+idUsuario;
			System.out.println(sql);
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.executeUpdate();
			ps.close();
		}
			catch (SQLException e) {
				throw new RuntimeException(e);
				
			}finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}		
		
	}


}
