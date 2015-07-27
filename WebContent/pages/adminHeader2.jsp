<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!--顶部-->
<div class="top">
	<div class="top-content">
		<div class="top-left">
			<a href="http://www.canguang.com/">餐广传媒-为您创造更多价值！</a>
		</div>
		<div class="top-right">
			你好，<span></span><a
				href="${context}/admin/editPwdInput.action?merchantId=${merchantId}">修改密码</a><a
				href="${context}/admin/loginOut.action">退出</a>
		</div>
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
			<c:if test="${sessionScope.admin.merchant == null}">
				<li id="header"><a
					href="${context}/merchant/manageMerchant.action">商家管理</a></li>
			</c:if>

			<li id="header-nav-customer"><a
				href="${context}/admin/vipCustomer.action">会员</a></li>
			<li id="header-nav-couponlist"><a
				href="${context}/admin/customerExchange.action">交易</a></li>
		</ul>
	</div>
</div>

<link rel="stylesheet" href="${context}/css/styles.css">
<input type="hidden" id="header-nav-id" value="header-nav-couponlist" />