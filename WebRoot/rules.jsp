<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="cn.jmu.po.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>机票查询</title>
<link rel="stylesheet" type="text/css" href="css/rules.css">
</head>
<body>
<% if(request.getAttribute("rule")==null){request.getRequestDispatcher("outputRule.do").forward(request,response);}%>
<div id="header">
	<a href="index.jsp"><img src="img/brand.png"></a>
	<a class="entrance" href="login.jsp">登录 </a>
	<a class="entrance" href="addUser.jsp">注册</a>	
</div>
<div id="menubar">
	<div class="dropdown">
		<a href="index.jsp"><button class="dropbt">首页</button></a>
	</div>	
	<div class="dropdown">
		<button class="dropbt">预定管理 </button>
		<div class="content">
			<a href="#">机票预定</a>
			<a href="#">旅游预定</a>
			<a href="#">团队商旅</a>
			<a href="#">在线选座</a>
			<a href="#">高端选餐</a>
			<a href="#">航班动态</a>
		</div>
	</div>
	<div class="dropdown">
		<button class="dropbt">云朵会员</button>
		<div class="content">
			<a href="#">我的账户</a>
			<a href="#">我的订单</a>
			<a href="#">积分累计</a>
			<a href="#">积分兑换</a>
			<a href="#">会员权益</a>
			<a href="#">优惠专区</a>
		</div>
	</div>
	<div class="dropdown">
		<button class="dropbt">出行帮助</button>
		<div class="content">
			<a href="outputRule.do">购票服务</a>
			<a href="#">中转服务</a>
			<a href="#">出行准备</a>
			<a href="#">地面服务</a>
			<a href="#">客舱服务</a>
			<a href="#">运输规定</a>
		</div>
	</div>
<hr>
</div>
<div id="middle">
	<h3>票务规则</h3>
	<textarea readonly="readonly">${rule.getRuleContext()}</textarea>
</div>
<div>
	<p id="info">Copyright &copy; 2018 中国集美蓝天航空公司.</p>
</div>
</body>
</html>