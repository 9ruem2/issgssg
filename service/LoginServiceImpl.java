package com.issg2.service;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.issg2.dao.LoginDAO;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

	@Resource(name="loginDAO")
	private LoginDAO loginDAO;

	@Override
	public Map<String, Object> login(Map<String, Object> map) {
		return loginDAO.login(map);
	}

	@Override
	public Map<String, Object> mypage(Map<String, Object> map) {
		return loginDAO.mypage(map);
	}

	@Override
	public void mypageUpdate(Map<String, Object> map) {
		loginDAO.mypageUpdate(map);
	}

	@Override
	public int nickCheck1(String nick) {
		return loginDAO.nickCheck1(nick);
	}

	@Override
	public void memberDel1(Map<String, Object> map) {
		loginDAO.memberDel1(map);
	}





	
	

}
