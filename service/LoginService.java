package com.issg2.service;

import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public interface LoginService {

	Map<String, Object> login(Map<String, Object> map);

	Map<String, Object> mypage(Map<String, Object> map);

	void mypageUpdate(Map<String, Object> map);

	int nickCheck1(String nick);

	void memberDel1(Map<String, Object> map);





	
	
	
	
}