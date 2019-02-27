package cn.jmu.service;

import java.util.List;

import cn.jmu.po.FlightProduct;

public interface FlightProductService {
	public List<FlightProduct> getALLFlightProdcutByFlightID(String flightID) throws Exception;
	public int getRewardPoint(String flightID,String flightProductID) throws Exception;

}
