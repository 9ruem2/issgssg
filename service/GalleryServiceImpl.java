package com.issg2.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.issg2.dao.GalleryDAO;

@Service("galleryService")
public class GalleryServiceImpl implements GalleryService {

	@Resource(name="galleryDAO")
	private GalleryDAO galleryDAO;

	@Override
	public List<Map<String, Object>> galleryList(Map<String, Object> map) {
		return galleryDAO.galleryList(map);
	}

	@Override
	public void galleryWrite(Map<String, Object> map) {
		galleryDAO.galleryWrite(map);
	}

	@Override
	public Map<String, Object> galleryDetail(Map<String, Object> map) {
		return galleryDAO.galleryDetail(map);
	}

	@Override
	public void galleryDelete(Map<String, Object> map) {
		galleryDAO.galleryDelete(map);
	}

	@Override
	public int galleryPicDel(Map<String, Object> map) {
		return galleryDAO.galleryPicDel(map);
	}

	@Override
	public void galleryUpdate1(Map<String, Object> map) {
		galleryDAO.galleryUpdate1(map);
	}

	@Override
	public void galleryLike(Map<String, Object> map) {
		galleryDAO.galleryLike(map);
	}

	@Override
	public int galleryTotalCount(Map<String, Object> map) {
		return galleryDAO.galleryTotalCount(map);

	}

	@Override
	public void galleryCommentInsert(Map<String, Object> map) {
		galleryDAO.galleryCommentInsert(map);
	}

	@Override
	public List<Map<String, Object>> galleryCommentsList(Map<String, Object> map) {
		return galleryDAO.galleryCommentsList(map);
	}

	@Override
	public void galleryCommentDelete(Map<String, Object> map) {
		galleryDAO.galleryCommentDelete(map);
	}

	@Override
	public void galleryCount(Map<String, Object> map) {
		galleryDAO.galleryCount(map);
	}

//	@Override
//	public void galleryCommentInsert2(Map<String, Object> map) {
//		galleryDAO.galleryCommentInsert2(map);
//	}


	
	





}
