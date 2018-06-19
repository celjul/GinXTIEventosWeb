package com.bst.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.bst.dao.UsuarioDao;


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
		try {
			String sql = "insert into tblusuarios(nombre,email,contrasena,telefono,fechanacimiento,idcentrooperativo,idcategoria,idestatus)"
					+ " values('"+nombre+"','"+email+"','"+contrasena+"','"+telefono+"','"+fechaNacimiento+"',"+idCentroOperativo+","+idCategoria+",1) ";
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.executeUpdate();
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

}
