<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="showMerchant.action" method="post">
		<table>
			<tr>
				<td>店名：<input type="text" name="name" /></td>
				<td>地址：<input type="text" name="address" /></td>
				<td>联系电话：<input type="text" name="phoneNumber" /></td>
				<td>是否使用优惠券：<input id="checked" type="radio" name="coupon" />是 <input
					id="checked" type="radio" name="coupon" />否
				</td>
				<td>优惠价格：<input type="text" name="price" /></td>
				<td>创建者：<input type="text" name="creator" /></td>
				<td><input type="submit" value="提交" /></td>
			</tr>
		</table>

	</form>
</body>
</html>