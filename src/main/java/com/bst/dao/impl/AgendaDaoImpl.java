package com.bst.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.bst.dao.AgendaDao;
import com.bst.model.Agenda;
import com.bst.model.Expositores;
import com.bst.model.Ponentes;

@Repository("agendaDao")
public class AgendaDaoImpl implements AgendaDao{

	private DataSource dataSource;
	   
	   public void setDataSource(DataSource dataSource) {
	      this.dataSource = dataSource;
	   }
	
	@SuppressWarnings("deprecation")
	@Override
	public List<Agenda> getAgenda(String Dia) {
		Connection conn = null;
		List listaAgenda = new ArrayList();
	
		try {
			String sql = "SELECT * FROM agenda where hora_inicio between '2018-08-"+Dia+" 00:00:00' and '2018-08-"+Dia+" 23:59:59' order by hora_inicio";
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Agenda  agenda = new Agenda();
				agenda.setId(rs.getInt("id"));
				agenda.setHorainicio(rs.getTimestamp("hora_inicio"));
				agenda.setHorafin(rs.getTimestamp("hora_fin"));
				if(agenda.getHorainicio().getMinutes()==0) {
					agenda.setHorainicioString(agenda.getHorainicio().getHours()+":00" );					
				}else {
					agenda.setHorainicioString(agenda.getHorainicio().getHours()+":"+agenda.getHorainicio().getMinutes() );					
				}
				if(agenda.getHorafin().getMinutes()==0) {
					agenda.setHorafinString(agenda.getHorafin().getHours()+":00" );					
				}else {
					agenda.setHorafinString(agenda.getHorafin().getHours()+":"+agenda.getHorafin().getMinutes() );				
				}
				agenda.setTitulo(rs.getString("titulo"));
				List ponentes = getPonentesAgenda(agenda.getId());
				agenda.setPonentes(ponentes);
				listaAgenda.add(agenda);
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
	
		
		}return listaAgenda;
	}
	
	public List<Ponentes> getPonentesAgenda(int id){
		Connection conn = null;
		List listaPonentes = new ArrayList();
			try {
				String sql ="select ponentes.id as id , ponentes.nombre as nombre  from ponentes,agenda_ponente where agenda_ponente.idponente=ponentes.id and agenda_ponente.idagenda="+id;
				conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				Ponentes ponente = new Ponentes();
				ponente.setId(0);
				ponente.setNombre("");
				listaPonentes.add(ponente);
				while(rs.next()) {
					Ponentes ponente2 = new Ponentes();
					ponente2.setId(rs.getInt("id"));
					ponente2.setNombre(rs.getString("nombre"));
					listaPonentes.add(ponente2);
				}
		rs.close();
		ps.close();}
		catch (SQLException e) {
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
	public void addAgenda(String titulo, String fechainicio, String horainicio, String fechafin, String horafin,
			String[] ponentes) {
		Connection conn = null;
		try {
			String sql = "insert into agenda(hora_inicio,hora_fin,titulo) values('"+fechainicio+" "+horainicio+"','"+fechafin+" "+horafin+"','"+titulo+"')";
			conn = dataSource.getConnection();
			System.out.println(sql);
			PreparedStatement ps = conn.prepareStatement(sql);
			 ps.executeUpdate();			
			ps.close();
			String sql2 ="select id from agenda order by id DESC limit 1 ";
			conn = dataSource.getConnection();
			PreparedStatement ps2 = conn.prepareStatement(sql2);
			ResultSet rs2 = ps2.executeQuery();
			int id=0;
			while(rs2.next()) {
			 id =rs2.getInt("id");}
			int cont = 0;
			while(ponentes.length>cont) {
				String sql3="insert into agenda_ponente(idagenda,idponente) values("+id+","+ponentes[cont]+")";
				cont++;
				PreparedStatement ps3 = conn.prepareStatement(sql3);
				 ps3.executeUpdate();			
				ps3.close();
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
}

	@Override
	public Agenda getEvento(String id) {
		Connection conn = null;
		Agenda  agenda = new Agenda();
		try {
			String sql = "SELECT * FROM agenda where id="+id;
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
				agenda.setId(rs.getInt("id"));
				agenda.setHorainicio(rs.getTimestamp("hora_inicio"));
				agenda.setHorafin(rs.getTimestamp("hora_fin"));
				if(agenda.getHorainicio().getMinutes()==0) {
					agenda.setHorainicioString(agenda.getHorainicio().getHours()+":00" );					
				}else {
					agenda.setHorainicioString(agenda.getHorainicio().getHours()+":"+agenda.getHorainicio().getMinutes() );					
				}
				if(agenda.getHorafin().getMinutes()==0) {
					agenda.setHorafinString(agenda.getHorafin().getHours()+":00" );					
				}else {
					agenda.setHorafinString(agenda.getHorafin().getHours()+":"+agenda.getHorafin().getMinutes() );				
				}
				agenda.setTitulo(rs.getString("titulo"));
				List ponentes = getPonentesAgenda(agenda.getId());
				agenda.setPonentes(ponentes);
	
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
	
		
		}return agenda;
	}

	@Override
	public void deleteEvento(String id) {
		Connection conn=null;
		try {
			String sql = "delete from agenda_ponente where idagenda="+id;
			conn = dataSource.getConnection();
			System.out.println(sql);
			PreparedStatement ps = conn.prepareStatement(sql);
			 ps.executeUpdate();			
			ps.close();
			String sql2 = "delete from agenda where id="+id;
			System.out.println(sql2);
			PreparedStatement ps2 = conn.prepareStatement(sql2);
			 ps2.executeUpdate();			
			ps2.close();
			
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
	public void updateAgenda(String titulo, String fechainicio, String horainicio, String fechafin, String horafin,
			String[] ponentes, String id) {
		Connection conn = null;
		try {
			String sql = "update agenda set hora_inicio = '"+fechainicio+" "+horainicio+"', hora_fin = '"+fechafin+" "+horafin+"',titulo ='"+titulo+"' where id ="+id;
			conn = dataSource.getConnection();
			System.out.println(sql);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.executeUpdate();			
			ps.close();
			String sql2 = "delete from agenda_ponente where idagenda="+id;
			System.out.println(sql2);
			PreparedStatement ps2 = conn.prepareStatement(sql2);
			 ps2.executeUpdate();			
			ps2.close();
			int cont = 0;
			while(ponentes.length>cont) {
				String sql3="insert into agenda_ponente(idagenda,idponente) values("+id+","+ponentes[cont]+")";
				cont++;
				PreparedStatement ps3 = conn.prepareStatement(sql3);
				 ps3.executeUpdate();			
				ps3.close();
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
	}
}
