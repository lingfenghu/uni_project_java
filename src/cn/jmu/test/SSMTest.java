package cn.jmu.test;


import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.jmu.po.Account;
import cn.jmu.po.ExFlight;
import cn.jmu.po.ExFlightProduct;
import cn.jmu.service.AccountService;
import cn.jmu.service.ExFlightService;

public class SSMTest {

	@Test
	public void getAllExFlight() throws Exception {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		ExFlightService exFlightService = (ExFlightService) applicationContext.getBean("exFlightServiceImpl");
		List<ExFlight> all = exFlightService.getAllExFlight();
		for(ExFlight exFlight : all) {
			System.out.println(exFlight.toString());
		}
	}
	@Test
	public void ttt() throws ParseException {
		System.currentTimeMillis();
	      
	}
}
