package com.bst.dao;

import java.util.List;

import com.bst.model.Notificaciones;

public interface NotificacionesDao {
	
	public List getNotificaciones();

	public void addNotificacion(String titulo, String detalle);

	public Notificaciones getNotificacion(String id);

	public void deleteNotificacion(String id);

	public void updateNotificacion(String id, String titulo, String descripcion);

}
