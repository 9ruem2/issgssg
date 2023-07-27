package com.issg2.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.issg2.util.AbstractDAO;

@Repository("boardDAO")
public class BoardDAO extends AbstractDAO {

	
	public List<Map<String, Object>> artList(Map<String, Object> map) {
		
		return selectList("board.artList",map);
	}

	public Map<String, Object> artDetail(Map<String, Object> map) {
		
		return (Map<String, Object>) selectOne("board.artDetail", map);
	}
	
	
	

	public int artTotalCount(Map<String, Object> map) {
		
		return (int) selectOne("board.artTotalCount", map);
	}

	public void artLike(Map<String, Object> map) {
		update("board.artLike", map);
		
	}

	public void artCount(Map<String, Object> map) {
		update("board.artCount", map);
		
	}


	  

}
