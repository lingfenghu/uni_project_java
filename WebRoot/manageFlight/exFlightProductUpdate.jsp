<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,cn.jmu.po.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>舱位产品信息更新</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<meta content="" name="description" />
    <meta content="webthemez" name="author" />
	<!-- Bootstrap Styles-->
    <link href="assets/css/bootstrap.css" rel="stylesheet" />
     <!-- FontAwesome Styles-->
    <link href="assets/css/font-awesome.css" rel="stylesheet" />
        <!-- Custom Styles-->
    <link href="assets/css/custom-styles.css" rel="stylesheet" />
     <!-- Google Fonts-->
   <link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
	<link rel="stylesheet" type="text/css" href="assets/css/common.css">
	<link rel="stylesheet" type="text/css" href="assets/css/addNew.css">
</head>
<body>
<% if(session.getAttribute("account")==null){%><jsp:forward page="exit2.do"></jsp:forward><%}%>
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
                    	<a class="active-menu" href="allExFlightProduct.do"><i class="fa fa-sitemap"></i> 舱位产品信息管理</a>
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
				<h3>舱位产品信息</h3><br>
				<form action="exFlightProductUpdate.do" method="post">
					<br/> <label>航班编号:</label>&nbsp;&nbsp;
					<input readonly="readonly" type="text" name="flightID" size="40" value="${exFlightProduct.getFlightID()}"/><br/>
					<br/> <label>航班日期:</label>&nbsp;&nbsp;
					<input readonly="readonly" type="text" name="exFlightDate" size="40" value="${exFlightProduct.getExFlightDate()}" /><br/>
					<br/> <label>产品编号:</label>&nbsp;&nbsp;
					<input readonly="readonly" type="text" name="flightProductID" size="40" value="${exFlightProduct.getFlightProductID()}" /><br/>
					<br/> <label>现金价格:</label>&nbsp;&nbsp;
					<input type="text" name="price" size="40" required="required" value="${exFlightProduct.getPrice()}" /><br/>
					<br/> <label>积分价格:</label>&nbsp;&nbsp;
					<input type="text" name="pointPrice" size="40" required="required" value="${exFlightProduct.getPointPrice()}" /><br/>
					<br/> <label>剩余票数:</label>&nbsp;&nbsp;
					<input type="text" name="leftTicketNum" size="40" required="required" value="${exFlightProduct.getLeftTicketNum()}" /><br/>
					<br/> <label>能否销售:</label>&nbsp;&nbsp;
					<input type="text" name="onSale" size="40" required="required" value="${exFlightProduct.getSale()}" /><br/>
					<br/> <input type="submit" value="提交"/>&nbsp;&nbsp;
					<input type="reset" value="重置" />
				</form>
			</div>
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