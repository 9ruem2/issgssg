package com.issg2.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.issg2.service.BoardService;
import com.issg2.util.CommandMap;
import com.issg2.util.Util;

import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller
public class BoardController {

	//serviceImpl, service(Inteface), DAO(exdends AbstraceDAO), Mapper
	@Resource(name="boardService")
	private BoardService boardService;
	
	@Autowired
	private ServletContext context;
	
	  
	 
	
	//art
	@GetMapping("/art")
	public ModelAndView	artList(CommandMap map) {
		
		
		int pageNo = 1;
		if(map.containsKey("pageNo")
				|| Util.checkNumber(String.valueOf(map.get("pageNo")))) {
			pageNo = Util.str2Int(String.valueOf(map.get("pageNo")));
		}
		//전체 글수를 가져와 주세요
		int artTotalCount = boardService.artTotalCount(map.getMap());
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setTotalRecordCount(artTotalCount);
		paginationInfo.setCurrentPageNo(pageNo);
		paginationInfo.setRecordCountPerPage(8);
		paginationInfo.setPageSize(10);
		//계산
		map.put("startPage", paginationInfo.getFirstRecordIndex());
		map.put("lastPage", paginationInfo.getRecordCountPerPage());
		
		
		ModelAndView mv = new ModelAndView("art");
		
		List<Map<String, Object>> list = boardService.artList(map.getMap());
		mv.addObject("artList", list);
		mv.addObject("pageNo", pageNo);
		mv.addObject("paginationInfo", paginationInfo);
		
		return mv;
	}
	
	//artDetail
		@GetMapping("/artDetail")
		public ModelAndView artDetail(CommandMap map) {
			ModelAndView mv = new ModelAndView("artDetail");
			boardService.artCount(map.getMap());
			System.out.println(map.getMap());
			Map<String, Object> detail = boardService.artDetail(map.getMap());
			mv.addObject("artDetail", detail);
			System.out.println(detail);
			
			return mv;
		}
		
		//좋아요 - 수정필요 : 한 글에 한 번만 누를 수 있도록 테이블을 만들어야 함.
		@GetMapping("/artLike")
		public String artLike(CommandMap map) {
			//System.out.println("/galleryLike"+map.getMap());
			boardService.artLike(map.getMap());
			String url = "redirect:/artDetail?b_no="+map.get("b_no")+"&pageNo="+map.get("pageNo");
			return url;
		}
		
		@GetMapping("/shop")
		public String shop() {
			return "./shop";
		}
		
		
	
	
			
			
			
	
	
	

	
	
}
