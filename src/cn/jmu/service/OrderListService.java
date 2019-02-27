package cn.jmu.service;

import cn.jmu.po.OrderList;

public interface OrderListService {
	public void addOrder(OrderList order) throws Exception;
	public int getLatestOrderID(String account) throws Exception;
}
