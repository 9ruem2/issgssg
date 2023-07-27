package com.issg2.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.issg2.util.AbstractDAO;

@Repository("membershipDAO")
public class MembershipDAO extends AbstractDAO {

	public int idCheck(String id) {
		
		return (int) selectOne("membership.idCheck", id);
	}

	public int nickCheck(String nick) {
		
		return (int) selectOne("membership.nickCheck", nick);
	}

	public void membership(Map<String, Object> map) {
		
		insert("membership.membership", map);
	}

	

}
