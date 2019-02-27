package cn.jmu.po;

import java.sql.Date;
import java.util.List;

public class Ticket {
	private String account;
	private int orderID;
	private String ticketID;
	private String flightID;
	private Date exFlightDate;
	private String flightProductID;
	private String passengerName;
	private String passengerTel;
	private String passengerIDCard;
	private boolean insurance;
	private boolean payment;
	private int ticketPrice;
	private boolean passengerSex;
	
	private List<Passenger> passenger;
	public List<Passenger> getPassenger() {
		return passenger;
	}
	public void setPassenger(List<Passenger> passenger) {
		this.passenger = passenger;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public String getTicketID() {
		return ticketID;
	}
	public void setTicketID(String ticketID) {
		this.ticketID = ticketID;
	}
	public String getFlightID() {
		return flightID;
	}
	public void setFlightID(String flightID) {
		this.flightID = flightID;
	}
	public Date getExFlightDate() {
		return exFlightDate;
	}
	public void setExFlightDate(Date exFlightDate) {
		this.exFlightDate = exFlightDate;
	}
	public String getFlightProductID() {
		return flightProductID;
	}
	public void setFlightProductID(String flightProductID) {
		this.flightProductID = flightProductID;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public String getPassengerTel() {
		return passengerTel;
	}
	public void setPassengerTel(String passengerTel) {
		this.passengerTel = passengerTel;
	}
	public String getPassengerIDCard() {
		return passengerIDCard;
	}
	public void setPassengerIDCard(String passengerIDCard) {
		this.passengerIDCard = passengerIDCard;
	}
	public boolean isInsurance() {
		return insurance;
	}
	public void setInsurance(boolean insurance) {
		this.insurance = insurance;
	}
	public boolean isPayment() {
		return payment;
	}
	public void setPayment(boolean payment) {
		this.payment = payment;
	}
	public int getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(int ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	public boolean isPassengerSex() {
		return passengerSex;
	}
	public void setPassengerSex(boolean passengerSex) {
		this.passengerSex = passengerSex;
	}
	public Ticket(String account, int orderID, String ticketID, String flightID, Date exFlightDate,
			String flightProductID, String passengerName, String passengerTel, String passengerIDCard,
			boolean insurance, boolean payment, int ticketPrice, boolean passengerSex) {
		super();
		this.account = account;
		this.orderID = orderID;
		this.ticketID = ticketID;
		this.flightID = flightID;
		this.exFlightDate = exFlightDate;
		this.flightProductID = flightProductID;
		this.passengerName = passengerName;
		this.passengerTel = passengerTel;
		this.passengerIDCard = passengerIDCard;
		this.insurance = insurance;
		this.payment = payment;
		this.ticketPrice = ticketPrice;
		this.passengerSex = passengerSex;
	}
	public Ticket() {
		
	}				
	public String getTicketSex() {
		if(this.passengerSex==true) {
			return "男";
		}else {
			return "女";
		}
	}
	public String getTicketInsurance() {
		if(this.insurance==true) {
			return "是";
		}else {
			return "否";
		}
	}
	public String getTicketPayment() {
		if(this.isPayment()==true) {
			return "现金";
		}else {
			return "积分";
		}
	}
}
