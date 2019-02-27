package cn.jmu.mapper;

import org.apache.ibatis.annotations.Param;

import cn.jmu.po.User;

public interface UserMapper {
	public void addUser(User user) throws Exception;
	public User getUserByAccount(String account) throws Exception;
	public void updateUser(User user) throws Exception;
	public void payByPoint(@Param("account")String account,@Param("point")String point) throws Exception;
}
