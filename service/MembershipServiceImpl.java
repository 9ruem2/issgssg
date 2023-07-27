package com.issg2.service;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.issg2.dao.MembershipDAO;

@Service("membershipService")
public class MembershipServiceImpl implements MembershipService {

	@Resource(name="membershipDAO")
	private MembershipDAO membershipDAO;

	@Override
	public int idCheck(String id) {
		
		return membershipDAO.idCheck(id);
	}

	@Override
	public int nickCheck(String nick) {
		
		return membershipDAO.nickCheck(nick);
	}

	@Override
	public void membership(Map<String, Object> map) {
		
		membershipDAO.membership(map);
		
	} 
	

}
