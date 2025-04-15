package com.in.interfaces;

import java.util.List;

import com.in.dto.Profile;

public interface SearchService {
	List<Profile> searchProfile(String searchKey);
}
