<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>系统管理-修改密码</title>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<link rel="stylesheet" type="text/css" href="${context}/css/edit.css" />
<script src="${context}/js/jquery-all.js" type="text/javascript"></script>
<script src="${context}/js/WdatePicker.js" type="text/javascript"></script>
<script src="${context}/js/util.js" type="text/javascript"></script>
<script type="text/javascript" src="${context}/js/editor.js"></script>
</head>
<body>
	<form action="editPwd.action" method="post" id="formList">
		<div>
			<div class="editorTitle">系统管理-修改密码</div>
			<div class="contentPanel">
				<!-- 编辑内容  BEGIN -->
				<table id="editorTab" cellpadding="0" cellspacing="0" border="0"
					width="600px">
					<tr>
						<td class="tdLabelTitle">旧密码：</td>
						<td><input type="password" name="oldPwd" date-lable="旧密码"
							data-validator="required" maxlength="18" title="旧密码" /></td>
					</tr>
					<tr>
						<td class="tdLabelTitle">新密码：</td>
						<td><input type="password" id="newPaw" name="newPwd"
							date-lable="新密码" data-validator="required" maxlength="18"
							title="新密码" /></td>
					</tr>
					<tr>
						<td class="tdLabelTitle">确认新密码：</td>
						<td><input type="password" id="newPaw2" name="confirmPwd"
							date-lable="确认密码" data-validator="required" maxlength="18"
							title="确认密码" /></td>
					</tr>
					<tr>
						<td colspan="4" style="text-align: center; height: 50px;"><label><s:property
									value="msg" /> </label> <input type="submit" class="upPawBtn"
							value="修改密码" data-url="EditorUserPwd">&nbsp;&nbsp;&nbsp;
							<input type="reset" value="重置"></td>
					</tr>
				</table>
			</div>
		</div>
	</form>
	<script type="text/javascript">
		function upPawVali() {
			var allowSubmit = false;
			if ($("#newPaw").val() != $("#newPaw2").val()) {
				showAlertTip('二次输入的密码不相同请重新输入', {}, $("#newPaw"), 1000);
			} else {
				allowSubmit = queryValidator($(this));
			}
			return allowSubmit;
		}
		$(".upPawBtn").click(upPawVali);
	</script>
</body>
</html>
