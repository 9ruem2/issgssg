package com.issg2.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.issg2.service.NoticeService;
import com.issg2.util.CommandMap;
import com.issg2.util.Util;

import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller
public class NoticeController {

	//service(Interface), serviceImpl, DAO(extends AbstraceDAO), Mapper
	@Resource(name="noticeService")
	private NoticeService noticeService;
	
	@GetMapping("/notice")
	public ModelAndView notice(CommandMap map) {
//	System.out.println(map.getMap());//{mb_cate=1, pageNo=1}
		int pageNo = 1;
		if(map.containsKey("pageNo")
				|| Util.checkNumber(String.valueOf(map.get("pageNo")))) {
			pageNo = Util.str2Int(String.valueOf(map.get("pageNo")));
		}
		//전체 글수를 가져와 주세요
		int totalCount = noticeService.totalCount(map.getMap());
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setTotalRecordCount(totalCount);
		paginationInfo.setCurrentPageNo(pageNo);
		paginationInfo.setRecordCountPerPage(10);
		paginationInfo.setPageSize(10);
		//계산
		map.put("startPage", paginationInfo.getFirstRecordIndex());
		map.put("lastPage", paginationInfo.getRecordCountPerPage());
		
		
		ModelAndView mv = new ModelAndView("notice");
		List<Map<String, Object>> list = noticeService.noticeList(map.getMap());
		mv.addObject("noticeList", list);
		mv.addObject("pageNo", pageNo);
		mv.addObject("paginationInfo", paginationInfo);
		
		return mv;
	}
	
	@GetMapping("/noticeDetail")
	public ModelAndView noticeDetail(CommandMap map) {
		ModelAndView mv = new ModelAndView("noticeDetail");
		noticeService.noticeCount(map.getMap());
		Map<String, Object> detail=noticeService.noticeDetail(map.getMap());
		mv.addObject("noticeDetail",detail);
		//System.out.println("hhhh"+detail);
		Map<String, Object> before=noticeService.noticeBefore(map.getMap());
		Map<String, Object> after=noticeService.noticeAfter(map.getMap());
		mv.addObject("before",before);
		mv.addObject("after",after);
		return mv;
	}  
	
	
	
	



}
