package com.issg2.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;


@Service
public interface NoticeService {

	
	public List<Map<String, Object>> noticeList(Map<String, Object> map);


	Map<String, Object> noticeDetail(Map<String, Object> map);


	Map<String, Object> noticeBefore(Map<String, Object> map);


	Map<String, Object> noticeAfter(Map<String, Object> map);


	public int totalCount(Map<String, Object> map);


	public void noticeCount(Map<String, Object> map);




	
	
	
	
	
	
} 