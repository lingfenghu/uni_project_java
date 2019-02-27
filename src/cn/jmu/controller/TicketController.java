package cn.jmu.controller;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.jmu.po.ExFlight;
import cn.jmu.po.OrderList;
import cn.jmu.po.Passenger;
import cn.jmu.po.Ticket;
import cn.jmu.po.User;
import cn.jmu.service.ExFlightProductService;
import cn.jmu.service.ExFlightService;
import cn.jmu.service.FlightProductService;
import cn.jmu.service.OrderListService;
import cn.jmu.service.TicketService;
import cn.jmu.service.UserService;

@Controller
public class TicketController {
	@Resource(name="ticketServiceImpl")
	private TicketService ticketService;
	@Resource(name="orderListServiceImpl")
	private OrderListService orderListService;
	@Resource(name="userServiceImpl")
	private UserService userService;
	@Resource(name="exFlightProductServiceImpl")
	private ExFlightProductService exFlightProductService;
	@Resource(name="flightProductServiceImpl")
	private FlightProductService flightProductService;
	
	@RequestMapping(value="/user/userOrderList.do")
	public String getAllTickeByAccount(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String account = (String) request.getAttribute("account");
		List<Ticket> orderList = this.ticketService.getAllTickeByAccount(account);
		request.setAttribute("orderList", orderList);
		return "user/myOrder";
	}
	@RequestMapping("/user/userOrderAdd.do")
	public String addOrder(HttpServletRequest request, HttpSession session) throws Exception{
		List<Passenger> passengerList =(List<Passenger>) session.getAttribute("passengerList");
		session.removeAttribute("passengerList");
		ExFlight exflight = (ExFlight) session.getAttribute("exFlight");
		session.removeAttribute("exFlight");
		int price = (int) session.getAttribute("price");
		session.removeAttribute("price");
		boolean payment = Boolean.parseBoolean(request.getParameter("payment"));
		String flightProductID = (String) session.getAttribute("flightProductID");
		session.removeAttribute("flightProductID");
		int pointPrice = (int) session.getAttribute("pointPrice");
		session.removeAttribute("pointPrice");
		User user = (User)session.getAttribute("user");
		
		if(payment==false && user.getPoint()<pointPrice*passengerList.size()) {
			request.setAttribute("pay", "noPoint");
			return "user/user_QueryFlightOrder";
		}else if(exFlightProductService.getExFlightProductLeftTicket(exflight.getFlightID(), flightProductID, exflight.getExFlightDate().toString())<passengerList.size()) {
			request.setAttribute("pay", "noTicket");
			return "user/user_QueryFlightOrder";
		}
		else {
			String account = user.getAccount();
			Timestamp time = new Timestamp(System.currentTimeMillis());
			int orderID = orderListService.getLatestOrderID(account) +1;
			OrderList order = new OrderList(account,orderID,time);
			this.orderListService.addOrder(order);
			String flightID = exflight.getFlightID();
			Date exFlightDate = exflight.getExFlightDate();
			if(payment==false) {
				price=pointPrice;
			}
			for(Passenger passenger:passengerList) {
				UUID uuid = UUID.randomUUID(); 
				String ticketID = "731"+uuid.toString().substring(0, 12);
				Ticket ticket = new Ticket(account,orderID,ticketID,flightID,exFlightDate,flightProductID,passenger.getPassengerName(),
						passenger.getPassengerTel(),passenger.getPassengerIDCard(),passenger.isInsurance(),payment,price,passenger.isPassengerSex());
				this.ticketService.addTicket(ticket);
			}
			int rewardPoint = flightProductService.getRewardPoint(flightID, flightProductID);
			user.setPoint(rewardPoint*passengerList.size()+user.getPoint());
			userService.updateUser(user);
			if(payment==false) {
				int point = user.getPoint();
				pointPrice = pointPrice*passengerList.size();
				String s = String.valueOf((point-pointPrice));
				userService.payByPoint(account, s);
			}
			String num=String.valueOf(passengerList.size());
			exFlightProductService.updateExFlightProductTicket(num, flightID, flightProductID, exFlightDate.toString());
			user = userService.getUserByAccount(account);
			session.setAttribute("user", user);
			return "user/myOrder";
		}
	}
}
