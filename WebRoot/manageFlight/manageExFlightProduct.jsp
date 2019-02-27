<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,cn.jmu.po.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>舱位产品信息信息管理</title>
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
	<link rel="stylesheet" type="text/css" href="assets/css/common.css">
	
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
			<%
	 		if(session.getAttribute("allExFlightProduct")==null&&request.getAttribute("allExFlightProduct")==null){
		 		request.getRequestDispatcher("allExFlightProduct.do").forward(request, response);
		 	}
				if(session.getAttribute("allExFlightProduct")==null){
					session.setAttribute("allExFlightProduct",request.getAttribute("allExFlightProduct"));
		 	}
				List<ExFlightProduct> allExFlightProduct = (List<ExFlightProduct>)session.getAttribute("allExFlightProduct");
				int pages;
			 	if(request.getParameter("page")==null){
			 		pages=1;
			 	}else{
			 		pages=Integer.parseInt(request.getParameter("page"));
			 		if(pages<=0)
			 			pages=1;
			 	}
			 	int rowCount = allExFlightProduct.size();
				int pageSize = 6;
				int pageCount = (rowCount+pageSize-1)/pageSize;	
				if(pages>pageCount){
					pages = pageCount;
				}
 			%>
			<div id="content_">
				<h3>舱位产品列表</h3>
				<table cellpadding="5px">
 			 		<tr><td>航班编号</td><td>航班日期</td><td>舱位产品编号</td><td>修改舱位产品</td></tr>
 			 		<%	int n=(pages-1)*pageSize;
  						while (n<pageSize*pages&&n<rowCount&&rowCount!=0){%>
	 				<tr>
	 					<td><%=allExFlightProduct.get(n).getFlightID() %></td>
	 					<td><%=allExFlightProduct.get(n).getExFlightDate() %></td>
	 					<td><%=allExFlightProduct.get(n).getFlightProductID() %></td>
	 					<td><a href="getExFlightProduct.do?flightID=<%=allExFlightProduct.get(n).getFlightID()%>&exFlightDate=<%=allExFlightProduct.get(n).getExFlightDate()%>&flightProductID=<%=allExFlightProduct.get(n).getFlightProductID() %>">
	 					<img src="../img/update.png" width="30px" height="30px"></a></td>
	 				</tr>
 					<%n++; }%>
 				</table>
			</div>
 			<form method="get" action="#"> 
			<p align="center">第<%=pages%>页 共<%=pageCount%>页 共<%=rowCount%>条 
			<%
			if(pageCount>1){%>
				<a href="manageExFlightProduct.jsp?page=<%=pages-1%>">上一页</a>
				<a href="manageExFlightProduct.jsp?page=<%=pages+1%>">下一页</a>
				<a href="manageExFlightProduct.jsp?page=<%=pageCount%>">尾页</a>
				跳到第<input type="text" name="page" size="4">页
				<input type="submit" name="submit" size="4" value="GO">
			<%}%> </p>
			</form>
		</div>
        <div id="page-inner"> 
			 <footer><p>Copyright &copy; 2018 中国集美蓝天航空公司.</p></footer>
		</div>
<%if( request.getAttribute("update")!=null&&request.getAttribute("update").equals("ok")) {%>
	<script type="text/javascript">
	alert("修改成功");
	</script>
<%}%>
        </div>
    </div>
    <script src="assets/js/jquery-1.10.2.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <script src="assets/js/jquery.metisMenu.js"></script>
    <script src="assets/js/custom-scripts.js"></script>	
</body>
</html>