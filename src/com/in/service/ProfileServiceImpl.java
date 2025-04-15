package com.in.service;

import com.in.dto.Profile;
import com.in.dto.SearchCatalog;
import com.in.interfaces.ProfileService;

public class ProfileServiceImpl implements ProfileService{

	@Override
	public void createProfile(String email, String password, String id) {
		Profile profile = new Profile(email, password, id);
		SearchCatalog searchCatalog = SearchCatalog.getInstance();
		searchCatalog.getProfiles().put(id, profile);
	}
	
//	private boolean check

}
