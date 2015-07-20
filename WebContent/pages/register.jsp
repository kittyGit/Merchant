<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="餐广传媒-商家后台" />
<meta name="description"
	content="餐广传媒(www.heshidai.com)-网络投资专业首选,是国内首批由第三方做资金托管账户的P2P网络金融平台,提供网络借贷、小额贷款等线上投资理财,方便快捷,高收益低风险,100%本金利息担保." />
<title>餐广传媒-商家后台</title>
<link href="https://www.heshidai.com/favicon.ico" type="image/x-icon"
	rel="shortcut icon" />
<link rel="stylesheet" type="text/css" href="${context}/css/common.css" />
<link type="text/css" href="${context}/css/merchants-20141110002.css"
	rel="stylesheet" />
<script src="${context}/js/jquery-1.11.1.min.js" type="text/javascript"></script>
<script src="${context}/js/js-merchants-201410300501.js"
	type="text/javascript"></script>
</head>

<body>
	<!--[if lte IE 7]>
<p class="ie6_7">您现在使用的浏览器版本过低，可能会导致浏览效果和信息的缺失。 建议立即安装 <a href="http://www.firefox.com.cn/" target="_blank">Firefox火狐浏览器</a> 或 <a href="http://dlsw.baidu.com/sw-search-sp/soft/9d/14744/ChromeStandaloneSetup.1416972703.exe" target="_blank">谷歌浏览器</a>，安全更放心！ </p>
<![endif]-->

	<!--顶部-->
	<div class="top">
		<div class="top-content">
			<div class="top-left">
				<a href="http://www.heshidai.com">餐广传媒-为您创造更多价值！</a>
			</div>
			<div class="top-right">
				欢迎你，<a href="#">请登录</a>
			</div>
			<!--<div class="top-right">你好，<span>嘉旺餐饮</span>|<a href="#">退出</a></div>-->
		</div>
	</div>

	<!--页头-->
	<div class="header">
		<div class="header-content">
			<div class="logo">
				<img src="${context}/images/logo.png" width="222" height="40"
					alt="餐广传媒-商家后台" title="餐广传媒-商家后台" />
			</div>
			<ul class="nav-box">

			</ul>
		</div>
	</div>
	<!--内容-->

	<div class="login">
		<form action="register.action" id="loginform" method="post">
			<input type="hidden" name="merchantCode" value="${merchantCode}" />
			<input type="hidden" name="storeCode" value="${storeCode}" />
			<div class="username">
				<input type="text" id="username" name="customerName"
					placeholder="用户名" class="input-name" maxlength="20" value=""
					tabindex="1" />
			</div>
			<div class="phoneNumber">
				<input type="text" id="phoneNumber" name="phoneNumber"
					placeholder="手机号码" class="input-name" maxlength="20" value=""
					tabindex="2" />
			</div>
			<div class="pswd">
				<input class="input-password" type="password" id="login_password"
					autocomplete="off" name="customerPwd" placeholder="密码"
					maxlength="20" value="" tabindex="3" />
			</div>
			<div class="vCode">
				<input type="text" id="vCode" name="vCode" placeholder="手机验证码"
					class="input-vCode" maxlength="20" value="" tabindex="4" />
			</div>
			<div class="sendVcode">
				<span tabindex="5" onclick="javascript:sendVcode();" id="a_sendVcode" class="btn_vcode">获取手机验证码</span>
			</div>
			<input id="loginbtn" class="login-button" value="注册" type="submit"
				tabindex="6" />
			<div class="login-ts">
				<p>您输入的账户或密码有误，请重新输入！</p>
			</div>

		</form>

	</div>

	<!--页脚-->
	<div class="foot">
		<p>版权所有：深圳餐广传媒金融服务有限公司</p>
		<p>地址：深圳市福田区深南中路</p>
	</div>


	<script src="${context}/js/layer-master/layer.min.js"
		type="text/javascript"></script>
	<script type="text/javascript" src="${context}/js/jquery.cookie.js"></script>
	<script type="text/javascript">
		//检查是否勾选记住账号并刷新cookie
		function checkRemember_login() {
			var remember_checked = document.getElementById("rememberUserName").checked;
			if (remember_checked) {
				Set_Cookie("username", $("#username").val(), 10, "/", "", "");
			} else {
				Set_Cookie("username", "", 10, "/", "", "");
			}
			Set_Cookie("rememberUserName", remember_checked, 10, "/", "", "");
		}

		// 写入cookie
		function Set_Cookie(name, value, expires, path, domain, secure) {
			var today = new Date();
			today.setTime(today.getTime());
			if (expires) {
				expires = expires * 1000 * 60 * 60 * 24;
			}
			var expires_date = new Date(today.getTime() + (expires));
			document.cookie = name
					+ "="
					+ escape(value)
					+ ((expires) ? ";expires=" + expires_date.toGMTString()
							: "") + ((path) ? ";path=" + path : "")
					+ ((domain) ? ";domain=" + domain : "")
					+ ((secure) ? ";secure" : "");
		}

		var alertFlag = true;
		$("#forgetPwd").click(function() {
			alertFlag = false;
			//layer.alert('请与餐广传媒工作人员联系，谢谢！', 9);
			layer.alert('请与餐广传媒工作人员联系，谢谢！', 9, function() {
				layer.closeAll();
				alertFlag = true;
				$("#login_password").focus();
			});
		});

		$("#loginbtn").click(
				function() {
					if ($("#username").val() == ""
							|| $("#username").val() == null) {
						$(".login-ts").html("用户名不能为空");
					} else if ($("#login_password").val() == ""
							|| $("#login_password").val() == null) {
						$(".login-ts").html("密码不能为空");
					} else {
						checkRemember_login();
						$("#loginform").submit();
					}
				});
		$("body").bind(
				'keyup',
				function(event) {
					if (event.keyCode == 13) {
						if (alertFlag == true) {
							if ($("#username").val() == ""
									|| $("#username").val() == null) {
								$(".login-ts").html("用户名不能为空");
							} else if ($("#login_password").val() == ""
									|| $("#login_password").val() == null) {
								$(".login-ts").html("密码不能为空");
							} else {
								checkRemember_login();
								$("#loginform").submit();
							}
						} else {
							layer.closeAll();
							alertFlag = true;
							$("#login_password").focus();
						}
					}
				});

		$("#indexbtn").click(function() {
			window.location.href = "/coupon/coupon_order_index.action";
		});

		$(document).ready(function() {
			// 复选 框及cookie处理
			var remember_checked = $.cookie("rememberUserName");
			if (remember_checked == "true") {
				$("#rememberUserName").attr("checked", remember_checked);
			}
			var cookieValue = $.cookie("username");
			if (remember_checked && cookieValue != null && cookieValue != "") {
				$("#username").focus().val(cookieValue);
			}

		});
	</script>



	<script type="text/javascript">
		$.ajax({
			type : "POST",
			url : "/coupon/coupon_order_notice.action",
			async : false,
			dataType : 'json',
			success : function(msg) {
				if (msg.length > 0) {
					var allmsg = "";
					for (var i = 0; i < msg.length; i++) {
						allmsg += (i + 1) + "、" + msg[i].message + "<br/>";
					}
					$.layer({
						type : 0,
						shade : [ 0.5, '#000' ],
						fix : false,
						title : '系统通知',
						maxmin : true,
						dialog : {
							type : -1,
							msg : allmsg
						},
						area : [ '462px', 'auto' ]
					});
				}

			}
		});
	</script>


</body>
</html>