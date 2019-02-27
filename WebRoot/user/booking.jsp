<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="cn.jmu.po.Passenger,java.util.*" %>
<%@ page import="cn.jmu.po.ExFlight"%>
<%@ page import="cn.jmu.po.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>机票预定</title>
<link rel="stylesheet" type="text/css" href="../css/booking.css">
</head>
<body>
<% if(session.getAttribute("user")==null){%><jsp:forward page="exit2.do"></jsp:forward><%}
	User user = (User) session.getAttribute("user");%>
<div id="header">
	<a href="user.jsp"><img alt="brand" src="../img/brand.png"></a>
	<div id="personal">
		<label><%=user.getUserName()%></label>&nbsp;&nbsp;
		<a href="exit.do">注销</a>	
	</div>
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
		int price; int pointPrice; ExFlight exFlight;
		if(request.getParameter("index")!=null){
			String n =	request.getParameter("index");
			int index = Integer.valueOf(n);
			String flightProductID = request.getParameter("flightProductID"+n);
			
			exFlight=((List<ExFlight>)session.getAttribute("allExFlightAndProduct")).get(index);
			price =  Integer.valueOf(request.getParameter("price"+flightProductID+n));
			pointPrice = Integer.valueOf(request.getParameter("pointPrice"+flightProductID+n));
			
			session.setAttribute("flightProductID", flightProductID);
			session.setAttribute("exFlight", exFlight);
			session.setAttribute("price", price);
			session.setAttribute("pointPrice", pointPrice);
		}else{
			price = (int)session.getAttribute("price");
			pointPrice = (int) session.getAttribute("pointPrice");
			exFlight=(ExFlight)session.getAttribute("exFlight");
		}
	%>
	<div id="flightInfo">
		<h3>航班信息</h3>
		<p>出发城市&nbsp;&nbsp; 出发时间&nbsp;&nbsp; 目的城市&nbsp;&nbsp; 到达时间&nbsp;&nbsp; 机票单价&nbsp;&nbsp; 积分单价</p>
		<p><%=exFlight.getFlight().getDepartCity()%>&nbsp; <%=exFlight.getExFlightDate()%>&nbsp; <%=exFlight.getFlight().getArriveCity() %>
		&nbsp;&nbsp;&nbsp; <%=exFlight.getArriveTime() %>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <%=price%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <%= pointPrice%>
		</p>
	</div>
	<div id="passengerInfo">
		<%
			List<Passenger>	passengerList = null;
			if(session.getAttribute("passengerList")==null){
				passengerList = new ArrayList<Passenger>();
				session.setAttribute("passengerList", passengerList);
			}else{
				passengerList=(List<Passenger>)session.getAttribute("passengerList");
			}
			if(request.getParameter("passengerName")!=null){
				String token = request.getParameter("token");
				if(session.getAttribute("token")!=null && ((String)session.getAttribute("token")).equals(token)){
					
				}else{
					session.setAttribute("token", token);
					String passengerName = request.getParameter("passengerName");
					String passengerIDCard = request.getParameter("passengerIDCard");
					String passengerTel = request.getParameter("passengerTel");
					boolean ins = false;
					boolean passengerSex = Boolean.valueOf(request.getParameter("passengerSex"));
					if(request.getParameter("insurance")!=null){
						ins = true;
					}
					Passenger passenger = new Passenger(passengerName,passengerIDCard,passengerTel,ins,passengerSex);	
					passengerList.add(passenger);
					session.setAttribute("passengerList", passengerList);	
				}
			}
		%>
		<form action="userOrderAdd.do" onsubmit="return judge(<%=passengerList%>);">
			<table>
				<%for(Passenger p : passengerList){%>
				<tr>
					<td>姓名</td><td><%=p.getPassengerName() %></td>
					<td>身份证</td><td><%=p.getPassengerIDCard() %></td>
					<td>手机号码</td><td><%=p.getPassengerTel() %></td>
					<td>性别</td><td><%=p.getSex()%></td>
					<td>保险</td><td><%=p.getInsurance()%></td>
				</tr>
				<%}%>
			</table>
			<input type="radio" value="false" name="payment" required="required">积分支付
			<input type="radio" value="true" name="payment" required="required">现金支付
			<input type="submit" value="支付">
		</form>
		<br/><br/>
		<form action="booking.jsp">
			<input type="hidden" name="token" value="<%=System.currentTimeMillis()%>"> 
			<table>
				<tr><td>姓名</td><td><input type="text" name="passengerName" required="required"></td></tr>
				<tr><td>证件号</td><td><input type="text" name="passengerIDCard" required="required" pattern="\d{15}|(\d{17}(\d|X))" title="证件号码格式不正确"></td></tr>
				<tr><td>手机号码</td><td><input type="text" name="passengerTel" required="required" pattern="\d{11}" title="手机号码格式不正确"></td></tr>
				<tr><td>乘客性别</td><td><input type="radio" name="passengerSex" value="true" required="required">男<input type="radio" name="passengerSex" value="false" required="required">女</td></tr>
				<tr><td>保险</td><td>	<input type="checkbox" name="insurance" value="true">乘客安全险<%=exFlight.getFlight().getInsurance()%>/人</td></tr>
			</table>
			<input type="submit" value="添加">
		</form>
	</div>
</div>
<script type="text/javascript">
	function judge(passengerList){
		if(passengerList.length==0){
			alert("请添加乘客");
			return false;
		}else{
			return true;
		}
	}

</script>
</body>
</html>