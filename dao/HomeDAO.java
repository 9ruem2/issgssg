package com.issg2.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.issg2.util.AbstractDAO;

@Repository("homeDAO")
public class HomeDAO extends AbstractDAO {

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> indexNoticeList() {
		return selectList("home.indexNoticeList");
	}

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> indexGalleryList() {
		return selectList("home.indexGalleryList");
	}

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> indexGallWeekList() {
		return selectList("home.indexGallWeekList");
	}

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> indexArtList() {
		return selectList("home.indexArtList");
	}


}
