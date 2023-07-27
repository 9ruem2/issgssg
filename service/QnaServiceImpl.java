package com.issg2.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;


import com.issg2.dao.QnaDAO;

@Service("qnaService")
public class QnaServiceImpl implements QnaService {

	@Resource(name="qnaDAO")
	private QnaDAO qnaDAO;

	@Override
	public List<Map<String, Object>> qnaList(Map<String, Object> map) {
		
		return qnaDAO.qnaList(map);
	}

	@Override
	public Map<String, Object> qnaDetail(Map<String, Object> map) {
		
		return qnaDAO.qnaDetail(map);
	}

	@Override
	public int qnaTotalCount(Map<String, Object> map) {
		
		return  qnaDAO.qnaTotalCount(map); 
	}

	@Override
	public void qnaCommentInsert(Map<String, Object> map) {
		qnaDAO.qnaCommentInsert(map);
		
	}

	@Override
	public List<Map<String, Object>> qnaCommentsList(Map<String, Object> map) {
		
		return qnaDAO.qnaCommentsList(map);
	}

	@Override
	public int qnaWrite(Map<String, Object> map) {
		
		return qnaDAO.qnaWrite(map);
	}

	@Override
	public void qnaUpdate1(Map<String, Object> map) {
	
		qnaDAO.qnaUpdate1(map);
	}

	@Override
	public void qnaDelete(Map<String, Object> map) {
		qnaDAO.qnaDelete(map);
		
	}

	@Override
	public void qnaCount(Map<String, Object> map) {
		qnaDAO.qnaCount(map);
		
	}

	
	 

}
