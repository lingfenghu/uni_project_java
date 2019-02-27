package cn.jmu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.jmu.mapper.AccountMapper;
import cn.jmu.po.Account;
import cn.jmu.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{

	@Resource(name="accountMapper")
	private AccountMapper accountMapper;

	public List<Account> getAllAccount() throws Exception {
		return this.accountMapper.getAllAccount();
	}
	public void addAccount(Account account) throws Exception{
		this.accountMapper.addAccount(account);
	}
	public void UpdateAccount(Account account) throws Exception{
		this.accountMapper.UpdateAccount(account);
	}
	public Account getAccountByAccount(String account) throws Exception{
		return this.accountMapper.getAccountByAccount(account);
	}
}
