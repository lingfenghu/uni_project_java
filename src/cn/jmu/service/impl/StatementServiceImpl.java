package cn.jmu.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.jmu.mapper.StatementMapper;
import cn.jmu.po.Statement;
import cn.jmu.service.StatementService;
@Service
public class StatementServiceImpl implements StatementService{
	@Resource(name="statementMapper")
	private StatementMapper statementMapper;
	public Statement getAStatement(String year, String month, String flightID) throws Exception {
		return this.statementMapper.getAStatement(year, month, flightID);
	}

}
