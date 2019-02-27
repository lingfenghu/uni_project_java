package cn.jmu.mapper;

import java.util.List;

import cn.jmu.po.Account;

public interface AccountMapper {
	public List<Account> getAllAccount() throws Exception;
	public void addAccount(Account account) throws Exception;
	public void UpdateAccount(Account account) throws Exception;
	public Account getAccountByAccount(String account) throws Exception;
}
