<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="adminHeader1.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="adminHeader2.jsp"></jsp:include>
	<form action="showVerifyCustomer.action" method="post">
		<table>
			<tr>
				<td>手机号码:<input type="text" name="phoneNumber" /></td>
				<td><input type="submit" name="yanzheng" value="验证" /></td>
			</tr>
		</table>
		<table border="0" cellpadding="0" cellspacing="0" class="table-a">

			<tr>
				<th>手机号码</th>
				<th>消费时间</th>
				<th>消费门店</th>
				<th>等级</th>
				<th>消费特权</th>
			</tr>
			<c:forEach items="${customerExchanges}" var="customer">
				<tr>
					<td>${customer.phoneNumber}</td>
					<td>${customer.registerTime}</td>
					<td>${customer.registerAddress}</td>
					<td>${customer.level}</td>
					<td>减免${customer.price}元特权</td>
				</tr>
			</c:forEach>
		</table>
	</form>
	<input type="hidden" id="header-nav-id" value="header-nav-
setup" />

	<!--内容-->
	<script
		src="../js/jQuery-Validation-Engine-master/js/jquery.validationEngine.js"
		type="text/javascript"></script>
	<script type="text/javascript">
		$("#updatePwdForm").validationEngine({
			scroll : false,
			maxErrorsPerField : 1,
			promptPosition : "centerRight",
			showOneMessage : true
		});
	</script>
	<script src="../js/item.js"></script>

	<!--页脚-->
	<div class="foot">
		<p>版权所有：深圳餐广传媒有限公司 </p>
		<p>地址：深圳市福田区深南中路</p>
	</div>
</body>
</html>
