package com.issg2.service;

import java.util.List;
import java.util.Map;

import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

public interface AdminService {


	
	Map<String, Object> login(Map<String, Object> map);

	List<Map<String, Object>> boardList(Map<String, Object> map);
	
	Map<String, Object> boardDetail(Map<String, Object> map);
	
	

	void boardInsert(Map<String, Object> map);

	List<Map<String, Object>> cateList();
	
	PaginationInfo boardPaginationInfo(Map<String, Object> map);
	
	//int boardTotalCount(Map<String, Object> map);
	


	int memberTotalCount(Map<String, Object> map);

	List<Map<String, Object>> memberList(Map<String, Object> map);

	int commentTotalCount(Map<String, Object> map);

	List<Map<String, Object>> commentList(Map<String, Object> map);

	//int messageTotalCount(Map<String, Object> map);

	List<Map<String, Object>> messageList(Map<String, Object> map);

	PaginationInfo setupBoardPaginationInfo(Map<String, Object> map);

	List<Map<String, Object>> setupBoardList(Map<String, Object> map);

	int setupBoardInsert(Map<String, Object> map);

	PaginationInfo noticePaginationInfo(Map<String, Object> map);

	PaginationInfo messagePaginationInfo(Map<String, Object> map);

	List<Map<String, Object>> noticeList(Map<String, Object> map);

	Map<String, Object> noticeView(Map<String, Object> map);

	void postDel(Map<String, Object> map);

	void noticeInsert(Map<String, Object> map);

	void write(Map<String, Object> map);

	void boardDelete(Map<String, Object> map);

	PaginationInfo qnaPaginationInfo(Map<String, Object> map);

	List<Map<String, Object>> qnaList(Map<String, Object> map);

	void qnaPostDel(Map<String, Object> map);

	Map<String, Object> qnaView(Map<String, Object> map);

	List<Map<String, Object>> qnaCommentList(Map<String, Object> map);

	PaginationInfo qnaCommentPaginationInfo(Map<String, Object> map);

	void qnaCommentPostDel(Map<String, Object> map);

	void memberPostDel(Map<String, Object> map);

	PaginationInfo galleryPaginationInfo(Map<String, Object> map);

	List<Map<String, Object>> galleryList(Map<String, Object> map);

	Map<String, Object> galleryDetail(Map<String, Object> map);

	List<Map<String, Object>> galleryCommentsList(Map<String, Object> map);

	void galleryCommentDelete(Map<String, Object> map);

	void galleryDelete(Map<String, Object> map);



	

	



}
