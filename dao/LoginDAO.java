package com.issg2.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.issg2.util.AbstractDAO;

@Repository("loginDAO")
public class LoginDAO extends AbstractDAO {

	@SuppressWarnings("unchecked")
	public Map<String, Object> login(Map<String, Object> map) {
		return (Map<String, Object>) selectOne("login.login", map);
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> mypage(Map<String, Object> map) {
		return (Map<String, Object>) selectOne("login.mypage", map);
	}

	public void mypageUpdate(Map<String, Object> map) {
		update("login.mypageUpdate", map);
	}

	public int nickCheck1(String nick) {
		return (int) selectOne("login.nickCheck1", nick);
	}

	public void memberDel1(Map<String, Object> map) {
		update("login.memberDel1", map);
	}


	

}
