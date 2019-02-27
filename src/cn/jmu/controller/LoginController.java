package cn.jmu.controller;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.jmu.mapper.UserMapper;
import cn.jmu.po.Account;
import cn.jmu.po.User;
import cn.jmu.service.AccountService;
import cn.jmu.service.UserService;

@Controller
public class LoginController {
	@Resource(name="accountServiceImpl")
	private AccountService accountService;
	@Resource(name="userServiceImpl")
	private UserService userService;
	@RequestMapping(value="/login.do")
	public void loginCheck(HttpSession session,HttpServletRequest request, HttpServletResponse response) throws Exception {
		String account = request.getParameter("account");
		String password = request.getParameter("password");
 		List<Account> all = accountService.getAllAccount();
 		for(Account a:all) {
 			if(a.getAccount().equals(account)&&a.getPassword().equals(password)) {
 				if(a.getRight()) {
 					session.setAttribute("account", account);
 					response.sendRedirect("manageFlight/manageFlight.jsp");
 					return;
 				}
 				else {
 					User user = userService.getUserByAccount(account);
 					session.setAttribute("user",user);
 					response.sendRedirect("user/user.jsp");
 					return;
 				}
 			}
 		}
 		response.sendRedirect("login.jsp");
	}
}
