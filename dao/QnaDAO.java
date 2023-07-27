package com.issg2.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.issg2.util.AbstractDAO;

@Repository("qnaDAO")
public class QnaDAO extends AbstractDAO {

	public List<Map<String, Object>> qnaList(Map<String, Object> map) {
		
		return selectList("qna.qnaList",map);
	}

	public Map<String, Object> qnaDetail(Map<String, Object> map) {
		
		return (Map<String, Object>) selectOne("qna.qnaDetail", map);
	}

	public int qnaTotalCount(Map<String, Object> map) {
		
		return (int) selectOne("qna.qnaTotalCount", map);
	}

	public void qnaCommentInsert(Map<String, Object> map) {
		insert("qna.qnaCommentInsert", map);
		
	}

	public List<Map<String, Object>> qnaCommentsList(Map<String, Object> map) {
		
		return selectList("qna.qnaCommentsList", map);
	}

	public int qnaWrite(Map<String, Object> map) {
		
		return (int) insert("qna.qnaWrite", map);
	}

	public void qnaUpdate1(Map<String, Object> map) {
		update("qna.qnaUpdate1",map);
		
	}

	public void qnaDelete(Map<String, Object> map) {
		update("qna.qnaDelete", map);
		
	}

	public void qnaCount(Map<String, Object> map) {
		update("qna.qnaCount", map);
		
	}

	/*public List<Map<String, Object>> qnaCommentList(Map<String, Object> map) {
		return selectList("qna.qnaCommentList",map);
	}*/  

	

}
