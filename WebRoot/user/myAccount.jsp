<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="cn.jmu.po.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的账户</title>
<link rel="stylesheet" type="text/css" href="../css/myAccount.css">
</head>
<body>
<% if(session.getAttribute("user")==null){%><jsp:forward page="exit2.do"></jsp:forward><%}
User user = (User) session.getAttribute("user");%>
<div id="header">
	<a href="user.jsp"><img alt="brand" src="../img/brand.png"></a>
	<span id="personal">
		<label><%=user.getUserName()%></label>&nbsp;&nbsp;
		<a href="exit.do">注销</a>
	</span>
</div>

<div id="menubar">
	<div class="dropdown">
		<a href="user.jsp"><button class="dropbt">首页</button></a>
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
			<a href="myAccount.jsp">我的账户</a>
			<a href="myOrder.jsp">我的订单</a>
			<a href="#">积分累计</a>
			<a href="#">积分兑换</a>
			<a href="#">会员权益</a>
			<a href="#">优惠专区</a>
		</div>
	</div>
	<div class="dropdown">
		<button class="dropbt">出行帮助</button>
		<div class="content">
			<a href="rules.jsp">购票服务</a>
			<a href="#">中转服务</a>
			<a href="#">出行准备</a>
			<a href="#">地面服务</a>
			<a href="#">客舱服务</a>
			<a href="#">运输规定</a>
		</div>
	</div>
<hr>
</div>
<div>
	<div id="you">
		<h3>基本信息</h3>
	</div>
	
		<form class="center" action="userUpdate.do" method="post">
		<input type="hidden" name="account" value="<%=user.getAccount()%>"/>
		<table>
			<tr>
				<td>会员名称</td><td><input type="hidden" name="memberName"><%=user.getMember().getMemberName()%></td>
				<td>会员级别</td><td><input type="hidden" name="memberID"><%=user.getMemberID()%></td>
			</tr>
			<tr>
				<td>身份证号</td><td><input type="hidden" name="userIDCard"><%=user.getUserIDCard()%></td>
				<td>积分</td><td><input type="hidden" name="point" value="<%=user.getPoint()%>"><%=user.getPoint()%></td>
			</tr>
			<tr>
				<td>性别</td>
				<td>
					<%
					if(user.isSex()){%>
						<select name="userSex">
							<option value="true" selected="selected">男</option>
							<option value="false">女</option>
						</select>
					<%}else{%>
						<select name="userSex">
							<option value="true">男</option>
							<option value="false" selected="selected">女</option>
						</select>
					<%} %>
				</td>
				<td>电话号码</td><td><input type="text" name="userTel" value="<%=user.getUserTel() %>" required="required" pattern="\d{11}" title="手机号码格式不正确"></td>
			</tr>	
			<tr>
				<td>电子邮箱</td><td><input type="text" name="email" required="required" value="<%=user.getEmail()%>"></td>
				<td>密码</td>
				<td><input type="text" name="password" required="required" pattern="\w{6,16}" 
				value="<%=user.getPassword()%>" title="密码只能是6-16位数字和英文字母"></td>
			</tr>
		</table>
		<input id="save" type="submit" value="保存">
	</form>
</div>
<div>
	<p>Copyright &copy; 2018 中国集美蓝天航空公司.</p>
</div>
<% 	
	String f = String.valueOf(request.getAttribute("update")); 
	if(f.equals("ok")){%>
		<script type="text/javascript">
			alert("修改成功");
		</script>
	<%}
%>
</body>
</html>