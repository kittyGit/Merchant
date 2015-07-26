<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>餐广传媒-商家后台-首页</title>
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

	<jsp:include page="adminHeader.jsp"></jsp:include>
			<form action="addMerchant.action" method="post">
		<table>
				<tr>
					<td>店名：<input type="text" name="name" /></td>
					<td>联系电话：<input type="text" name="phoneNumber" /></td>
					<td>是否使用优惠券：<input id="checked" type="radio" name="coupon" />是
						<input id="checked" type="radio" name="coupon" />否
					</td>
					<td>优惠价格：<input type="text" name="price" /></td>
					<td><input type="submit" name="add" value="添加" /></td>
				</tr>
			</table>

		</form>

	<div>
		<form action="queryMerchant.action" method="post">
			商家：<input type="text" name="name" /> <input type="submit"  name="query" value="查询" />
		</form>
	</div>
		<table border="0" cellpadding="0" cellspacing="0" class="table-a">
			<tr>
				<td>商家</td>
				<td>优惠特权</td>
				<td>联系方式</td>
				<td>添加店面</td>
			</tr>
			<c:forEach items="${merchants}" var="merchant">
				<tr>
					<td>${merchant.merchantName}</td>
					<td>減免${merchant.price}元优惠</td>
					<td>${merchant.phoneNumber}</td>
					<td><a href="addStoreInput.action?merchantId=${merchant.merchantId}">添加店面</a></td>
				</tr>
			</c:forEach>
		</table>
		
		
		<input type="hidden" id="header-nav-id" value="header-nav-setup" />

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
			<p>版权所有：深圳餐广传媒有限公司 Heshidai.com 粤ICP 备13059473号</p>
			<p>地址：深圳市福田区深南中路</p>
		</div>
</body>
</html>