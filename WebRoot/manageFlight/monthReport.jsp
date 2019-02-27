<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="cn.jmu.po.Statement" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>月度报表</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<meta content="" name="description" />
    <meta content="webthemez" name="author" />
    <link href="assets/css/bootstrap.css" rel="stylesheet" />
    <link href="assets/css/font-awesome.css" rel="stylesheet" />
    <link href="assets/css/custom-styles.css" rel="stylesheet" />
	<link rel="stylesheet" type="text/css" href="assets/css/common.css">
</head>
<body>
<% if(session.getAttribute("account")==null){%><jsp:forward page="exit2.do"></jsp:forward><%}
Statement statement= null;
statement= (Statement) request.getAttribute("statement");%>
    <div id="wrapper">
        <nav class="navbar navbar-default top-navbar" role="navigation">
            <div class="navbar-header">
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
                        <a href="manageFlight.jsp"><i class="fa fa-dashboard"></i> 航班信息管理</a>
                    </li>
                    <li>
						<a href="manageExFlight.jsp"><i class="fa fa-desktop"></i> 动态航班信息管理</a>
					</li>					 
                    <li>
                    	<a href="allExFlightProduct.do"><i class="fa fa-sitemap"></i> 舱位产品信息管理</a>
                    </li>
                    <li>
                    	<a class="active-menu" href="preMonthReport.jsp"><i class="fa fa-qrcode"></i> 航班月度信息分析</a>
                    </li>
                    <li>
                    	<a href="outputRule.do"><i class="fa fa-fw fa-file"></i> 退换票规则管理</a>
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
		<%if (statement!=null){ %>	
		<div id="content">
			<div id="content_">
				<h3>航班情况月度报表</h3><br>
				<table>
	 				<tr><td colspan="5" style="text-align: center"><%=statement.getFlightID() %></td></tr>
	 				<tr><td>销售票数</td><td>总收入</td><td>准点率</td><td>执飞次数</td></tr>
	 				<tr><td><%=statement.getTicketNum() %></td><td><%=statement.getIncome()%></td><td><%=statement.getRate()%></td><td><%=statement.getExNum()%></td></tr>
 				</table>
			</div>
		</div>
		<%}else{ %>
 			<center>不存在此航班</center>
 		<%} %>
            <div id="page-inner"> 
				 <footer><p>Copyright &copy; 2018 中国集美蓝天航空公司.</p></footer>
				</div>
            </div>
        </div>
    <script src="assets/js/jquery-1.10.2.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <script src="assets/js/jquery.metisMenu.js"></script>
    <script src="assets/js/custom-scripts.js"></script>	
</body>
</html>