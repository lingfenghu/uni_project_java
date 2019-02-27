package cn.jmu.service;

import cn.jmu.po.Statement;

public interface StatementService {
	public Statement getAStatement(String year,String month,String flightID) throws Exception;
}
