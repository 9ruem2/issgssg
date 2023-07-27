package com.issg2.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.issg2.dao.ReportDAO;

@Service("reportService")
public class ReportServiceImpl implements ReportService {

	@Resource(name="reportDAO")
	private ReportDAO reportDAO;

	@Override
	public List<Map<String, Object>> reportList() {
		
		return reportDAO.reportList();
	}

	
	
	  

}
