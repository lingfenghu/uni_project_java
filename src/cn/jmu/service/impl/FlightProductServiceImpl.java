package cn.jmu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.jmu.mapper.FlightProductMapper;
import cn.jmu.po.FlightProduct;
import cn.jmu.service.FlightProductService;
@Service
public class FlightProductServiceImpl implements FlightProductService{
	@Resource(name="flightProductMapper")
	private FlightProductMapper flightProductMapper;
	
	public List<FlightProduct> getALLFlightProdcutByFlightID(String flightID) throws Exception{
		return this.getALLFlightProdcutByFlightID(flightID);
	}	
	public int getRewardPoint(String flightID,String flightProductID) throws Exception{
		return this.flightProductMapper.getRewardPoint(flightID, flightProductID);
	}
}
