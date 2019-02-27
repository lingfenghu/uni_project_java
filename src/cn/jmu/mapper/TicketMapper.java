package cn.jmu.mapper;

import java.util.List;

import cn.jmu.po.Ticket;

public interface TicketMapper {
	public List<Ticket> getAllTickeByAccount(String account) throws Exception;
	public void addTicket(Ticket ticket) throws Exception;
}
