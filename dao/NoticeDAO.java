package com.issg2.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.issg2.util.AbstractDAO;

@Repository("noticeDAO")
public class NoticeDAO extends AbstractDAO {
	
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> noticeList(Map<String, Object> map) {
		return selectList("notice.noticeList",map);
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> noticeDetail(Map<String, Object> map) {
		return (Map<String, Object>) selectOne("notice.noticeDetail",map);
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> noticeBefore(Map<String, Object> map) {
		return (Map<String, Object>) selectOne("notice.noticeBefore",map);
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> noticeAfter(Map<String, Object> map) {
		return (Map<String, Object>) selectOne("notice.noticeAfter",map);
	}

	public int totalCount(Map<String, Object> map) {
		return (int) selectOne("notice.totalCount",map);
	}

	public void noticeCount(Map<String, Object> map) {
		update("notice.noticeCount", map);
		
	}


	

	

	
//페이지네이션
	
  


}
