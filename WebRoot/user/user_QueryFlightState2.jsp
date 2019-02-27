<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="cn.jmu.po.ExFlight"%>
<%@ page import="java.util.*"%>
<%@ page import="java.sql.Time"%>
<%@ page import="cn.jmu.po.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>机票查询</title>
<link rel="stylesheet" type="text/css" href="../css/queryResult1_1.css">
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
<div id="middle">
	<% 
		ExFlight ExFlight=(ExFlight)request.getAttribute("ExFlight");
		if(ExFlight!=null){%>
			<div class="yourSelect">
				<h3>单程</h3>
				<label>出发城市:<span style="color:blue"><%=ExFlight.getFlight().getDepartCity() %></span>
				&nbsp;&nbsp;到达城市:<span style="color:blue"><%=ExFlight.getFlight().getArriveCity()%></span>&nbsp;&nbsp;
				出发日期:<span style="color:blue"><%=ExFlight.getExFlightDate() %></span></label>
			</div>
			<hr/>
	<div class="yourSelect">
		<table>
			<tr><td>航班号</td><td>航程</td><td>日期</td><td>起飞时间</td><td>到达时间</td><td>航班状态</td></tr>
			<% 	
					String preDepartTime= ExFlight.getFlight().getPreDepartTime().toString();
					String totalTime=ExFlight.getFlight().getPreTotalTime();
					String[] timeList1 = preDepartTime.split(":");
					String[] timeList2 = totalTime.split(":");
					String preArriveTime ="";
					for(int i=0;i<timeList1.length;++i) {
						timeList1[i] = String.valueOf(Integer.valueOf(timeList1[i])+Integer.valueOf(timeList2[i]));
						preArriveTime += timeList1[i];
						if(i!=2) {
							preArriveTime += ":";
						}
					}
					Time t = Time.valueOf(preArriveTime);
				%>
			<tr>
				<td><%=ExFlight.getFlightID()%></td>
				<td><%=ExFlight.getFlight().getDepartCity()%>-<%=ExFlight.getFlight().getArriveCity()%></td>
				<td><%=ExFlight.getExFlightDate()%></td>
				<td>预计:<%=ExFlight.getDepartTime().toString() %></td>
				<td>预计:<%=ExFlight.getArriveTime().toString()%></td>
				<%if(ExFlight.getFlightState().getFlightStateContext().equals("计划")){ %>
				<td>计划</td><%}else if(ExFlight.getFlightState().getFlightStateContext().equals("起飞")){%>
				<td>起飞</td><%}else if(ExFlight.getFlightState().getFlightStateContext().equals("延误")){%>
				<td>延误</td><%}else if(ExFlight.getFlightState().getFlightStateContext().equals("取消")){%>
				<td>取消</td><%}%>
			</tr>
			<tr>
				<td></td><td></td><td></td><td>计划:<%=ExFlight.getFlight().getPreDepartTime().toString()%></td>
				<td>计划:<%=t.toString()%></td>
			</tr>
		</table>
	<% }else{ %>
		<div class="yourSelect">
			<center>无此执飞航班</center>
		</div>
		<% }%>	
	</div>
</div>
</body>
</html>