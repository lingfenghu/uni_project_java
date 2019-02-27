package cn.jmu.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.jmu.mapper.RuleListMapper;
import cn.jmu.po.RuleList;
import cn.jmu.service.RuleListService;

@Service
public class RuleListServiceImpl implements RuleListService {
	@Resource(name="ruleListMapper")
	private RuleListMapper ruleListMapper;

	@Override
	public RuleList getRule() throws Exception{
		return this.ruleListMapper.getRule();
	}

	@Override
	public int updateRule(RuleList rule) throws Exception{
		return this.ruleListMapper.updateRule(rule);
	}

}
