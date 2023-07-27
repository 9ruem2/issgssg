package com.issg2.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.issg2.util.AbstractDAO;

@Repository("adminDAO")
public class AdminDAO extends AbstractDAO {

	public void write(Map<String, Object> map) {
		insert("admin.write", map);
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> login(Map<String, Object> map) {
		return (Map<String, Object>) selectOne("admin.login", map);
	}

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> boardList(Map<String, Object> map) {
		return selectList("admin.boardList", map);
	}

	public Map<String, Object> boardDetail(Map<String, Object> map) {

		return (Map<String, Object>) selectOne("admin.boardDetail", map);
	}

	public void boardPostDel(Map<String, Object> map) {
		update("admin.boardPostDel", map);
	}

	public void boardInsert(Map<String, Object> map) {
		insert("admin.boardInsert", map);
	}

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> cateList() {
		return selectList("admin.cateList");
	}

	public int boardTotalCount(Map<String, Object> map) {
		return (int) selectOne("admin.boardTotalCount", map);
	}

	public int memberTotalCount(Map<String, Object> map) {
		return (int) selectOne("admin.memberTotalCount", map);
	}

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> memberList(Map<String, Object> map) {
		return selectList("admin.memberList", map);
	}
	
	public void memberPostDel(Map<String, Object> map) {
		
		update("admin.memberPostDel", map);
	}


	public int commentTotalCount(Map<String, Object> map) {
		return (int) selectOne("admin.commentTotalCount", map);
	}

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> commentList(Map<String, Object> map) {
		return selectList("admin.commentList", map);
	}

	public int messageTotalCount(Map<String, Object> map) {
		return (int) selectOne("admin.messageTotalCount", map);
	}

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> messageList(Map<String, Object> map) {
		return selectList("admin.messageList", map);
	}

	public int setupBoardTotalCount(Map<String, Object> map) {
		return (int) selectOne("admin.setupBoardTotalCount", map);
	}

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> setupBoardList(Map<String, Object> map) {
		return selectList("admin.setupBoardList", map);
	}

	public int setupBoardInsert(Map<String, Object> map) {
		return (int) insert("admin.setupBoardInsert", map);
	}

	public int noticeTotalCount(Map<String, Object> map) {
		return (int) selectOne("admin.noticeTotalCount", map);
	}

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> noticeList(Map<String, Object> map) {
		return selectList("admin.noticeList", map);
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> noticeView(Map<String, Object> map) {
		return (Map<String, Object>) selectOne("admin.noticeView", map);
	}

	public void postDel(Map<String, Object> map) {
		update("admin.postDel", map);
	}

	public void noticeInsert(Map<String, Object> map) {
		insert("admin.noticeInsert", map);
	}

	public void boardDelete(Map<String, Object> map) {
		update("admin.boardDelete", map);

	}

	public int qnaTotalCount(Map<String, Object> map) {

		return (int) selectOne("admin.qnaTotalCount", map);
	}

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> qnaList(Map<String, Object> map) {

		return selectList("admin.qnaList", map);
	}

	public void qnaPostDel(Map<String, Object> map) {
		update("admin.qnaPostDel", map);
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> qnaView(Map<String, Object> map) {

		return (Map<String, Object>) selectOne("admin.qnaView", map);
	}

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> qnaCommentList(Map<String, Object> map) {
		return selectList("admin.qnaCommentList", map);

	}

	public int qnaCommentTotalCount(Map<String, Object> map) {

		return (int) selectOne("admin.qnaCommentTotalCount", map);
	}

	public void qnaCommentPostDel(Map<String, Object> map) {
		
		update("admin.qnaCommentPostDel", map);
	}

	public int galleryTotalCount(Map<String, Object> map) {
		return (int) selectOne("admin.galleryTotalCount", map);
	}

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> galleryList(Map<String, Object> map) {
		return selectList("admin.galleryList", map);
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> galleryDetail(Map<String, Object> map) {
		return (Map<String, Object>) selectOne("admin.galleryDetail", map);
	}

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> galleryCommentsList(Map<String, Object> map) {
		return selectList("admin.galleryCommentsList", map);
	}

	public void galleryCommentDelete(Map<String, Object> map) {
		update("admin.galleryCommentDelete", map);
	}

	public void galleryDelete(Map<String, Object> map) {
		update("admin.galleryDelete", map);
	}

	
}
