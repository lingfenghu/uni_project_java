package cn.jmu.po;

public class Passenger {
	private String passengerName;
	private String passengerIDCard;
	private String passengerTel;
	private boolean insurance;
	private boolean passengerSex;
	
	public Passenger(String passengerName, String passengerIDCard, String passengerTel, boolean insurance,
			boolean passengerSex) {
		super();
		this.passengerName = passengerName;
		this.passengerIDCard = passengerIDCard;
		this.passengerTel = passengerTel;
		this.insurance = insurance;
		this.passengerSex = passengerSex;
	}
	public boolean isPassengerSex() {
		return passengerSex;
	}
	public void setPassengerSex(boolean passengerSex) {
		this.passengerSex = passengerSex;
	}
	public Passenger() {
		
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public String getPassengerIDCard() {
		return passengerIDCard;
	}
	public void setPassengerIDCard(String passengerIDCard) {
		this.passengerIDCard = passengerIDCard;
	}
	public String getPassengerTel() {
		return passengerTel;
	}
	public void setPassengerTel(String passengerTel) {
		this.passengerTel = passengerTel;
	}
	public boolean isInsurance() {
		return insurance;
	}
	public void setInsurance(boolean insurance) {
		this.insurance = insurance;
	}
	public String getSex() {
		if(this.passengerSex==false)
			return "Å®";
		else
			return "ÄÐ";
	}
	public String getInsurance() {
		if(this.insurance==false)
			return "·ñ";
		else
			return "ÊÇ";
	}
}
