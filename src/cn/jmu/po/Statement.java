package cn.jmu.po;

public class Statement {
	private String flightID;
	private int year;
	private int month;
	private int ticketNum;
	private int income;
	private float rate;
	private int exNum;
	public String getFlightID() {
		return flightID;
	}
	public void setFlightID(String flightID) {
		this.flightID = flightID;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getTicketNum() {
		return ticketNum;
	}
	public void setTicketNum(int ticketNum) {
		this.ticketNum = ticketNum;
	}
	public int getIncome() {
		return income;
	}
	public void setIncome(int income) {
		this.income = income;
	}
	public float getRate() {
		return rate;
	}
	public void setRate(float rate) {
		this.rate = rate;
	}
	public int getExNum() {
		return exNum;
	}
	public void setExNum(int exNum) {
		this.exNum = exNum;
	}
	public Statement(String flightID, int year, int month, int ticketNum, int income, float rate, int exNum) {
		super();
		this.flightID = flightID;
		this.year = year;
		this.month = month;
		this.ticketNum = ticketNum;
		this.income = income;
		this.rate = rate;
		this.exNum = exNum;
	}
	public Statement() {
		
	}
}
