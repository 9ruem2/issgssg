package com.issg2.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.issg2.service.QnaService;
import com.issg2.util.CommandMap;
import com.issg2.util.Util;

import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller
public class QnaController {

	//serviceImpl, service(Inteface), DAO(exdends AbstraceDAO), Mapper
	@Resource(name="qnaService")
	private QnaService qnaService;
	
	
	//qna
	

		 
		 
		@GetMapping("/qna")
		public ModelAndView	qnaList(CommandMap map) {
			
			int pageNo = 1;
			if(map.containsKey("pageNo")
					|| Util.checkNumber(String.valueOf(map.get("pageNo")))) {
				pageNo = Util.str2Int(String.valueOf(map.get("pageNo")));
			}
			//전체 글수를 가져와 주세요
			int qnaTotalCount = qnaService.qnaTotalCount(map.getMap());
			PaginationInfo paginationInfo = new PaginationInfo();
			paginationInfo.setTotalRecordCount(qnaTotalCount);
			paginationInfo.setCurrentPageNo(pageNo);
			paginationInfo.setRecordCountPerPage(10);
			paginationInfo.setPageSize(10);
			//계산
			map.put("startPage", paginationInfo.getFirstRecordIndex());
			map.put("lastPage", paginationInfo.getRecordCountPerPage());
			ModelAndView mv = new ModelAndView("qna");
			
			
			List<Map<String, Object>> list = qnaService.qnaList(map.getMap());
			mv.addObject("qnaList", list);
			mv.addObject("pageNo", pageNo);
			mv.addObject("paginationInfo", paginationInfo);
			return mv;
		} 
		
		//qnaDetail
			@GetMapping("/qnaDetail")
			public ModelAndView qnaDetail(CommandMap map) {
				ModelAndView mv = new ModelAndView("qnaDetail");
				qnaService.qnaCount(map.getMap());
				Map<String, Object> qnaDetail = qnaService.qnaDetail(map.getMap());
				qnaDetail.put("pageNo", map.get("pageNo"));
				//댓글도 출력하기
				if (Util.str2Int(qnaDetail.get("qnaCommentCount")) > 0) {
				   //System.out.println("댓글이 있어요. " + qnaDetail.get("qnaCommentCount"));
					List<Map<String, Object>> qnaComments = qnaService.qnaCommentsList(map.getMap());			
					//System.out.println(qnaComments);
					List<Map<String, Object>> comments = new ArrayList<Map<String, Object>>();
					mv.addObject("qnaComments", qnaComments);
					//System.out.println("comments"+comments);
					mv.addObject("comments", comments);
				}
				
				mv.addObject("pageNo", map.get("pageNo"));
				mv.addObject("qnaDetail", qnaDetail);
				return mv;
			}
			
			//qnaCommentInsert
			@PostMapping("/qnaCommentInsert")
			public String qnaCommentInsert(CommandMap map, HttpSession session) {
				System.out.println("commentInsert : "+map.getMap());
				if(session.getAttribute("id") != null) {
					map.put("id", session.getAttribute("id"));
					//저장하기
					//엔터키 처리
					map.put("qcComment", Util.removeSC((String)map.get("qcComment")));
					map.put("qcComment", Util.addBR((String)map.get("qcComment")));
					qnaService.qnaCommentInsert(map.getMap());
					
					String url = "redirect:/qnaDetail?q_no="+map.get("q_no")+"&pageNo="+map.get("pageNo");
					return url;
				}else {
					return "redirect:/login";
				}

			}
	
			
	
		
			@GetMapping("/qnaWrite")
			public String galleryWrite(HttpSession session) {
				if (session.getAttribute("id") != null) {
					return "qnaWrite";
				} else {
					return "redirect:/login";
				}
			}
			
			
			@PostMapping("/qnaWrite")
			public String write(CommandMap map, 
							HttpServletRequest request, HttpSession session) {
				
				if(session.getAttribute("id") != null) {			
					map.put("id", session.getAttribute("id"));
					
					int result = qnaService.qnaWrite(map.getMap());
					
					return "redirect:/qna";
					
				}else {
					return "redirect:/login";
				}
			}
			
			
			//update.do 페이지에 해당 내용을 찍어주기
			@GetMapping("/qnaUpdate")
			public ModelAndView qnaUpdate(CommandMap map, HttpSession session) {
				//System.out.println(map.getMap());//{mb_no=29}
				ModelAndView mv = new ModelAndView("redirect:/error");
				//세션 저장
				if(session.getAttribute("id") != null) {
					map.put("id", session.getAttribute("id"));
					Map<String, Object> qnaUpdate = qnaService.qnaDetail(map.getMap());
					//String content = (String) detail.get("mb_content");
					//detail.put("mb_content", content.replaceAll("<br>", "\n"));
					mv.setViewName("qnaUpdate");
					mv.addObject("qnaUpdate", qnaUpdate);
	
				}
				//service에게 일 시키기
				return mv;
			}
			//수정내역을 저장하기
			
			@PostMapping("/qnaUpdate")
			public String qnaUpdate1(CommandMap map, HttpSession session, HttpServletRequest request ) throws Exception{
				//System.out.println(map.getMap());//{mb_no=27, title=<br>엔터처리, content=<br>
				if(session.getAttribute("id") != null
						&& request.getParameter("title") != null 
						&& request.getParameter("content") != null) {
					
					map.put("title", request.getParameter("title"));
					map.put("content", request.getParameter("content"));
					map.put("id", session.getAttribute("id"));
					qnaService.qnaUpdate1(map.getMap());
					return "redirect:/qnaDetail?q_no="+map.get("q_no")+"&pageNo="+map.get("pageNo");
				}else {
					return "redirect:/login";
				}
				
			}
			
			
			
			@GetMapping("/qnaDelete")
			public String qnaDelete(CommandMap map, HttpSession session) {
				if(session.getAttribute("id") != null) {
					map.put("id", session.getAttribute("id"));
					qnaService.qnaDelete(map.getMap());
					return "redirect:/qna";
				}else {
					return "redirect/login";
				}
			}
	
}
