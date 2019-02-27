<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="cn.jmu.po.User"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>中国蓝天航空-机票查询</title>
<link rel="stylesheet" type="text/css" href="../css/cityselector.css">
<link rel="stylesheet" type="text/css" href="../css/user.css">
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

<div id=middle>
	<div id=tabbar>
		<input id="tab1" type="button" onclick="click1()" value="机票预定">
		<input id="tab2" type="button" onclick="click2()" value="航班动态">
	</div>
	<div id=tabcontent>
		<div id="tab1_content">
			<div id="tabbar1">
				<input type="button" value="单程">
			</div>
			<form action="allExFlight.do">
				<table id="tab_content1" class="tab_content">
					<tr><td>出发城市</td><td>到达城市</td><td>出发时间</td></tr>
					<tr>
						<td><input id="form1_citySelect1" type="text" name="departCity" required="required"></td>
						<td><input id="form1_citySelect2" type="text" name="arriveCity" required="required"></td>
						<td><input id="form1_calendar" type="text" name="exFlightDate" required="required"></td>
					</tr>
				</table>
				<input id="ordeTicket" type="submit" value="查询机票">
			</form>
			
		</div>
		
		<div id="tab2_content">
		
			<div id="tabbar2">
				<input id="tab2_1" type="button" onclick="click3()" value="按航班路线">
				<input id="tab2_2" type="button" onclick="click4()" value="按航班号">
			</div>
			
			<div id="tab2_content_1">
				<form action="allExFlight2.do">
					<table id="tab_content2" class="tab_content">
						<tr><td>出发城市</td><td>到达城市</td><td>出发时间</td></tr>
						<tr>
							<td><input id="form2_citySelect1" type="text" name="departCity" required="required"></td>
							<td><input id="form2_citySelect2" type="text" name="arriveCity" required="required"></td>
							<td><input id="form2_calendar" type="text" name="exFlightDate" required="required"></td>
						</tr>
					</table>
					<input class="queryFlight" type="submit" value="查询航班">
				</form>
			</div>
			
			<div id="tab2_content_2">
				<form action="allExFlight3.do">
					<table id="tab_content2" class="tab_content">
						<tr><td>航班号</td><td>出发时间</td></tr>
						<tr>
							<td><input id="flight" type="text" name="flightID" required="required" placeholder="例如：MF3780"></td>
							<td><input id="form3_calendar" type="text" name="exFlightDate" required="required"></td>
						</tr>
					</table>
					<input class="queryFlight" type="submit" value="查询航班">
				</form>
			</div>
		</div>
	</div>
</div>
<div>
	<p>Copyright &copy; 2018 中国集美蓝天航空公司.</p>
</div>
</body>
<script type="text/javascript" src="../js/cityselect.js"></script>
<script type="text/javascript">
	function click1(){
		document.getElementById("tab1").style.backgroundColor="#44a2ff";
		document.getElementById("tab2").style.backgroundColor="white";
		document.getElementById("tab1_content").style.display="block";
		document.getElementById("tab2_content").style.display="none"
	}
	function click2(){
		document.getElementById("tab2").style.backgroundColor="#44a2ff";
		document.getElementById("tab1").style.backgroundColor="white";
		document.getElementById("tab2_content").style.display="block";
		document.getElementById("tab1_content").style.display="none"
	}
	var test=new Vcity.CitySelector({input:'form1_citySelect1'});
	var test=new Vcity.CitySelector({input:'form1_citySelect2'});
	
	var test=new Vcity.CitySelector({input:'form2_citySelect1'});
	var test=new Vcity.CitySelector({input:'form2_citySelect2'});
	
	function click3(){
		document.getElementById("tab2_content_1").style.display="block";
		document.getElementById("tab2_content_2").style.display="none"
	}
	function click4(){
		document.getElementById("tab2_content_2").style.display="block";
		document.getElementById("tab2_content_1").style.display="none"
	}
</script>
<script src="../laydate/laydate.js">
</script>
<script type="text/javascript">
lay('#version').html('-v'+ laydate.v);
//执行一个laydate实例
laydate.render({
	elem: '#form1_calendar', //指定元素
	min:0,
});
laydate.render({
	elem: '#form2_calendar', //指定元素
	min:-1,
	max:7
});
laydate.render({
	elem: '#form3_calendar', //指定元素
	min:-1,
	max:7
});
</script>
</html>