<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta name="keywords" content="合时代-商家后台" />
<meta name="description"
	content="合时代(www.heshidai.com)-网络投资专业首选,是国内首批由第三方做资金托管账户的P2P网络金融平台,提供网络借贷、小额贷款等线上投资理财,方便快捷,高收益低风险,100%本金利息担保." />
<meta http-equiv="Cache-Control" content="no-store" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<title>餐广传媒-商家后台-首页</title>
<link href="https://www.heshidai.com/favicon.ico" type="image/x-icon"
	rel="shortcut icon" />
<link rel="stylesheet" type="text/css" href="../css/common.css" />
<link type="text/css" href="../css/merchants-20141224001024.css"
	rel="stylesheet" />
<link type="text/css" href="../js/jquery-ui-1.11.2.custom/jquery-ui.css"
	rel="stylesheet" />
<link href="../js/jquery-treetable-master/css/jquery.treetable.css"
	rel="stylesheet" type="text/css" />
<link
	href="../js/jquery-treetable-master/css/jquery.treetable.theme.default.css"
	rel="stylesheet" type="text/css" />
<script src="../js/jquery-1.11.1.min.js" type="text/javascript"></script>
<script src="../js/select.js"></script>
<script src="../js/js-merchants-20141113008.js" type="text/javascript"></script>
<script src="../js/pagination-20141119001.js" type="text/javascript"></script>

</head>
<body>
	<!--顶部-->
	<div class="top">
		<div class="top-content">
			<div class="top-left">
				<a href="http://www.heshidai.com/">餐广传媒欢迎你</a>
			</div>
		</div>
	</div>
	<!--页头-->


	<div class="header">
		<div class="header-content">
			<div class="logo">
				<img src="../images/logo.png" width="222" height="40"
					alt="餐广传媒-商家后台" title="餐广传媒-商家后台" />
				<div>欢迎注册</div>
			</div>
		</div>
	</div>

	<link rel="stylesheet"
		href="../js/jQuery-Validation-Engine-master/css/validationEngine.jquery.css">
	<input type="hidden" id="header-nav-id" value="header-nav-setup" />

	<!--内容-->
	<div class="content-box">
		<div class="merchants-content">
			<form id="updatePwdForm" name="form1" action="register.action" method="post">
				<center>
					<h1></h1>
				</center>
				<table class="query-table" cellpadding="0" cellspacing="0"
					border="0">
					<tr>
						<td align="right" width="35%"><label for="customerName">用户名：</label></td>
						<td width="65%"><input type="text" id="customerName"
							name="customerName" /></td>
					</tr>
					<tr>
						<td align="right"><label for="customerName">手机号：</label></td>
						<td width="65%"><input type="text" id="customerPhoneNumber"
							name="customerPhoneNumber"
							class="validate[required,minSize[4],maxSize[20]] text-input" /></td>
					</tr>
					<tr>
						<td align="right"><label for="password">密码：</label></td>
						<td><input type="password" id="customerPwd"
							name="customerPwd" /></td>
					</tr>
					<tr>
						<td align="right"><label for="comfirmpassword">确认密码：</label></td>
						<td><input type="password" id="ConfirmPwd" name="confirmPwd" /></td>
					</tr>
					<tr>
						<td align="right"><label for="comfirmpassword">手机获取验证码：</label></td>
						<td><input type="password" id="isValidated" name="isValidated" /></td>
					</tr>
					<tr>
						<td align="right"></td>
						<td><input type="reset" class="button_tj" value="重置" /><input
							type="submit" value="提交" class="button_tj" /></td>
					</tr>
				</table>
			</form>
		</div>
	</div>


	<script
		src="../js/jQuery-Validation-Engine-master/js/languages/jquery.validationEngine-zh_CN-20141106003.js"
		type="text/javascript"></script>
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
		<p>版权所有：深圳餐广传媒有限公司 Heshidai.com 粤ICP备13059473号</p>
		<p>地址：深圳市福田区深南中路</p>
	</div>

</body>
</html>