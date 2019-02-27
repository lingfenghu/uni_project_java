package cn.jmu.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.jmu.po.Statement;
import cn.jmu.service.StatementService;

@Controller
public class MonthReportController {
	@Resource(name="statementServiceImpl")
	private StatementService statementService;
	
	@RequestMapping(value="manageFlight/getMonthReport.do")
	public String getMonthReport(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String flightID = request.getParameter("flightID");
		Statement statement= this.statementService.getAStatement(year, month, flightID);
		request.setAttribute("statement", statement);
		return "manageFlight/monthReport";
	}
}
