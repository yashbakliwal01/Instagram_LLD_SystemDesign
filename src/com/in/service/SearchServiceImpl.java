package com.in.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import com.in.dto.Profile;
import com.in.dto.SearchCatalog;
import com.in.interfaces.SearchService;

public class SearchServiceImpl implements SearchService{

	Map<String, Profile> profileMap = SearchCatalog.getInstance().getProfiles();
	
	private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	
	public void addProfile(Profile profile) {
		lock.writeLock().lock();
		try {
			profileMap.put(profile.getEmail(), profile);
			profileMap.put(profile.getId(), profile);
//			profileList.add(profile);
		}finally {
			lock.writeLock().unlock();
		}
	}
	
	@Override
	public List<Profile> searchProfile(String searchKey) {
		List<Profile> result = new ArrayList<>();
		if(searchKey == null || searchKey.trim().isEmpty()) return result;
		lock.readLock().lock();
		try {
			for(Profile profile: profileMap.values()) {
				if(profile.getEmail().toLowerCase().contains(searchKey.toLowerCase()) || 
					profile.getId().toLowerCase().contains(searchKey.toLowerCase())) {
					result.add(profile);
				}
			}
		}finally {
			lock.readLock().unlock();
		}
		return result;
	}

}
