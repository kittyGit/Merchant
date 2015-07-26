<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改密码</title>
<script type="text/javascript">
	function delayURL(url, time) {
		setTimeout("top.location.href='" + url + "'", time);
	}
	delayURL("<%=request.getContextPath()%>/admin/loginInput.action", 20000);
</script>
</head>
<body>
	<div>
		<span id="time">3</span> 秒钟之后自动跳转，如果不跳转，请点击下面链接 <a
			href="<%=request.getContextPath()%>/admin/loginInput.action">目标页面</a>
	</div>
</body>
</html>