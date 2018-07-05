package com.bst.dao;

import java.util.List;

import com.bst.model.Sponsors;


public interface SponsorsDao {	
	
	public List getSponsors();

public Sponsors getSponsorsId(String idSponsors);

public void updateSponsors(String idSponsors, String nombre, String facebook, String google,
		String twitter, String paginainternet,String logo);

public void addSponsors(String nombre, String facebook, String google, String twitter, String paginainternet,String b);

void deleteSponsors(String idSponsors);

}