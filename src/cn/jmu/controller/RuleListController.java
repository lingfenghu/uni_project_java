package cn.jmu.controller;


import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.jmu.po.RuleList;
import cn.jmu.service.RuleListService;

@Controller
public class RuleListController {
	@Resource(name="ruleListServiceImpl")
	private RuleListService ruleListService;
	
	@RequestMapping(value="/manageFlight/updateRule.do")
	public void updateRule(HttpServletRequest request, HttpServletResponse response ,Model model) throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = new java.util.Date(System.currentTimeMillis());
		java.sql.Date reviseDate = new java.sql.Date(sdf.parse(sdf.format(date)).getTime());
		String content = request.getParameter("content");
		RuleList rule = new RuleList(1,content,reviseDate);
		ruleListService.updateRule(rule);
		request.getRequestDispatcher("outputRule.do").forward(request, response);
	}
	@RequestMapping(value="/manageFlight/outputRule.do")
	public String outputRule(HttpServletRequest request, HttpServletResponse response ,Model model) throws Exception{
		RuleList rule = ruleListService.getRule();
		model.addAttribute("rule",rule);
		return "manageFlight/manageRules";
	}
	@RequestMapping(value="/user/outputRule.do")
	public String user_outputRule(HttpServletRequest request, HttpServletResponse response ,Model model) throws Exception{
		RuleList rule = ruleListService.getRule();
		model.addAttribute("rule",rule);
		return "user/rules";
	}
	@RequestMapping(value="outputRule.do")
	public String index_outputRule(HttpServletRequest request, HttpServletResponse response ,Model model) throws Exception{
		RuleList rule = ruleListService.getRule();
		model.addAttribute("rule",rule);
		return "rules";
	}
}
