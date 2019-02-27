package cn.jmu.mapper;

import cn.jmu.po.RuleList;

public interface RuleListMapper {
	public RuleList getRule() throws Exception;
	public int updateRule(RuleList rule) throws Exception;
}
