package cn.jmu.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.jmu.mapper.OrderListMapper;
import cn.jmu.po.OrderList;
import cn.jmu.service.OrderListService;
@Service
public class OrderListServiceImpl implements OrderListService{
	@Resource(name="orderListMapper")
	private OrderListMapper orderListMapper;
	public void addOrder(OrderList order) throws Exception {
		this.orderListMapper.addOrder(order);
	}
	public int getLatestOrderID(String account) throws Exception{
		return this.orderListMapper.getLatestOrderID(account);
	}
}
