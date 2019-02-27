package cn.jmu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.jmu.mapper.TicketMapper;
import cn.jmu.po.Ticket;
import cn.jmu.service.TicketService;
@Service
public class TicketServiceImpl implements TicketService{
	@Resource(name="ticketMapper")
	private TicketMapper ticketMapper;
	public List<Ticket> getAllTickeByAccount(String account) throws Exception{
		return ticketMapper.getAllTickeByAccount(account);
	}
	public void addTicket(Ticket ticket) throws Exception{
		ticketMapper.addTicket(ticket);
	}
}
