package com.issg2.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.issg2.service.ReportService;
import com.issg2.util.CommandMap;



@Controller
public class ReportController {

	//serviceImpl, service(Inteface), DAO(exdends AbstraceDAO), Mapper
	@Resource(name="reportService")
	private ReportService reportService;
	
	@GetMapping("/report")
	public ModelAndView	artList() {

		ModelAndView mv = new ModelAndView("report");
		List<Map<String, Object>> list = reportService.reportList();
		mv.addObject("reportList", list);

		return mv;
	}
	
	
	 
}
