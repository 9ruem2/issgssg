package com.issg2.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public interface HomeService {

	List<Map<String, Object>> indexNoticeList();

	List<Map<String, Object>> indexGalleryList();

	List<Map<String, Object>> indexGallWeekList();

	List<Map<String, Object>> indexArtList();

	
	
	
	
}