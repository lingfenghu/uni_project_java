package cn.jmu.service;

import cn.jmu.po.User;

public interface UserService {
	public void addUser(User user) throws Exception;
	public User getUserByAccount(String account) throws Exception;
	public void updateUser(User user) throws Exception;
	public void payByPoint(String account,String point) throws Exception;

}
