package cn.jmu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.jmu.po.FlightProduct;

public interface FlightProductMapper {
	public List<FlightProduct> getALLFlightProdcutByFlightID(String flightID) throws Exception;
	public int getRewardPoint(@Param("flightID")String flightID,@Param("flightProductID")String flightProductID) throws Exception;
}
