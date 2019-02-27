package cn.jmu.service;

import java.util.List;

import cn.jmu.po.Ticket;

public interface TicketService {
	public List<Ticket> getAllTickeByAccount(String account) throws Exception;
	public void addTicket(Ticket ticket) throws Exception;

}
