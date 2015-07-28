<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>	
<head>
	<meta charset="UTF-8">
    <link rel="stylesheet" href="${context}/css/login.css">
    <script type="text/javascript" src="${context}/js/jquery.min.js"></script>
	<title>后台登陆</title>
</head>
<body>
	<div id="login_top">
		<div id="welcome">
			欢迎Merchant管理系统
		</div>
	</div>
	<div id="login_center">
		<div id="login_area">
			<div id="login_form">
				<form action="login.action" method="post">
					<div id="login_tip">
						用户登录
					</div>
					<div><input type="text"  name="adminName" class="username" placeholder="用户名"></div>
					<div><input type="password" name="adminPwd" class="pwd"  placeholder="密码"></div>
					<div id="btn_area">
						<input type="submit" name="submit" id="sub_btn" value="登&nbsp;&nbsp;录">&nbsp;&nbsp;
						<!--  <input type="text" class="verify">
						<img src="${context}/images/login/verify.png" alt="" width="80" height="40">-->
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>