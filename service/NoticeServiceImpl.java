package com.issg2.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.issg2.dao.NoticeDAO;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {

	@Resource(name="noticeDAO")
	private NoticeDAO noticeDAO;


	@Override
	public List<Map<String, Object>> noticeList(Map<String, Object> map) {
		return noticeDAO.noticeList(map);
	}

	@Override
	public Map<String, Object> noticeDetail(Map<String, Object> map) {
		return noticeDAO.noticeDetail(map);
	}

	@Override
	public Map<String, Object> noticeBefore(Map<String, Object> map) {
		return noticeDAO.noticeBefore(map);
	}

	@Override
	public Map<String, Object> noticeAfter(Map<String, Object> map) {
		return noticeDAO.noticeAfter(map);
	}

	@Override
	public int totalCount(Map<String, Object> map) {
		return noticeDAO.totalCount(map);
	}

	@Override
	public void noticeCount(Map<String, Object> map) {
		noticeDAO.noticeCount(map);
		
	}


	

	

	

	
	
} 
