package com.bst.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.bst.dao.CentroOperativoDao;
import com.bst.model.CentroOperativo;


@Repository("centrosDao")
public class CentroOperativoDaoImpl implements CentroOperativoDao {

	private DataSource dataSource;
	   
	   public void setDataSource(DataSource dataSource) {
	      this.dataSource = dataSource;
	   }
	
	@SuppressWarnings({ "finally", "rawtypes", "unchecked" })
	@Override
	public List getCentroOperativos() {
		List listaCentrosOpertivos = new ArrayList<>();
		Connection conn = null;
		try {
			String sql = "select * from tblcentrooperativo ";
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				CentroOperativo centro = new CentroOperativo();
				centro.setId(rs.getInt("idCentroOperativo"));
				centro.setCentroOpeativo(rs.getString("nombre"));
				listaCentrosOpertivos.add(centro);
			}
			ps.close();
			}catch (SQLException e) {
		throw new RuntimeException(e);
			
			}finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		
		return listaCentrosOpertivos;
			}
		}

}
