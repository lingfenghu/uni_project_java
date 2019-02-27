<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="cn.jmu.po.User"%>
<%@ page import="cn.jmu.po.Ticket"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的订单</title>
<link rel="stylesheet" type="text/css" href="../css/myOrder.css">
</head>
<body>
<% if(session.getAttribute("user")==null){%><jsp:forward page="exit2.do"></jsp:forward><%}
	User user = (User) session.getAttribute("user");
	if(request.getAttribute("orderList")==null){
		request.setAttribute("account", user.getAccount());
		request.getRequestDispatcher("userOrderList.do").forward(request,response);
	}
	List<Ticket> orderList = (List<Ticket>)request.getAttribute("orderList");
%>
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
<div id=middle>
	<center><b><font color="#0000ff" size="4"><br>我的订单</font></b></center>
	<br/>
	<table border="2"cellpadding="2" cellspacing="1">
		<tr height="25">
	 		<th width="8%" align="left">订单编号</th>
	 		<th width="9%" align="left">机票号</th>
	 		<th width="8%" align="left">航班编号</th>
	 		<th width="8%" align="left">航班日期</th>
	 		<th width="8%" align="left">舱位产品</th>
	 		<th width="8%" align="left">乘客姓名</th>
	 		<th width="8%" align="left">乘客电话</th>
	 		<th width="11%" align="left">乘客证件</th>
	 		<th width="8%" align="left">乘客性别</th>
	 		<th width="8%" align="left">是否保险</th>
	 		<th width="8%" align="left">付款方式</th>
	 		<th width="8%" align="left">机票价格</th>
 			</tr>
 			<%	
  			int pages;
		 	if(request.getParameter("page")==null){
		 		pages=1;
		 	}else{
		 		pages=Integer.parseInt(request.getParameter("page"));
		 		if(pages<=0)
		 			pages=1;
		 	}
		 	int rowCount = orderList.size();
			int pageSize = 6;
			int pageCount = (rowCount+pageSize-1)/pageSize;	
			if(pages>pageCount){
				pages = pageCount;
			}
 				int n=(pages-1)*pageSize;
 				while (n<pageSize*pages&&n<rowCount&&rowCount!=0){%>
 						<tr>
    					<td width="8%"><%=orderList.get(n).getOrderID()%></td>
    					<td width="9%"><%=orderList.get(n).getTicketID()%></td>
		     		<td width="8%"><%=orderList.get(n).getFlightID()%></td>
		     		<td width="8%"><%=orderList.get(n).getExFlightDate()%></td>
    					<td width="8%"><%=orderList.get(n).getFlightProductID()%></td>
		     		<td width="8%"><%=orderList.get(n).getPassengerName()%></td>
		     		<td width="8%"><%=orderList.get(n).getPassengerTel()%></td>
    					<td width="11%"><%=orderList.get(n).getPassengerIDCard()%></td>
		     		<td width="8%"><%=orderList.get(n).getTicketSex()%></td>
    					<td width="8%"><%=orderList.get(n).getTicketInsurance()%></td>
    					<td width="8%"><%=orderList.get(n).getTicketPayment()%></td>
    					<td width="8%"><%=orderList.get(n).getTicketPrice()%></td>
		     		
		  			</tr>
		  	<%n++; }%>
	</table>
 	<form method="get" action="#"> 
		<p>第<%=pages%>页 共<%=pageCount%>页 共<%=rowCount%>条 
		<%
		if(pageCount>1){%>
			<a href="myOrder.jsp?page=<%=pages-1%>">上一页</a>
			<a href="myOrder.jsp?page=<%=pages+1%>">下一页</a>
			<a href="myOrder.jsp?page=<%=pageCount%>">尾页</a>
			跳到第<input type="text" name="page" size="4">页
			<input type="submit" name="submit" size="4" value="GO">
		<%}%>
		</p>
	</form>
</div>
<div>
	<p>Copyright &copy; 2018 中国集美蓝天航空公司.</p>
</div>
</body>
</html>