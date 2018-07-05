package com.bst.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.bst.dao.SponsorsDao;
import com.bst.model.Sponsors;

@Repository("sponsorsDao")
public class SponsorsDaoImpl implements SponsorsDao{

	private DataSource dataSource;
	   
	   public void setDataSource(DataSource dataSource) {
	      this.dataSource = dataSource;
	   }
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List getSponsors() {
		Connection conn = null;
		List listaExpositores = new ArrayList();
		try {
			String sql = "select * from sponsors ";
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Sponsors sponsors = new Sponsors();
				sponsors.setId(rs.getInt("id"));
				sponsors.setLogo(rs.getString("LOGO"));
				sponsors.setNombre(rs.getString("NOMBRE"));
				sponsors.setPaginainternet(rs.getString("PAGINA_INTERNET"));
				sponsors.setTwitter(rs.getString("twitter"));
				sponsors.setFacebook(rs.getString("facebook"));
				sponsors.setGoogle(rs.getString("google"));
				listaExpositores.add(sponsors);
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
	public Sponsors getSponsorsId(String idsponsors) {
		Connection conn =null;
		Sponsors sponsors = new Sponsors(); 
		try {
			String sql = "select * from sponsors where id =' "+idsponsors+"'";
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
				sponsors.setId(rs.getInt("id"));
				sponsors.setLogo(rs.getString("LOGO"));
				sponsors.setNombre(rs.getString("NOMBRE"));
				sponsors.setPaginainternet(rs.getString("PAGINA_INTERNET"));
				sponsors.setTwitter(rs.getString("twitter"));
				sponsors.setFacebook(rs.getString("facebook"));
				sponsors.setGoogle(rs.getString("google"));
				
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
	
		
		}return sponsors;
	}

	@Override
	public void updateSponsors(String idsponsors, String nombre, String facebook, String google,
			String twitter, String paginainternet,String logo) {
		Connection conn = null;
		try {
			String sql = "update sponsors set NOMBRE = '"+nombre+"', facebook='"+facebook+"',"
					+ " google='"+google+"' , twitter='"+twitter+"' , PAGINA_INTERNET='"+paginainternet+"', LOGO='"+logo+"' where id="+idsponsors+"";
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
	public void addSponsors(String nombre, String facebook, String google, String twitter, String paginainternet,String b) {
		Connection conn = null;
		try {
			String sql = "insert into sponsors(nombre,facebook,google,twitter,PAGINA_INTERNET,LOGO) values('"+nombre+"','"+facebook+"','"+google+"','"+twitter+"','"+paginainternet+"','"+b+"')";
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
	public void deleteSponsors(String idsponsors) {
		Connection conn = null;
		try {
			String sql = "delete from sponsors where id ="+idsponsors;
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