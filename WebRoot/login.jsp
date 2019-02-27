<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">

<title>中国集美蓝天航空公司官网</title>
<link rel="stylesheet" type="text/css" href="css/login.css">
</head>
<body >
<div id="header">
	<a href="index.jsp"><img alt="brand" src="img/brand.png"></a>
</div>
<div id="center">
	<div id="loginbox">
		<h1>Login</h1>
		<form action="login.do" method="post">
			<input type="text" name="account" required="required" placeholder="用户名" >
			<input type="password" name="password" required="required" placeholder="密码">
			<input id="button" type="submit" value="登录">
		</form>
		<a id="register" href="addUser.jsp">注册</a>
	</div>
	<div id="info">
		<p>Copyright &copy;2018  中国集美蓝天航空公司</p>
	</div>
	
</div>
</body>
</html>