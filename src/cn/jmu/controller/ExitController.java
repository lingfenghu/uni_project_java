package cn.jmu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExitController {
	@RequestMapping(value="manageFlight/exit.do")
	public void manage_exit(HttpSession session,HttpServletResponse response) throws Exception {
		session.invalidate();
		response.sendRedirect("../index.jsp");
	}
	@RequestMapping(value="user/exit.do")
	public void user_exit(HttpSession session,HttpServletResponse response) throws Exception {
		session.invalidate();
		response.sendRedirect("../index.jsp");
	}
	@RequestMapping(value="exit.do")
	public void exit(HttpSession session,HttpServletResponse response) throws Exception {
		session.invalidate();
		response.sendRedirect("index.jsp");
	}
	@RequestMapping(value="user/exit2.do")
	public void user_exi2t(HttpSession session,HttpServletResponse response) throws Exception {
		response.sendRedirect("../index.jsp");
	}
	@RequestMapping(value="manageFlight/exit2.do")
	public void manage_exi2t(HttpSession session,HttpServletResponse response) throws Exception {
		response.sendRedirect("../index.jsp");
	}
	@RequestMapping(value="exit2.do")
	public void exi2t(HttpSession session,HttpServletResponse response) throws Exception {
		response.sendRedirect("index.jsp");
	}
}
