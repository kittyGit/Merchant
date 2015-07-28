<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!doctype html>
<html lang="zh-CN">
<head>
<link rel="stylesheet" href="${context}/css/common.css">
<link rel="stylesheet" href="${context}/css/style.css">
<script type="text/javascript" src="${context}/js/jquery.min.js"></script>
<script type="text/javascript" src="${context}/js/jquery.SuperSlide.js"></script>
<script type="text/javascript">
	$(function() {
		$(".sideMenu").slide({
			titCell : "h3",
			targetCell : "ul",
			defaultIndex : 0,
			effect : 'slideDown',
			delayTime : '500',
			trigger : 'click',
			triggerTime : '150',
			defaultPlay : true,
			returnDefault : false,
			easing : 'easeInQuint',
			endFun : function() {
				scrollWW();
			}
		});
		$(window).resize(function() {
			scrollWW();
		});
	});
	function scrollWW() {
		if ($(".side").height() < $(".sideMenu").height()) {
			$(".scroll").show();
			var pos = $(".sideMenu ul:visible").position().top - 38;
			$('.sideMenu').animate({
				top : -pos
			});
		} else {
			$(".scroll").hide();
			$('.sideMenu').animate({
				top : 0
			});
			n = 1;
		}
	}

	var n = 1;
	function menuScroll(num) {
		var Scroll = $('.sideMenu');
		var ScrollP = $('.sideMenu').position();
		/*alert(n);
		alert(ScrollP.top);*/
		if (num == 1) {
			Scroll.animate({
				top : ScrollP.top - 38
			});
			n = n + 1;
		} else {
			if (ScrollP.top > -38 && ScrollP.top != 0) {
				ScrollP.top = -38;
			}
			if (ScrollP.top < 0) {
				Scroll.animate({
					top : 38 + ScrollP.top
				});
			} else {
				n = 1;
			}
			if (n > 1) {
				n = n - 1;
			}
		}
	}
</script>
<title>后台首页</title>
</head>
<body>
	<div class="top">
		<div id="top_t">
			<div id="logo" class="fl"></div>
			<div id="photo_info" class="fr">
				<!--  <div id="photo" class="fl">
					<a href="#"><img src="${context}/images/a.png" alt=""
						width="60" height="60"></a>
				</div>-->
				<div class="info_center">
					你好，<span>admin</span>&nbsp;&nbsp;&nbsp;<a
						href="${context}/admin/editPwdInput.action?merchantId=${merchantId}">修改密码</a>&nbsp;&nbsp;&nbsp;&nbsp;<a
						href="${context}/admin/loginOut.action">退出</a>
				</div>
			</div>
		</div>
	</div>
	<div class="side">
		<div class="sideMenu" style="margin: 0 auto">
			<h3>用户管理菜单</h3>
			<ul>
				<li class="on"><a
					href="${context}/admin/customerExchange.action">交易</a></li>
				<li><a href="${context}/admin/vipCustomer.action">会员</a></li>
				<c:if test="${sessionScope.admin.merchant == null}">
					<li id="header"><a
						href="${context}/merchant/manageMerchant.action">商家管理</a></li>
				</c:if>
			</ul>
		</div>
	</div>
	<div class="main">
		<iframe name="right" id="rightMain"
			src="${context}/pages/exchange.jsp" frameborder="no" scrolling="auto"
			width="100%" height="auto" allowtransparency="true"></iframe>
	</div>
	<div class="bottom">
		<div id="bottom_bg">版权</div>
	</div>
	<div class="scroll">
		<a href="javascript:;" class="per" title="使用鼠标滚轴滚动侧栏"
			onclick="menuScroll(1);"></a> <a href="javascript:;" class="next"
			title="使用鼠标滚轴滚动侧栏" onclick="menuScroll(2);"></a>
	</div>
</body>

</html>

