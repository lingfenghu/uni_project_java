package cn.jmu.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.jmu.po.Account;
import cn.jmu.po.User;
import cn.jmu.service.AccountService;
import cn.jmu.service.UserService;

@Controller
public class UserController {
	@Resource(name="userServiceImpl")
	private UserService userService; 
	@Resource(name="accountServiceImpl")
	private AccountService accountService;
	@RequestMapping(value="user/userUpdate.do")
	public String userUpdate(HttpServletRequest request,HttpSession session)throws Exception{
		String account = request.getParameter("account");
		String userSex = request.getParameter("userSex");
		String userTel = request.getParameter("userTel");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		int point = Integer.parseInt(request.getParameter("point"));
		User user = new User();
		user.setAccount(account);
		if(userSex.equals("true")) {
			user.setSex(true);
		}else {
			user.setSex(false);
		}
		user.setPoint(point);
		user.setUserTel(userTel);
		user.setEmail(email);
		user.setPassword(password);
		userService.updateUser(user);
		Account a = accountService.getAccountByAccount(account);
		a.setPassword(password);
		accountService.UpdateAccount(a);
		session.setAttribute("user",userService.getUserByAccount(account));
		request.setAttribute("update", "ok");
		return "user/myAccount";
	}
}
