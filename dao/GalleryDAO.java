package com.issg2.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.issg2.util.AbstractDAO;

@Repository("galleryDAO")
public class GalleryDAO extends AbstractDAO {

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> galleryList(Map<String, Object> map) {
		return selectList("gallery.galleryList", map);
	}

	public void galleryWrite(Map<String, Object> map) {
		insert("gallery.galleryWrite", map);
		
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> galleryDetail(Map<String, Object> map) {
		return (Map<String, Object>) selectOne("gallery.galleryDetail", map);
	}

	public void galleryDelete(Map<String, Object> map) {
		update("gallery.galleryDelete", map);
	}

	public int galleryPicDel(Map<String, Object> map) {
		return (int) update("gallery.galleryPicDel", map);
	}

	public void galleryUpdate1(Map<String, Object> map) {
		update("gallery.galleryUpdate1", map);
	}

	public void galleryLike(Map<String, Object> map) {
		update("gallery.galleryLike", map);
	}

	public int galleryTotalCount(Map<String, Object> map) {
		return (int) selectOne("gallery.galleryTotalCount", map);
	}

	public void galleryCommentInsert(Map<String, Object> map) {
		insert("gallery.galleryCommentInsert", map);
	}

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> galleryCommentsList(Map<String, Object> map) {
		return selectList("gallery.galleryCommentsList", map);
	}

	public void galleryCommentDelete(Map<String, Object> map) {
		update("gallery.galleryCommentDelete", map);
	}

	public void galleryCount(Map<String, Object> map) {
		update("gallery.galleryCount", map);
	}

//	public void galleryCommentInsert2(Map<String, Object> map) {
//		insert("gallery.galleryCommentInsert2", map);
//	}






	

}
