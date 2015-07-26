<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--顶部-->
<div class="top">
	<div class="top-content">
		<div class="top-left">
			<a href="http://www.heshidai.com/">餐 广传媒欢迎你</a>
		</div>
		<div class="top-right">
			<a
				href="<%=request.getContextPath()%>/admin/editPwdInput.action?merchantId=${merchantId}">修改密码</a><a
				href="http://merchant.heshidai.com/logout.action">退出</a>
		</div>
	</div>
</div>
<!--页头-->

<div class="header">
	<div class="header-content">
		<div class="logo">
			<img src="../images/logo.png" width="222" height="40" alt="餐广传媒-商家后台"
				title="餐广传媒-商家后台" />
		</div>
		<ul class="nav-box">

			<c:if test="${sessionScope.admin.merchant == null}">
				<li id="header"><a
					href="<%=request.getContextPath()%>/merchant/manageMerchant.action">商家管理</a></li>
			</c:if>
			<li id="header"><a
				href="<%=request.getContextPath()%>/admin/vipCustomer.action">会员</a></li>
			<li id="header"><a
				href="<%=request.getContextPath()%>/admin/customerExchange.action">交易</a></li>
			<li id="header"><a
				href="<%=request.getContextPath()%>/admin/verify.action">首页</a></li>
		</ul>
	</div>
</div>
