package cn.jmu.mapper;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.jmu.po.ExFlight;
import cn.jmu.po.ExFlightProduct;
import cn.jmu.po.FlightProduct;

public interface ExFlightMapper {
	public List<ExFlight> getAllExFlight() throws Exception;
	public List<ExFlight> getExFlightByFlightID(String flightID) throws Exception;
	public ExFlight getExFlightByFlightIDAndExFlghtDate(String flightID,String exFlightDate)throws Exception;
	public void updateExFlight(ExFlight exFlight) throws Exception;
	
	public ExFlight getExFlightAndFlightStateAndFlightByDateaAndFlightID(@Param("flightID")String flightID,@Param("exFlightDate")String exFlightDate) throws Exception;
	
	public List<ExFlight> getAllExFlightAndFlightProductByCityAndDate
	(@Param("exFlightDate")String exFlightDate,@Param("departCity")String departCity,@Param("arriveCity")String arriveCity) throws Exception;
	public List<ExFlight> getAllExFlightAndFligtStateAndFlightByCityAndDate
	(@Param("exFlightDate")String exFlightDate,@Param("departCity")String departCity,@Param("arriveCity")String arriveCity) throws Exception;
}
