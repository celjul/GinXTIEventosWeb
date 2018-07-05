package com.bst.dao;

import java.util.List;

import com.bst.model.Expositores;

public interface ExpositoresDao {
	
	public List getExpositores();
	
	public Expositores getExpositorId(String idExpositor);

	public void updateExpositor(String idExpositor, String nombre, String facebook, String google,
			String twitter, String paginainternet,String logo);

	public void addExpositor(String nombre, String facebook, String google, String twitter, String paginainternet,String b);

	void deleteExpositor(String idExpositor);

}
