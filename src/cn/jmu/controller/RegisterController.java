package cn.jmu.controller;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.jmu.po.Account;
import cn.jmu.po.User;
import cn.jmu.service.AccountService;
import cn.jmu.service.UserService;
@Controller
public class RegisterController {
	@Resource(name="accountServiceImpl")
	private AccountService accountService;
	
	@Resource(name="userServiceImpl")
	private UserService userService;
	
	@RequestMapping(value="/register.do")
	public String registerCustomer(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Account a = new Account(request.getParameter("tel"),request.getParameter("password"),false);
 		List<Account> all = accountService.getAllAccount();
 		for(Account account:all) {
 			if(account.getAccount().equals(a.getAccount())) {
 				request.setAttribute("flag", "no");
 				return "addUser";
 			}
 		}
 		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
 		String userName=request.getParameter("userName");
 		String tel=request.getParameter("tel");
 		String password=request.getParameter("password");
 		String userIDCard=request.getParameter("userIDCard");
 		Date birthdate=new java.sql.Date(sdf.parse(request.getParameter("birthdate")).getTime());
 		boolean sex;
 		if(request.getParameter("sex").equals("female")) {
 			sex=false;
 		}
 		else {
 			sex=true;
 		}
 		String email=request.getParameter("email");
 		boolean right=false;
 		String account=tel;
 		int memberID=0;
 		int point =0;
 		User user = new User(account, password, right, userName, memberID, birthdate,userIDCard, tel, email,point,sex);
 		this.accountService.addAccount(a);
 		this.userService.addUser(user);
 		request.setAttribute("flag", true);
 		return "login";
	}
}
