package com.bst.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.bst.dao.GaleriaDao;
import com.bst.model.Galeria;

@Repository("galeriaDao")
public class GaleriaDaoImpl implements GaleriaDao {

	private DataSource dataSource;
	   
	   public void setDataSource(DataSource dataSource) {
	      this.dataSource = dataSource;
	   }
	
	
	@Override
	public List<Galeria> getGaleria() {
		Connection conn = null;
		List<Galeria> listaGaleria = new ArrayList();
	
		try {
			String sql = "SELECT * FROM galeria";
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Galeria galeria = new Galeria();
				galeria.setId(rs.getInt("id"));
				galeria.setFoto(rs.getString("foto"));
				listaGaleria.add(galeria);
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
	
		
		}return listaGaleria;
	}


	@Override
	public void addFoto(String foto) {
		Connection conn = null;
		try {
			String sql = "insert into galeria(foto) values('"+foto+"')";
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
	public void deleteFoto(String id) {
		Connection conn = null;
		try {
			String sql = "delete from galeria where id ="+id;
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
