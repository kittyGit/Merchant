<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!doctype html>
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${context}/css/common.css">
<link rel="stylesheet" href="${context}/css/main.css">
<script type="text/javascript" src="${context}/js/jquery.min.js"></script>
<script type="text/javascript"
	src="${context}/js/colResizable-1.3.min.js"></script>
<script type="text/javascript" src="${context}/js/common.js"></script>

<script type="text/javascript">
	$(function() {
		$(".list_table").colResizable({
			liveDrag : true,
			gripInnerHtml : "<div class='grip'></div>",
			draggingClass : "dragging",
			minWidth : 30
		});

	});
	//页面加载完 执行ready（） 
	$(document).ready(function() {
		$("#frist").click(function(e) {

			e.preventDefault();

			$("#pageNo").val("1");
			$("#perPageSize").val("5");
			$("#showExchangeForm").submit();
		});
		$("#perv").click(function(e) {

			e.preventDefault();

			var pageNo = parseInt($("#pageNo").val());

			var prevPageNo;
			if (pageNo > 1) {
				prevPageNo = pageNo - 1;
			} else {
				prevPageNo = pageNo;
			}

			$("#pageNo").val(prevPageNo);
			$("#perPageSize").val("5");
			$("#showExchangeForm").submit();
		});
		$("#next").click(function(e) {

			e.preventDefault();

			var pageNo = parseInt($("#pageNo").val());
			var pageSize = $("#pageSizeId").val();
			//如果当前是最后一页，下一页就是最后一页
			var nextPage;
			if (pageNo == pageSize) {
				nextPage = pageSize;
			} else {
				nextPage = pageNo + 1;
			}
			$("#pageNo").val(nextPage);
			$("#perPageSize").val("5");
			$("#showExchangeForm").submit();
		});
		$("#last").click(function(e) {

			e.preventDefault();
			var pageSize = $("#pageSizeId").val();
			$("#pageNo").val(pageSize);
			$("#perPageSize").val("5");
			$("#showExchangeForm").submit();
		});
	});
</script>
<title>交易页面</title>
</head>
<body>
	<form action="showExchange.action" id="showExchangeForm" method="post">
		<input type="hidden" id="pageNo" name="pageNo"
			value="${pageNo == null ? 1 : pageNo}" /> <input type="hidden"
			id="perPageSize" name="perPageSize" value="5" /> <input
			type="hidden" id="pageSizeId" name="pageSize" value="${pageSize}" />
		<table class="form_table" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td>手机号码:<input type="text" name="phoneNumber"
					class="input-text lh25" size="15" /></td>
				<td>消费门店:<input type="text" name="registerAddress"
					class="input-text lh25" size="15" /></td>
				<td>注册时间:<input type="text" name="registerTimeStart"
					class="input-text lh25" size="10" />至:<input type="text"
					name="registerTimeEnd" class="input-text lh25" size="10" /></td>
				<td><input type="submit" name="query"
					class="btn btn82 btn_search" value="查询"></td>
				<!--  <td><input type="submit" name="button"
					class="btn btn82 btn_export" value="导出"></td>-->
			</tr>
		</table>
	</form>
	<div id="table" class="mt10">
		<div class="box span10 oh">
			<table width="100%" border="0" cellpadding="0" cellspacing="0"
				class="list_table">
				<tr>
					<th>手机号码</th>
					<th>消费时间</th>
					<th>消费门店</th>
					<th>等级</th>
					<th>消费特权</th>
				</tr>
				<c:forEach items="${customerExchanges}" var="customer">
					<tr>
						<td>${customer.phoneNumber}</td>
						<td>${customer.registerTime}</td>
						<td>${customer.registerAddress}</td>
						<td>${customer.level}</td>
						<td>减免${customer.price}元特权</td>
						<td><select>
								<option value="1"
									<c:if
								test="${customer.couponStatus==1}"></c:if>>已使用
								</option>
								<option value="2"
									<c:if
								test="${customer.couponStatus==2}"></c:if>>未使用
								</option>
						</select></td>
					</tr>
				</c:forEach>
			</table>
			<div class="page mt10">
				<div class="pagination">
					<ul>
						<li id="frist" class="first-child"><a href="#">首页</a></li>
						<li id="perv" class="first-child"><span>上一页</span></li>
						<li id="next"><a href="#">下一页</a></li>
						<li id="last" class="last-child"><a href="#">末页</a></li>
						<li><span>共${pageSize}頁</span></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
