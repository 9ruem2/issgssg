package com.issg2.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service("boardService")
public interface BoardService {

	List<Map<String, Object>> artList(Map<String, Object> map);

	Map<String, Object> artDetail(Map<String, Object> map);

	
	
	int artTotalCount(Map<String, Object> map);

	void artLike(Map<String, Object> map);

	void artCount(Map<String, Object> map);

	

	
	
	
	
	  
}