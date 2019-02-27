<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>中国蓝天航空公司</title>
<link rel="stylesheet" type="text/css" href="css/addUser.css">
</head>
<body>

<div id="header">
	<a href="index.jsp"><img alt="brand" src="img/brand.png"></a>
</div>
<div class="center">
	<h3>快速入会</h3>
	<hr>
	<form action="register.do" method="post">
		<table>
			<tr>
				<td><span style="color:red">*</span>中文姓名</td><td><input type="text" name="userName" required="required"></td>
				<td><span style="color:red">*</span>手机号码</td><td><input type="text" name="tel" required="required" pattern="\d{11}" title="手机号码格式不正确"></td>
			</tr>
			<tr>
				<td><span style="color:red">*</span>证件类型</td>
				<td>
					<select style="width:160px; height:23px" >
						<option>身份证</option>
						<option>护照</option>
						<option>其他</option>					
					</select>
				</td>
				<td><span style="color:red">*</span>证件号码</td>
				<td><input type="text" name="userIDCard" required="required" pattern="\d{15}|(\d{17}(\d|X))" title="证件号码格式不正确"></td>
			</tr>
			<tr>
				<td><span style="color:red">*</span>密码</td><td><input id="pd" type="password" name="password" required="required" pattern="\w{6,16}" title="密码只能是6-16位数字和英文字母"></td>
				<td><span style="color:red">*</span>确认密码</td><td><input id="pdc" type="password" name="passwordConfirm" required="required" onchange="confirm()"></td>
			</tr>
			<tr>
				<td><span style="color:red">*</span>生日</td><td><input type="date" name="birthdate" style="width:155px" required="required"></td>
				<td><span style="color:red">*</span>性别</td>
				<td>
					<input type="radio" name="sex" value="male" checked="checked">男&nbsp;
					<input type="radio" name="sex" value="female">女
				</td>
			</tr>
			<tr>
				
				<td><span style="color:red">*</span>邮箱</td><td><input type="email" name="email" required="required" pattern="\S+@\S+\.\S+" title="邮箱格式不正确"></td>
			</tr>
		</table>
		<input id="treaty" type="checkbox" name="deal" onclick="agree()"><label>已阅读并同意<a href="#">会员条款和隐私政策</a></label><br>
		<input id="bt" type="submit" value="注册" disabled="disabled">
	</form>
	<hr>
	<div id="tip">
		<p>温馨提示：</p>
		<p>1、如使用外国人永久居留身份证，请选择"其他"证件进行入会。</p>
		<p>2、填写的姓名需与所持证件保持一致，否则将影响乘机和积分入账。</p>
	</div>
</div>
</body>
<script type="text/javascript">
	function confirm(){
		var pd1 = document.getElementById("pd").value;
		var pd2 = document.getElementById("pdc").value;
		if(pd1!=pd2){
			alert("两次密码不一致")
		}
	}
	function agree(){
		if(document.getElementById("treaty").checked){
			document.getElementById("bt").disabled=false;
		}else{
			document.getElementById("bt").disabled=true;
		}
	}
</script>
<% 	
	String f = String.valueOf(request.getAttribute("flag")); 
	if(f.equals("no")){%>
		<script type="text/javascript">
			alert("该账号已注册");
		</script>
	<%}
%>
</html>