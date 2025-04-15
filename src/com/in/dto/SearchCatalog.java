package com.in.dto;

import java.util.HashMap;
import java.util.Map;

public class SearchCatalog {

	private Map<String, Profile> profiles;
	private static volatile SearchCatalog searchCatalog=null;

	public SearchCatalog() {
		this.profiles = new HashMap<String, Profile>();
	}
	
	public static SearchCatalog getInstance() {
		if(searchCatalog == null) {
			synchronized (SearchCatalog.class) {
				if(searchCatalog == null) {
					searchCatalog = new SearchCatalog();
				}
			}
		}
		return searchCatalog;
	}

	public Map<String, Profile> getProfiles() {
		return profiles;
	}

	public void setProfiles(Map<String, Profile> profiles) {
		this.profiles = profiles;
	}
} 

