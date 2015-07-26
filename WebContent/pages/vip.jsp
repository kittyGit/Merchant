<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta name="keywords" content="合时代-商家后台" />
<meta name="description"
	content="合时代(www.heshidai.com)-网络投资专业首选,是国内首批

由第三方做资金托管账户的P2P网络金融平台,提供网络借贷、小额贷款等线上

投资理财,方便快捷,高收益低风险,100%本金利息担保." />
<meta http-equiv="Cache-Control" content="no-store" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<title>餐广传媒-商家后台-会员</title>
<link href="https://www.heshidai.com/favicon.ico" type="image/x-icon"
	rel="shortcut icon" />
<link rel="stylesheet" type="text/css" href="../css/common.css" />
<link type="text/css" href="../css/merchants-20141224001024.css"
	rel="stylesheet" />
<link type="text/css"
	href="../js/jquery-ui-1.11.2.custom/jquery-

ui.css" rel="stylesheet" />
<link href="../js/jquery-treetable-master/css/jquery.treetable.css"
	rel="stylesheet" type="text/css" />
<link
	href="../js/jquery-treetable-

master/css/jquery.treetable.theme.default.css"
	rel="stylesheet" type="text/css" />
<script src="../js/jquery-1.11.1.min.js" type="text/javascript"></script>
<script src="../js/select.js"></script>
<script src="../js/js-merchants-20141113008.js" type="text/javascript"></script>
<script src="../js/pagination-20141119001.js" type="text/javascript"></script>
</head>
<body>
	<jsp:include page="adminHeader.jsp"></jsp:include>
	<form action="showVip.action" method="post">
		<table>
			<tr>
				<td>手机号码:<input type="text" name="phoneNumber" /></td>
				<td>消费门店:<input type="text" name="registerAddress" /></td>
				<td>注册时间:<input type="text" name="registerTimeStart" />至<input
					type="text" name="registerTimeEnd" /></td>
				<td><input type="submit" name="query" value="查詢" /></td>
				<!--  <td><input type="submit" name="download" value="下載" /></td>-->
			</tr>
		</table>
	</form>
	<table border="0" cellpadding="0" cellspacing="0" class="table-a">
		<tr>
			<th>手机号码</th>
			<th>消费门店</th>
			<th>注册时间</th>
			<th>等级</th>
		</tr>
	</table>
	<c:forEach items="${customerVips}" var="customer">
		<tr>
			<td>${customer.phoneNumber}</td>
			<td>${customer.registerAddress}</td>
			<td>${customer.registerTime}</td>
			<td>${customer.registerTime}</td>
			<td>${customer.price}</td>
		</tr>
	</c:forEach>
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
		<p>版权所有：深圳餐广传媒有限公司</p>
		<p>地址：深圳市福田区深南中路</p>
	</div>

</body>
</html>