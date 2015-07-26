<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<html lang="en">
<!--<![endif]-->
<head>
<meta charset=utf-8 />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="餐广传媒-商家后台" />
<meta name="description" content="餐广传媒(www.canguang.com)-餐饮." />

<title>餐广传媒-用户注册</title>

<link href="https://www.canguang.com/favicon.ico" type="image/x-icon"
	rel="shortcut icon" />

<link rel="stylesheet"
	href="http://necolas.github.io/normalize.css/2.1.3/normalize.css">
<link rel="stylesheet"
	href="${context}/js/jq-idealforms/css/jquery.idealforms.css">

<style>
body {
	max-width: 980px;
	margin: 2em auto;
	font: normal 15px/1.5 Arial, sans-serif;
	color: #353535;
	overflow-y: scroll;
}

.content {
	margin: 0 30px;
}

.field.buttons button {
	margin-right: .5em;
}

#invalid {
	display: none;
	float: left;
	width: 290px;
	margin-left: 120px;
	margin-top: .5em;
	color: #CC2A18;
	font-size: 130%;
	font-weight: bold;
}

.idealforms.adaptive #invalid {
	margin-left: 0 !important;
}

.idealforms.adaptive .field.buttons label {
	height: 0;
}

.btn {
	background: #77c4f8 none repeat scroll 0 0;
	border-radius: 1px;
	color: #fff;
	cursor: pointer;
	display: block;
	height: 36px;
	line-height: 36px;
	text-align: center;
	width: 100px;
	margin-top: 5px;
}

.btn img {
	height: 36px;
}
</style>
</head>
<body>

	<div class="content">

		<div class="idealsteps-container">

			<nav class="idealsteps-nav"></nav>

			<form action="" novalidate autocomplete="off" class="idealforms">

				<input type="hidden" name="merchantCode" value="${merchantCode}">
				<input type="hidden" name="storeCode" value="${storeCode}">

				<div class="idealsteps-wrap">

					<!-- Step 1 -->
					<section class="idealsteps-step">

						<div class="field">
							<label class="main">手机号码:</label> <input name="phone" type="text">
							<span class="error"></span>
						</div>

						<div class="field">
							<label class="main">手机验证码:</label>
							<p class="group">
								<input name="phoneCode" type="text"
									data-idealforms-ajax="validatePhoneVerifyCode.action">
								<span class="btn">获取验证码</span> <span class="error"></span>
							</p>
						</div>

						<div class="field">
							<label class="main">验证码:</label>
							<p class="group">
								<input name="captcha" type="text"
									data-idealforms-ajax="validateCaptcha.action"> <span
									class="btn"> <img id="captcha" src="getCaptcha.action"
									alt="验证码">
								</span> <span class="error"></span>
							</p>
						</div>

						<div class="field buttons">
							<label class="main">&nbsp;</label>
							<button type="button" class="next">下一步 &raquo;</button>
						</div>

					</section>

					<!-- Step 2 -->

					<section class="idealsteps-step">

						<div class="field">
							<label class="main">用户名:</label> <input name="customerName"
								type="text"> <span class="error"></span>
						</div>

						<div class="field">
							<label class="main">密码:</label> <input name="customerPwd"
								type="password"> <span class="error"></span>
						</div>

						<div class="field buttons">
							<label class="main">&nbsp;</label>
							<button type="button" class="prev">&laquo; 上一步</button>
							<button type="submit" class="submit">提交</button>
						</div>

					</section>

				</div>

				<span id="invalid"></span>

			</form>

		</div>

	</div>

	<script src="${context}/js/jquery/jquery-2.1.4.js"></script>
	<script src="${context}/js/jquery-ui-1.11.4/jquery-ui.min.js"></script>
	<script src="${context}/js/jq-idealforms/js/out/jquery.idealforms.js"></script>
	<!--<script src="js/out/jquery.idealforms.min.js"></script>-->
	<script>
		$("form.idealforms").idealforms(
				{

					silentLoad : false,

					steps : {
						registerStepsItems : [ "第一步", "第二步" ],
						buildNavItems : function(i) {
							return this.opts.steps.registerStepsItems[i];
						}
					},

					rules : {
						"customerName" : "required",
						"customerPwd" : "required",
						"phoneNumber" : "required",
						"captcha" : "required ajax",
						"
		phoneCode" : "required ajax"
					},

					errors : {
						"customerName" : {
							required : "请输入用户名",
						},
						"customerPwd" : {
							required : "请输入密码"
						},
						"phoneNumber" : {
							required : "请输入电话号码",
						},
						"captcha" : {
							required : "请输入验证码",
							ajax : "检查验证码...",
							ajaxError : "验证码不正确"
						},
						"phoneCode" : {
							required : "请输入手机验证码",
							ajax : "检查手机验证码...",
							ajaxError : "手机验证码不正确"
						}
					},

					onSubmit : function(invalid, e) {

						if (invalid) {
							e.preventDefault();
							$("#invalid").show().toggleClass("valid", !invalid)
									.text(invalid + "个项目未填写正确");
						}
					}
				});

		$("form.idealforms").find("input, select, textarea").on("change keyup",
				function() {
					$("#invalid").hide();
				});

		$(".prev").click(function() {
			$(".prev").show();
			$("form.idealforms").idealforms("prevStep");
		});

		$(".next").click(function() {
			$(".next").show();
			$("form.idealforms").idealforms("nextStep");
		});

		$("#captcha").click(function() {
			$(this).attr("src", "getCaptcha.action?d=" + new Date());
		});
	</script>
</body>
</html>