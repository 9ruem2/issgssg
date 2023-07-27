package com.issg2.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.issg2.dao.BoardDAO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Resource(name="boardDAO")
	private BoardDAO boardDAO;

	@Override
	public List<Map<String, Object>> artList(Map<String, Object> map) {
		
		return boardDAO.artList(map);
	}

	@Override
	public Map<String, Object> artDetail(Map<String, Object> map) {
		
		return boardDAO.artDetail(map);
	}

	

	@Override
	public int artTotalCount(Map<String, Object> map) {
		
		return boardDAO.artTotalCount(map);
	}

	@Override
	public void artLike(Map<String, Object> map) {
		boardDAO.artLike(map);
		
	}

	@Override
	public void artCount(Map<String, Object> map) {
		boardDAO.artCount(map);
		
	}

	
	

}
