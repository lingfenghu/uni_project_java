package cn.jmu.controller;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.jmu.po.ExFlight;
import cn.jmu.po.ExFlightProduct;
import cn.jmu.po.Flight;
import cn.jmu.service.ExFlightService;

@Controller
public class ExFlightController {
	@Resource(name="exFlightServiceImpl")
	private ExFlightService exFlightService;
	
	@RequestMapping(value="/manageFlight/allExFlight.do")
	public String manage_getAllExFlight(HttpSession session,HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<ExFlight> allExFlight = null;
		allExFlight = exFlightService.getAllExFlight();
		request.setAttribute("allExFlight", allExFlight);
		if(session.getAttribute("allExFlight")!=null) {
			session.removeAttribute("allExFlight");
		}
		return "manageFlight/manageExFlight";
	}
	@RequestMapping(value="/manageFlight/exFlight.do")
	public String manage_getExFlightByFlightIDAndexFlightDate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ExFlight exFlight = null;
		String flightID = request.getParameter("flightID");
		String exFlightDate = request.getParameter("exFlightDate");
		exFlight = exFlightService.getExFlightAndFlightStateAndFlightByDateaAndFlightID(flightID, exFlightDate);
		if(exFlight==null) {
			request.setAttribute("flag", "no");
			return "manageFlight/manageExFlight";
		}
		request.setAttribute("exFlight", exFlight);
		return "manageFlight/manageExFlightUpdate";
	}
	@RequestMapping(value="/manageFlight/exFlightUpdate.do")
	public String manage_updateExFlight(HttpSession session,HttpServletRequest request, HttpServletResponse response) throws Exception {
		SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd");
		ExFlight exFlight = null;
		String flightID = request.getParameter("flightID");
		Date exFlightDate = new java.sql.Date(format.parse(request.getParameter("exFlightDate")).getTime());
		int flightStateID =  Integer.parseInt(request.getParameter("flightStateID"));
		int foodTypeID = Integer.parseInt(request.getParameter("foodTypeID"));
		String totalTime = request.getParameter("totalTime");
		
		format = new SimpleDateFormat("HH:mm:ss");
		Time departTime  = new java.sql.Time(format.parse(request.getParameter("departTime")).getTime());
		Time arriveTime = new java.sql.Time(format.parse(request.getParameter("arriveTime")).getTime());
		boolean onRevise = Boolean.parseBoolean(request.getParameter("onRevise"));
		boolean onRefund =  Boolean.parseBoolean(request.getParameter("onRefund"));
		exFlight = new ExFlight( flightID, exFlightDate,flightStateID,foodTypeID,totalTime, departTime,arriveTime,onRevise,onRefund);
		this.exFlightService.updateExFlight(exFlight);
		request.setAttribute("update", "ok");
		if(session.getAttribute("allExFlight")!=null) {
			session.removeAttribute("allExFlight");
		}
		return "manageFlight/manageExFlight";
	}	
	
	@RequestMapping(value="index_allExFlight3.do")
	public String index_getAllExFlightByFlightIDAndDate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String exFlightDate =  request.getParameter("exFlightDate");
		String flightID = request.getParameter("flightID");
		ExFlight ExFlight = null;
		ExFlight = exFlightService.getExFlightAndFlightStateAndFlightByDateaAndFlightID(flightID, exFlightDate);
		request.setAttribute("ExFlight", ExFlight);
		request.setAttribute("exFlightDate", exFlightDate);
		return "index_QueryFlightState2";
	}
	@RequestMapping(value="index_allExFlight2.do")
	public String index_getAllExFlightByCityAndDate(HttpSession session,HttpServletRequest request, HttpServletResponse response) throws Exception {
		String exFlightDate =  request.getParameter("exFlightDate");
		String departCity = request.getParameter("departCity");
		String arriveCity = request.getParameter("arriveCity");
		
		List<ExFlight> allExFlight = null;
		allExFlight = exFlightService.getAllExFlightAndFligtStateAndFlightByCityAndDate(exFlightDate, departCity, arriveCity);
		request.setAttribute("allExFlight", allExFlight);
		request.setAttribute("exFlightDate", exFlightDate);
		request.setAttribute("departCity", departCity);
		request.setAttribute("arriveCity", arriveCity);
		if(session.getAttribute("allExFlight")!=null) {
			session.removeAttribute("allExFlight");
		}
		return "index_QueryFlightState";
	}
	@RequestMapping(value="index_allExFlight.do")
	public String index_getAllExFlightAndExFlightProductByCityAndDate(HttpSession session,HttpServletRequest request, HttpServletResponse response) throws Exception {
		String exFlightDate =  request.getParameter("exFlightDate");
		String departCity = request.getParameter("departCity");
		String arriveCity = request.getParameter("arriveCity");
		
		List<ExFlight> allExFlightAndProduct = null;
		allExFlightAndProduct = exFlightService.getAllExFlightAndFlightProductByCityAndDate(exFlightDate, departCity, arriveCity);
		request.setAttribute("allExFlightAndProduct", allExFlightAndProduct);
		request.setAttribute("exFlightDate", exFlightDate);
		request.setAttribute("departCity", departCity);
		request.setAttribute("arriveCity", arriveCity);
		if(session.getAttribute("allExFlightAndProduct")!=null) {
			session.removeAttribute("allExFlightAndProduct");
		}
		return "index_QueryFlightOrder";
	}
	@RequestMapping(value="user/allExFlight.do")
	public String user_getAllExFlightAndExFlightProductByCityAndDate(HttpSession session,HttpServletRequest request, HttpServletResponse response) throws Exception {
		String exFlightDate =  request.getParameter("exFlightDate");
		String departCity = request.getParameter("departCity");
		String arriveCity = request.getParameter("arriveCity");
		List<ExFlight> allExFlightAndProduct = null;
		allExFlightAndProduct = exFlightService.getAllExFlightAndFlightProductByCityAndDate(exFlightDate, departCity, arriveCity);
		if(session.getAttribute("allExFlightAndProduct")!=null) {
			session.removeAttribute("allExFlightAndProduct");
		}
		if(session.getAttribute("passengerList")!=null) {
			session.removeAttribute("passengerList");
		}
		request.setAttribute("allExFlightAndProduct", allExFlightAndProduct);
		request.setAttribute("exFlightDate", exFlightDate);
		request.setAttribute("departCity", departCity);
		request.setAttribute("arriveCity", arriveCity);
		return "user/user_QueryFlightOrder";
	}
	@RequestMapping(value="user/allExFlight2.do")
	public String user_getAllExFlightByCityAndDate(HttpSession session,HttpServletRequest request, HttpServletResponse response) throws Exception {
		String exFlightDate =  request.getParameter("exFlightDate");
		String departCity = request.getParameter("departCity");
		String arriveCity = request.getParameter("arriveCity");
		
		List<ExFlight> allExFlight = null;
		allExFlight = exFlightService.getAllExFlightAndFligtStateAndFlightByCityAndDate(exFlightDate, departCity, arriveCity);
		request.setAttribute("allExFlight", allExFlight);
		request.setAttribute("exFlightDate", exFlightDate);
		request.setAttribute("departCity", departCity);
		request.setAttribute("arriveCity", arriveCity);
		if(session.getAttribute("allExFlight")!=null) {
			session.removeAttribute("allExFlight");
		}
		return "user/user_QueryFlightState";
	}
	@RequestMapping(value="user/allExFlight3.do")
	public String user_getAllExFlightByFlightIDAndDate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String exFlightDate =  request.getParameter("exFlightDate");
		String flightID = request.getParameter("flightID");
		ExFlight ExFlight = null;
		ExFlight = exFlightService.getExFlightAndFlightStateAndFlightByDateaAndFlightID(flightID, exFlightDate);
		request.setAttribute("ExFlight", ExFlight);
		request.setAttribute("exFlightDate", exFlightDate);
		return "user/user_QueryFlightState2";
	}
}
