package cn.jmu.service;

import java.util.List;

import cn.jmu.po.Account;

public interface AccountService {
	public List<Account> getAllAccount() throws Exception;
	public void addAccount(Account account) throws Exception;
	public void UpdateAccount(Account account) throws Exception;
	public Account getAccountByAccount(String account) throws Exception;

}
