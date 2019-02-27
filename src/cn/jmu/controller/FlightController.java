package cn.jmu.controller;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.jmu.po.Flight;
import cn.jmu.service.FlightService;

@Controller
public class FlightController {
	@Resource(name="flightServiceImpl")
	private FlightService flightService;
	
	@RequestMapping(value="/manageFlight/flight.do")
	public String getFlightByID(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String ID = request.getParameter("flightID");
		Flight flight = null;
		flight = flightService.getFlightByID(ID);
		if(flight==null) {
			request.setAttribute("flag", "no");
			return "manageFlight/manageFlight";
		}
		request.setAttribute("flight", flight);
		return "manageFlight/manageFlightUpdate";
	}
	@RequestMapping(value="/manageFlight/allFlight.do")
	public String getAllFlight(HttpSession session,HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Flight> allFlight = null;
		allFlight = flightService.getAllFlight();
		request.setAttribute("allFlight", allFlight);
		if(session.getAttribute("allFlight")!=null) {
			session.removeAttribute("allFlight");
		}
		return "manageFlight/manageFlight";
	}
	
	@RequestMapping(value="/manageFlight/flightUpdate.do")
	public void updateFlight(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String flightID = request.getParameter("flightID");
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
		java.util.Date date = new java.util.Date();  
		date = format.parse(request.getParameter("preDepartTime"));  
		Time preDepartTime = new java.sql.Time(date.getTime());
		String preTotalTime = request.getParameter("preTotalTime");
		String flightType = request.getParameter("flightType");
		int totalSeatNum = Integer.parseInt(request.getParameter("totalSeatNum"));
		String departCity = request.getParameter("departCity");
		String arriveCity = request.getParameter("arriveCity");
		int insurancePrice = Integer.parseInt(request.getParameter("insurancePrice"));	
		Flight flight = new  Flight(flightID,preDepartTime,preTotalTime,flightType,totalSeatNum,departCity,arriveCity,insurancePrice);		
		this.flightService.updateFlight(flight);
		response.sendRedirect("manageFlight.jsp?update=ok");
	}
	@RequestMapping(value="/manageFlight/addFlight.do")
	public String addFlight(HttpSession session,HttpServletRequest request, HttpServletResponse response) throws Exception{
		String flightID = request.getParameter("flightID");
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
		java.util.Date date = new java.util.Date();  
		date = format.parse(request.getParameter("preDepartTime"));  
		Time preDepartTime = new java.sql.Time(date.getTime());
		String preTotalTime = request.getParameter("preTotalTime");
		String flightType = request.getParameter("flightType");
		int totalSeatNum = Integer.parseInt(request.getParameter("totalSeatNum"));
		String departCity = request.getParameter("departCity");
		String arriveCity = request.getParameter("arriveCity");
		int insurancePrice = Integer.parseInt(request.getParameter("insurancePrice"));	
		Flight flight = new  Flight(flightID,preDepartTime,preTotalTime,flightType,totalSeatNum,departCity,arriveCity,insurancePrice);
		List<Flight> allFlight = null;
		allFlight = flightService.getAllFlight();
		for(Flight f:allFlight)
			if(f.getFlightID().equals(flight.getFlightID())) {
				request.setAttribute("insert", "no");
				return "manageFlight/manageFlight";
			}
		flightService.addFlight(flight);
		allFlight = flightService.getAllFlight();
		if(session.getAttribute("allFlight")!=null) {
			session.removeAttribute("allFlight");
		}
		request.setAttribute("allFlight", allFlight);
		return "manageFlight/manageFlight";
	}
}