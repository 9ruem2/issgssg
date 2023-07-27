package com.issg2.service;

import java.util.Map;

public interface MembershipService {

	int idCheck(String id);

	int nickCheck(String nick);

	void membership(Map<String, Object> map);
	
	
	
	
}