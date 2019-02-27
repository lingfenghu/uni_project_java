package cn.jmu.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.jmu.po.ExFlightProduct;

public interface ExFlightProductService {
	
	public List<ExFlightProduct> getAllExFlightProduct() throws Exception;
	public ExFlightProduct getExFlightProductByPK(String flightID,String exFlightDate,String flightProductID) throws Exception;
	public int updateExFlightProduct(ExFlightProduct exFlightProduct) throws Exception;
	public List<ExFlightProduct> getAllExFlightProductByFlightIDAndDate(String flightID,String exFlightDate) throws Exception;
	public int getExFlightProductLeftTicket(String flightID,String flightProductID,String exFlightDate) throws Exception;
	public void updateExFlightProductTicket(String num,String flightID,String flightProductID,String exFlightDate)throws Exception;
}
