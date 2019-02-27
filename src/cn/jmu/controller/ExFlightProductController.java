package cn.jmu.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.jmu.po.ExFlightProduct;
import cn.jmu.service.ExFlightProductService;
import cn.jmu.service.FlightProductService;

@Controller
public class ExFlightProductController {
	@Resource(name="exFlightProductServiceImpl")
	private ExFlightProductService exFlightProductService;
	
	@RequestMapping(value="/manageFlight/allExFlightProduct.do")
	public String getAllExFlightProduct(HttpSession session,HttpServletRequest request, HttpServletResponse response) throws Exception{
		List<ExFlightProduct> allExFlightProduct = null;
		allExFlightProduct = exFlightProductService.getAllExFlightProduct();
		request.setAttribute("allExFlightProduct",allExFlightProduct);
		if(session.getAttribute("allExFlightProduct")!=null) {
			session.removeAttribute("allExFlightProduct");
		}
		return "manageFlight/manageExFlightProduct";
	}
	
	@RequestMapping(value="/manageFlight/getExFlightProduct.do")
	public String getExFlightProductByPK(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		String flightID = request.getParameter("flightID");
		String exFlightDate = request.getParameter("exFlightDate");
		String flightProductID = request.getParameter("flightProductID");
		ExFlightProduct exFlightProduct = exFlightProductService.getExFlightProductByPK(flightID, exFlightDate, flightProductID);
		model.addAttribute("exFlightProduct", exFlightProduct);
		return "manageFlight/exFlightProductUpdate";
	}
	
	@RequestMapping(value="/manageFlight/exFlightProductUpdate.do")
	public String updateExFlightProduct(HttpSession session,HttpServletRequest request, HttpServletResponse response) throws Exception {
		String flightID = request.getParameter("flightID");		
		SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd");
		Date exFlightDate = new java.sql.Date(format.parse(request.getParameter("exFlightDate")).getTime());
		String flightProductID = request.getParameter("flightProductID");
		int price = Integer.parseInt(request.getParameter("price"));
		int pointPrice = Integer.parseInt(request.getParameter("pointPrice"));
		int leftTicketNum = Integer.parseInt(request.getParameter("leftTicketNum"));
		boolean onSale = false;
		if(request.getParameter("onSale").equals("ÊÇ")) {
			onSale = true;
		}
		ExFlightProduct exFlightProduct = new ExFlightProduct(flightID,exFlightDate,flightProductID,price,pointPrice,leftTicketNum,onSale);
		exFlightProductService.updateExFlightProduct(exFlightProduct);
		request.setAttribute("update", "ok");
		if(session.getAttribute("allExFlightProduct")!=null) {
			session.removeAttribute("allExFlightProduct");
		}
		return "manageFlight/manageExFlightProduct";
	}
}
