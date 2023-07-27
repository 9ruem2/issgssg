package com.issg2.service;

import java.util.List;
import java.util.Map;

public interface QnaService {

	List<Map<String, Object>> qnaList(Map<String, Object> map);

	Map<String, Object> qnaDetail(Map<String, Object> map);

	int qnaTotalCount(Map<String, Object> map);

	void qnaCommentInsert(Map<String, Object> map);

	List<Map<String, Object>> qnaCommentsList(Map<String, Object> map);

	int qnaWrite(Map<String, Object> map);

	void qnaUpdate1(Map<String, Object> map);

	void qnaDelete(Map<String, Object> map);

	void qnaCount(Map<String, Object> map);

	//List<Map<String, Object>> qnaCommentList(Map<String, Object> map);
	
	
	
	
} 