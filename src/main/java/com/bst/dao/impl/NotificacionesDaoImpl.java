package com.bst.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.bst.dao.NotificacionesDao;
import com.bst.model.Notificaciones;

@Repository("notificacionesDao")
public class NotificacionesDaoImpl implements NotificacionesDao{
	
	private DataSource dataSource;
	   
	   public void setDataSource(DataSource dataSource) {
	      this.dataSource = dataSource;
	   }
	

	@Override
	public List getNotificaciones() {
		Connection conn = null;
		List<Notificaciones> listaNotificaciones = new ArrayList();
	
		try {
			String sql = "SELECT * FROM notificacionesportal";
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Notificaciones notificacion = new Notificaciones();
				notificacion.setTitulo(rs.getString("titulo"));
				notificacion.setId(rs.getInt("id"));
				notificacion.setDescripcion(rs.getString("descripcion"));
				listaNotificaciones.add(notificacion);
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
	
		
		}return listaNotificaciones;
	}


	@Override
	public void addNotificacion(String titulo, String detalle) {
		Connection conn = null;
		try {
			String sql = "insert into notificacionesportal(titulo,descripcion)values('"+titulo+"','"+detalle+"')";
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
	public Notificaciones getNotificacion(String id) {
		Connection conn = null;
		Notificaciones notificacion = new Notificaciones();
	
		try {
			String sql = "SELECT * FROM notificacionesportal where id ="+id;
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
				notificacion.setTitulo(rs.getString("titulo"));
				notificacion.setId(rs.getInt("id"));
				notificacion.setDescripcion(rs.getString("descripcion"));
				
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
	
		
		}return notificacion;
	}


	@Override
	public void deleteNotificacion(String id) {
		Connection conn = null;
		try {
			String sql = "delete from notificacionesportal where id = "+id;
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
	public void updateNotificacion(String id, String titulo, String descripcion) {
		Connection conn = null;
		try {
			String sql = "update  notificacionesportal set titulo ='"+titulo+"' , descripcion ='"+descripcion+"' where id = "+id;
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
}
