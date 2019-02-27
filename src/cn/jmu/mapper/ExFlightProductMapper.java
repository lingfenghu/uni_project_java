package cn.jmu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.jmu.po.ExFlightProduct;

public interface ExFlightProductMapper {
	
	public List<ExFlightProduct> getAllExFlightProduct() throws Exception;
	public ExFlightProduct getExFlightProductByPK(@Param("flightID")String flightID,@Param("exFlightDate")String exFlightDate,@Param("flightProductID")String flightProductID) throws Exception;
	
	public int updateExFlightProduct(ExFlightProduct exFlightProduct) throws Exception;
	public List<ExFlightProduct> getAllExFlightProductByFlightIDAndDate(String flightID,String exFlightDate) throws Exception;
		
	public int getExFlightProductLeftTicket(@Param("flightID")String flightID,@Param("flightProductID")String flightProductID,
			@Param("exFlightDate")String exFlightDate) throws Exception;
	public void updateExFlightProductTicket(@Param("num")String num,@Param("flightID")String flightID,@Param("flightProductID")String flightProductID,
			@Param("exFlightDate")String exFlightDate)throws Exception;
}
