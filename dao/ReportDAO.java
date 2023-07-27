package com.issg2.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.issg2.util.AbstractDAO;

@Repository("reportDAO")
public class ReportDAO extends AbstractDAO {
	
	
	
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> reportList() {
		
		return selectList("report.reportList");
	}
	
	

}
  