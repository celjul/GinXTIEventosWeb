package com.bst.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.bst.dao.PonentesDao;
import com.bst.model.Ponentes;

@Repository("ponentesDao")
public class PonentesDaoImpl implements PonentesDao{

	private DataSource dataSource;
	   
	   public void setDataSource(DataSource dataSource) {
	      this.dataSource = dataSource;
	   }
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List getListaPonentes() {
		Connection conn = null;
		List listaPonentes = new ArrayList();
		try {
			String sql = "select * from ponentes ";
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Ponentes ponente = new Ponentes();
				ponente.setId(rs.getInt("id"));
				ponente.setFoto(rs.getString("FOTO"));
				ponente.setNombre(rs.getString("NOMBRE"));
				ponente.setPuesto(rs.getString("PUESTO"));
				ponente.setSemblanza(rs.getString("SEMBLANZA"));
				listaPonentes.add(ponente);
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
	
		
		}return listaPonentes;
	}


	@Override
	public Ponentes getPonenteId(String idPonente) {
	Connection conn = null;
	Ponentes ponente = new Ponentes();
	try {
	String sql = "select * from ponentes where id="+idPonente;
	conn = dataSource.getConnection();
	PreparedStatement ps = conn.prepareStatement(sql);
	ResultSet rs = ps.executeQuery();
	while(rs.next()) {
		
		ponente.setId(rs.getInt("id"));
		ponente.setFoto(rs.getString("FOTO"));
		ponente.setNombre(rs.getString("NOMBRE"));
		ponente.setPuesto(rs.getString("PUESTO"));
		ponente.setSemblanza(rs.getString("SEMBLANZA"));
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

	
	}return ponente;
}


	@Override
	public void updatePonente(String idPonente, String nombre, String puesto, String semblanza) {
		Connection conn = null;
		try {
		String sql = "update ponentes set nombre='"+nombre+"', puesto='"+puesto+"', semblanza='"+semblanza+"' where id="+idPonente;
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
	public void deletePonentes(String idPonente) {
		Connection conn = null;
		try {
		String sql = "delete from ponentes where id="+idPonente;
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
	public void addPonente(String nombre, String puesto, String semblanza, String b) {
		Connection conn = null;
		try {
		String sql = "insert into ponentes(nombre,puesto,semblanza,foto) values('"+nombre+"','"+puesto+"','"+semblanza+"','"+b+"')";
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
