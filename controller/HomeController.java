package com.issg2.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.issg2.service.HomeService;
import com.issg2.service.NoticeService;
import com.issg2.util.CommandMap;
import com.issg2.util.Util;

@Controller
public class HomeController {

	//service(Interface), serviceImpl, DAO(extends AbstraceDAO), Mapper
	@Resource(name="homeService")
	private HomeService homeService;

	@GetMapping("/")
	public ModelAndView indexNotice(CommandMap map) {

		int pageNo = 1;
		if(map.containsKey("pageNo")
				|| Util.checkNumber(String.valueOf(map.get("pageNo")))) {
			pageNo = Util.str2Int(String.valueOf(map.get("pageNo")));
		}
		ModelAndView mv = new ModelAndView("index");
		List<Map<String, Object>> list = homeService.indexNoticeList();
		mv.addObject("indexNoticeList",list);
		List<Map<String, Object>> list8 = homeService.indexGalleryList();
		mv.addObject("list8",list8);
		List<Map<String, Object>> week = homeService.indexGallWeekList();
		mv.addObject("week",week);
		List<Map<String, Object>> art = homeService.indexArtList();
		mv.addObject("indexArtList",art);
		mv.addObject("pageNo", pageNo);
		return mv;
	}
	
	
	
		
}
