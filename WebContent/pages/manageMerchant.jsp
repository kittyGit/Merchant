<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商家管理平台</title>
</head>
<body>
	<div>

		<form action="addMerchant.action" method="post">
			<table>
				<tr>
					<td>店名：<input type="text" name="name" /></td>
					<td>联系电话：<input type="text" name="phoneNumber" /></td>
					<td>是否使用优惠券：<input id="checked" type="radio" name="coupon" />是
						<input id="checked" type="radio" name="coupon" />否
					</td>
					<td>优惠价格：<input type="text" name="price" /></td>
					<td><input type="submit" value="添加" /></td>
				</tr>
			</table>

		</form>
	</div>

	<div>
		<form action="queryMerchant.action" method="post">
			商家：<input type="text" name="name" /> <input type="submit" value="查询" />
		</form>
	</div>
	<div>
		<table border="1">
			<tr>
				<td>商家</td>
				<td>优惠券</td>
				<td>编码</td>
				<td>添加店面</td>
			</tr>
			<c:forEach items="${merchants}" var="merchant">
				<tr>
					<td>${merchant.merchantName}</td>
					<td>${merchant.hasCoupon}</td>
					<td>${merchant.code}</td>
					<td><a href="addStoreInput.action?merchantId=${merchant.merchantId}">添加店面</a></td>
				</tr>
			</c:forEach>
		</table>

	</div>
</body>
</html>