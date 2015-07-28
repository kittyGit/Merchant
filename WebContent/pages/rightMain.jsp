<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 交易页面 -->
	<div class="main">
		<iframe name="right" id="rightMain"
			src="${context}/pages/exchange.jsp" frameborder="no" scrolling="auto"
			width="100%" height="auto" allowtransparency="true"></iframe>
	</div>
	<!-- 会员页面 -->
	<div class="main">
		<iframe name="right" id="rightMain"
			src="${context}/pages/vip.jsp" frameborder="no" scrolling="auto"
			width="100%" height="auto" allowtransparency="true"></iframe>
	</div>
</body>
</html>