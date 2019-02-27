package cn.jmu.service;

import cn.jmu.po.RuleList;

public interface RuleListService {
	public RuleList getRule() throws Exception;
	public int updateRule(RuleList rule) throws Exception;
}
