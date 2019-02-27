package cn.jmu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.jmu.mapper.ExFlightProductMapper;
import cn.jmu.po.ExFlightProduct;
import cn.jmu.service.ExFlightProductService;

@Service
public class ExFlightProductServiceImpl implements ExFlightProductService {
	@Resource(name="exFlightProductMapper")
	private ExFlightProductMapper exFlightProductMapper;
	
	public List<ExFlightProduct> getAllExFlightProduct() throws Exception{
		return exFlightProductMapper.getAllExFlightProduct();
	}
	
	@Override
	public ExFlightProduct getExFlightProductByPK(String flightID, String exFlightDate, String flightProductID)
			throws Exception {
		return exFlightProductMapper.getExFlightProductByPK(flightID, exFlightDate, flightProductID);
	}
	
	public int updateExFlightProduct(ExFlightProduct exFlightProduct) throws Exception{
		return exFlightProductMapper.updateExFlightProduct(exFlightProduct);
	}

	public List<ExFlightProduct> getAllExFlightProductByFlightIDAndDate(String flightID,String exFlightDate) throws Exception{
		return this.exFlightProductMapper.getAllExFlightProductByFlightIDAndDate(flightID, exFlightDate);
	}
	public int getExFlightProductLeftTicket(String flightID,String flightProductID,String exFlightDate) throws Exception{
		return this.exFlightProductMapper.getExFlightProductLeftTicket(flightID, flightProductID, exFlightDate);
	}
	public void updateExFlightProductTicket(String num,String flightID,String flightProductID,String exFlightDate)throws Exception{
		this.exFlightProductMapper.updateExFlightProductTicket(num, flightID, flightProductID, exFlightDate);
	}


}
