package cn.jmu.mapper;

import cn.jmu.po.OrderList;

public interface OrderListMapper {
	public void addOrder(OrderList order) throws Exception;
	public int getLatestOrderID(String account) throws Exception;
}
