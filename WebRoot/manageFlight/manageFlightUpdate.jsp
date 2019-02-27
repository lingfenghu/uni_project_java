<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="cn.jmu.po.Flight" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<meta content="" name="description" />
    <meta content="webthemez" name="author" />
    <title>航线信息更新</title>
    <link href="assets/css/bootstrap.css" rel="stylesheet" />
    <link href="assets/css/font-awesome.css" rel="stylesheet" />
    <link href="assets/js/morris/morris-0.4.3.min.css" rel="stylesheet" />
    <link href="assets/css/custom-styles.css" rel="stylesheet" />
	<link rel="stylesheet" type="text/css" href="assets/css/common.css">
	<link rel="stylesheet" type="text/css" href="assets/css/addNew.css">
	
</head>
<body>
<% if(session.getAttribute("account")==null){%><jsp:forward page="exit2.do"></jsp:forward><%}%>
    <div id="wrapper">
        <nav class="navbar navbar-default top-navbar" role="navigation">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="manageFlight.jsp"><strong><i class="icon fa fa-plane"></i> 航空管理系统</strong></a>
            </div>
            <ul class="nav navbar-top-links navbar-right">
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="false">
                        <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="#"><i class="fa fa-user fa-fw"></i> Admin <%=session.getAttribute("account")%></a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="exit.do"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                        </li>
                    </ul>
                </li>
            </ul>
        </nav>
        <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="main-menu">

                    <li>
                        <a class="active-menu" href="manageFlight.jsp"><i class="fa fa-dashboard"></i> 航班信息管理</a>
                    </li>
                    <li>
						<a href="manageExFlight.jsp"><i class="fa fa-desktop"></i> 动态航班信息管理</a>
					</li>					 
                    <li>
                    	<a href="allExFlightProduct.do"><i class="fa fa-sitemap"></i> 舱位产品信息管理</a>
                    </li>
                    <li>
                    	<a href="preMonthReport.jsp"><i class="fa fa-qrcode"></i> 航班月度信息分析</a>
                    </li>
                    <li>
                    	<a href="outputRule.do"><i class="fa fa-table"></i> 退换票规则管理</a>
                    </li>
                </ul>
            </div>
        </nav>    
		<div id="page-wrapper">
			<div class="header"> 
	           <h1 class="page-header">
	               Admin <%=session.getAttribute("account")%> <small>Welcome</small>
	           </h1>
			</div>
			<div id="content">
				<h3>更新航班信息</h3><br>
 			<%Flight flight = (Flight)request.getAttribute("flight");%>
		 	<form action="flightUpdate.do" method="post">
				<label>航班编号:</label>&nbsp;&nbsp;<input readonly="readonly" type="text" name="flightID" size="40" value="<%=flight.getFlightID()%>"/><br/><br/>
				<label>出发时间:</label>&nbsp;&nbsp;<input type="text" name="preDepartTime" size="40" required="required" value="<%=flight.getPreDepartTime()%>"/><br/><br/>
				<label>飞行时间:</label>&nbsp;&nbsp;<input type="text" name="preTotalTime" size="40" required="required" value="<%=flight.getPreTotalTime()%>"/><br/><br/>
				<label>航班机型:</label>&nbsp;&nbsp;<input readonly="readonly" type="text" name="flightType" size="40" value="<%=flight.getFlightType()%>"/><br/><br/>
				<label>座位总数:</label>&nbsp;&nbsp;<input type="text" name="totalSeatNum" size="40" required="required" value="<%=flight.getTotalSeatNum()%>"/><br/><br/>
				<label>出发城市:</label>&nbsp;&nbsp;<input type="text" name="departCity" size="40" required="required" value="<%=flight.getDepartCity()%>"/><br/><br/>
				<label>目的城市:</label>&nbsp;&nbsp;<input type="text" name="arriveCity" size="40" required="required" value="<%=flight.getArriveCity()%>"/><br/><br/>
				<label>保险价格:</label>&nbsp;&nbsp;<input type="text" name="insurancePrice" size="40" required="required" value="<%=flight.getInsurance()%>"/><br/><br/>
				<div align="center">
					<input type="submit" value="提交" />&nbsp;&nbsp;<input type="reset" value="重置"/>
				</div>
			</form>
			</div>
	        <div id="page-inner">
				<footer><p>Copyright &copy; 2018 中国集美蓝天航空公司.</p>
				</footer>
	        </div>
        </div>
    </div>
    <script src="assets/js/jquery-1.10.2.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <script src="assets/js/jquery.metisMenu.js"></script>
    <script src="assets/js/custom-scripts.js"></script>
</body>
</html>