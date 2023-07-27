package com.issg2.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.issg2.dao.HomeDAO;

@Service("homeService")
public class HomeServiceImpl implements HomeService {

	@Resource(name="homeDAO")
	private HomeDAO homeDAO;

	@Override
	public List<Map<String, Object>> indexNoticeList() {
		return homeDAO.indexNoticeList();
	}

	@Override
	public List<Map<String, Object>> indexGalleryList() {
		return homeDAO.indexGalleryList();
	}

	@Override
	public List<Map<String, Object>> indexGallWeekList() {
		return homeDAO.indexGallWeekList();
	}

	@Override
	public List<Map<String, Object>> indexArtList() {
		return homeDAO.indexArtList();
	}

	
	
	

}
