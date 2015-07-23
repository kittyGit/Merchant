<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="editPwd.action" method="post">
		<input type="hidden" name="merchantId" value="${merchantId}" />
		<table>
			<tr>
				<td>原密码:<input type="password" name="oldPwd" /></td>
				<td>新密码:<input type="password" name="newPwd" /> </td>
				<td>确认密码:<input type="password" name="confirmPwd" /></td><tr>
				<td><input type="submit" name="submit" value="提交" /></td>
			</tr>
		</table>
	</form>
</body>
</html>