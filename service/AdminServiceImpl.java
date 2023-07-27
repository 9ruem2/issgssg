package com.issg2.service;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.issg2.dao.AdminDAO;
import com.issg2.util.Util;

import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;


@Service("adminService")
public class AdminServiceImpl implements AdminService {


	@Resource(name="adminDAO")
	private AdminDAO adminDAO;

	@Override
	public Map<String, Object> login(Map<String, Object> map) {
		return adminDAO.login(map);
	}

	@Override
	public List<Map<String, Object>> boardList(Map<String, Object> map) {
		return adminDAO.boardList(map);
	}
	

	@Override
	public void boardDelete(Map<String, Object> map) {
		adminDAO.boardDelete(map);
		
	}

	@Override
	public List<Map<String, Object>> cateList() {
		return adminDAO.cateList();
	}
	
	@Override
	public PaginationInfo boardPaginationInfo(Map<String, Object> map) {
		int totalCount = adminDAO.boardTotalCount(map);
		
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setTotalRecordCount(totalCount);
		paginationInfo.setCurrentPageNo(Util.str2Int(map.get("pageNo")));
		paginationInfo.setRecordCountPerPage(10);               
		paginationInfo.setPageSize(10);
		
		return paginationInfo;
	}

	@Override
	public int memberTotalCount(Map<String, Object> map) {
		return adminDAO.memberTotalCount(map);
	}

	@Override
	public List<Map<String, Object>> memberList(Map<String, Object> map) {
		return adminDAO.memberList(map);
	}
	

	@Override
	public void memberPostDel(Map<String, Object> map) {
		adminDAO.memberPostDel(map);
		
	}


	@Override
	public int commentTotalCount(Map<String, Object> map) {
		return adminDAO.commentTotalCount(map);
	}

	@Override
	public List<Map<String, Object>> commentList(Map<String, Object> map) {
		return adminDAO.commentList(map);
	}

	@Override
	public List<Map<String, Object>> messageList(Map<String, Object> map) {
		return adminDAO.messageList(map);
	}

	@Override
	public PaginationInfo setupBoardPaginationInfo(Map<String, Object> map) {
		int totalCount = adminDAO.setupBoardTotalCount(map);
		
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setTotalRecordCount(totalCount);
		paginationInfo.setCurrentPageNo(Util.str2Int(map.get("pageNo")));
		paginationInfo.setRecordCountPerPage(10);
		paginationInfo.setPageSize(10);
		
		return paginationInfo;
	}

	@Override
	public List<Map<String, Object>> setupBoardList(Map<String, Object> map) {
		return adminDAO.setupBoardList(map);
	}

	@Override
	public int setupBoardInsert(Map<String, Object> map) {
		return adminDAO.setupBoardInsert(map);
	}

	@Override
	public PaginationInfo noticePaginationInfo(Map<String, Object> map) {
		int totalCount = adminDAO.noticeTotalCount(map);
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setTotalRecordCount(totalCount);
		paginationInfo.setCurrentPageNo(Util.str2Int(map.get("pageNo")));
		paginationInfo.setRecordCountPerPage(10);
		paginationInfo.setPageSize(10);
		return paginationInfo;
	}

	@Override
	public PaginationInfo messagePaginationInfo(Map<String, Object> map) {
		int totalCount = adminDAO.messageTotalCount(map);
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setTotalRecordCount(totalCount);
		paginationInfo.setCurrentPageNo(Util.str2Int(map.get("pageNo")));
		paginationInfo.setRecordCountPerPage(10);
		paginationInfo.setPageSize(10);
		return paginationInfo;
	}

	@Override
	public List<Map<String, Object>> noticeList(Map<String, Object> map) {
		return adminDAO.noticeList(map);
	}

	@Override
	public Map<String, Object> noticeView(Map<String, Object> map) {
		return adminDAO.noticeView(map);
	}
	

	@Override
	public void boardInsert(Map<String, Object> map) {
		adminDAO.boardInsert(map);
	}
	
	@Override
	public Map<String, Object> boardDetail(Map<String, Object> map) {
		
		return adminDAO.boardDetail(map);
	}
	
	@Override
	public void postDel(Map<String, Object> map) {
		adminDAO.postDel(map);
	}

	@Override
	public void noticeInsert(Map<String, Object> map) {
		adminDAO.noticeInsert(map);
	}

	@Override
	public void write(Map<String, Object> map) {
		
		adminDAO.write(map);
	}

	@Override
	public PaginationInfo qnaPaginationInfo(Map<String, Object> map) {
		int totalCount = adminDAO.qnaTotalCount(map);
		
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setTotalRecordCount(totalCount);
		paginationInfo.setCurrentPageNo(Util.str2Int(map.get("pageNo")));
		paginationInfo.setRecordCountPerPage(10);
		paginationInfo.setPageSize(10);
		
		return paginationInfo;
	}

	@Override
	public List<Map<String, Object>> qnaList(Map<String, Object> map) {
		
		return adminDAO.qnaList(map);
	}

	@Override
	public void qnaPostDel(Map<String, Object> map) {
		
		adminDAO.qnaPostDel(map);
	}

	@Override
	public Map<String, Object> qnaView(Map<String, Object> map) {
		
		return adminDAO.qnaView(map);
	}

	@Override
	public List<Map<String, Object>> qnaCommentList(Map<String, Object> map) {
		return adminDAO.qnaCommentList(map);
	}
	
	@Override
	public PaginationInfo qnaCommentPaginationInfo(Map<String, Object> map) {
		int totalCount = adminDAO.qnaCommentTotalCount(map);
		
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setTotalRecordCount(totalCount);
		paginationInfo.setCurrentPageNo(Util.str2Int(map.get("pageNo")));
		paginationInfo.setRecordCountPerPage(10);
		paginationInfo.setPageSize(10);
		
		return paginationInfo;
	}

	@Override
	public void qnaCommentPostDel(Map<String, Object> map) {
		
		adminDAO.qnaCommentPostDel(map);
	}

	@Override
	public PaginationInfo galleryPaginationInfo(Map<String, Object> map) {
		int totalCount = adminDAO.galleryTotalCount(map);
		
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setTotalRecordCount(totalCount);
		paginationInfo.setCurrentPageNo(Util.str2Int(map.get("pageNo")));
		paginationInfo.setRecordCountPerPage(10);               
		paginationInfo.setPageSize(10);
		
		return paginationInfo;
	}

	@Override
	public List<Map<String, Object>> galleryList(Map<String, Object> map) {
		return adminDAO.galleryList(map);
	}

	@Override
	public Map<String, Object> galleryDetail(Map<String, Object> map) {
		return adminDAO.galleryDetail(map);
	}

	@Override
	public List<Map<String, Object>> galleryCommentsList(Map<String, Object> map) {
		return adminDAO.galleryCommentsList(map);
	}

	@Override
	public void galleryCommentDelete(Map<String, Object> map) {
		adminDAO.galleryCommentDelete(map);	
	}

	@Override
	public void galleryDelete(Map<String, Object> map) {
		adminDAO.galleryDelete(map);
	}


	





	


}
