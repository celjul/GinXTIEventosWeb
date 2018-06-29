package com.bst.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.bst.dao.ExpositoresDao;
import com.bst.model.Expositores;


@Repository("expositoresDao")
public class ExpositoresDaoImpl implements ExpositoresDao{

	private DataSource dataSource;
	   
	   public void setDataSource(DataSource dataSource) {
	      this.dataSource = dataSource;
	   }
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List getExpositores() {
		Connection conn = null;
		List listaExpositores = new ArrayList();
		try {
			String sql = "select * from expositores ";
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Expositores expositor = new Expositores();
				expositor.setId(rs.getInt("id"));
				expositor.setLogo(rs.getBlob("LOGO"));
				expositor.setNombre(rs.getString("NOMBRE"));
				expositor.setPaginainternet(rs.getString("PAGINA_INTERNET"));
				expositor.setTwitter(rs.getString("twitter"));
				expositor.setFacebook(rs.getString("facebook"));
				expositor.setGoogle(rs.getString("google"));
				listaExpositores.add(expositor);
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
	
		
		}return listaExpositores;
	}

	
	@Override
	public Expositores getExpositorId(String idExpositor) {
		Connection conn =null;
		Expositores expositor = new Expositores(); 
		try {
			String sql = "select * from expositores where id =' "+idExpositor+"'";
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
				expositor.setId(rs.getInt("id"));
				expositor.setLogo(rs.getBlob("LOGO"));
				expositor.setNombre(rs.getString("NOMBRE"));
				expositor.setPaginainternet(rs.getString("PAGINA_INTERNET"));
				expositor.setTwitter(rs.getString("twitter"));
				expositor.setFacebook(rs.getString("facebook"));
				expositor.setGoogle(rs.getString("google"));
				
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
	
		
		}return expositor;
	}

	@Override
	public void updateExpositor(String idExpositor, String nombre, String facebook, String google,
			String twitter, String paginainternet) {
		Connection conn = null;
		try {
			String sql = "update expositores set NOMBRE = '"+nombre+"', facebook='"+facebook+"',"
					+ " google='"+google+"' , twitter='"+twitter+"' , PAGINA_INTERNET='"+paginainternet+"' where id="+idExpositor+"";
			conn = dataSource.getConnection();
			System.out.println(sql);
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
	}}

	@Override
	public void addExpositor(String nombre, String facebook, String google, String twitter, String paginainternet) {
		Connection conn = null;
		try {
			String sql = "insert into expositores(nombre,facebook,google,twitter,PAGINA_INTERNET) values('"+nombre+"','"+facebook+"','"+google+"','"+twitter+"','"+paginainternet+"')";
			conn = dataSource.getConnection();
			System.out.println(sql);
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
	}}
	
	@Override
	public void deleteExpositor(String idExpositor) {
		Connection conn = null;
		try {
			String sql = "delete from expositores where id ="+idExpositor;
			conn = dataSource.getConnection();
			System.out.println(sql);
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
	}}

}
