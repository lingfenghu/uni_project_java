package cn.jmu.po;

import java.sql.Date;

public class RuleList {
	private int ruleID;
	private String ruleContext;
	private Date reviseTime;
	public RuleList() {
		
	}//
	public RuleList(int ruleID, String ruleContext, Date reviseTime) {
		this.ruleID = ruleID;
		this.ruleContext = ruleContext;
		this.reviseTime = reviseTime;
	}
	public int getRuleID() {
		return ruleID;
	}
	public void setRuleID(int ruleID) {
		this.ruleID = ruleID;
	}
	public String getRuleContext() {
		return ruleContext;
	}
	public void setRuleContext(String ruleContext) {
		this.ruleContext = ruleContext;
	}
	public Date getReviseTime() {
		return reviseTime;
	}
	public void setReviseTime(Date reviseTime) {
		this.reviseTime = reviseTime;
	}
	@Override
	public String toString() {
		return "RuleList [ruleID=" + ruleID + ", ruleContext=" + ruleContext + ", reviseTime=" + reviseTime + "]";
	}
	
}
