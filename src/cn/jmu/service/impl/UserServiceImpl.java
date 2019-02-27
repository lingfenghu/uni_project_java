package cn.jmu.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.jmu.mapper.AccountMapper;
import cn.jmu.mapper.UserMapper;
import cn.jmu.po.Account;
import cn.jmu.po.User;
import cn.jmu.service.UserService;
@Service
public class UserServiceImpl implements UserService{

	@Resource(name="accountMapper")
	private AccountMapper accountMapper;
	@Resource(name="userMapper")
	private UserMapper userMapper;
	public void addUser(User user) throws Exception {
		this.userMapper.addUser(user);	
	}
	
	public User getUserByAccount(String account) throws Exception{
		return this.userMapper.getUserByAccount(account);
	}
	public void updateUser(User user) throws Exception{
		this.userMapper.updateUser(user);
	}
	public void payByPoint(String account,String point) throws Exception{
		this.userMapper.payByPoint(account, point);
	}
}
