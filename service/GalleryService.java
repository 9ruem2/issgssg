package com.issg2.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public interface GalleryService {

	public List<Map<String, Object>> galleryList(Map<String, Object> map);

	void galleryWrite(Map<String, Object> map);

	Map<String, Object> galleryDetail(Map<String, Object> map);

	void galleryDelete(Map<String, Object> map);

	int galleryPicDel(Map<String, Object> map);

	public void galleryUpdate1(Map<String, Object> map);

	public void galleryLike(Map<String, Object> map);

	public int galleryTotalCount(Map<String, Object> map);

	public void galleryCommentInsert(Map<String, Object> map);

	public List<Map<String, Object>> galleryCommentsList(Map<String, Object> map);

	public void galleryCommentDelete(Map<String, Object> map);

	public void galleryCount(Map<String, Object> map);

//	public void galleryCommentInsert2(Map<String, Object> map);










	
	
	
	
}