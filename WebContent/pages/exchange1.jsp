<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="adminHeader1.jsp"></jsp:include>
<script type="text/javascript">
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

</head>
<body>
	<jsp:include page="adminHeader2.jsp"></jsp:include>
	<form action="showExchange.action" id="showExchangeForm" method="post">
		<input type="hidden" id="pageNo" name="pageNo"
			value="${pageNo == null ? 1 : pageNo}" /> <input type="hidden"
			id="perPageSize" name="perPageSize" value="5" /> <input
			type="hidden" id="pageSizeId" name="pageSize" value="${pageSize}" />
		<table>
			<tr>
				<td>手机号码:<input type="text" name="phoneNumber" /></td>
				<td>消费门店:<input type="text" name="registerAddress" /></td>
				<td>注册时间:<input type="text" name="registerTimeStart" />至<input
					type="text" name="registerTimeEnd" /></td>
				<td><input type="submit" name="query" value="查詢" /></td>
				<!--  <td><input type="submit" name="download" value="下載" /></td>-->
			</tr>
		</table>
	</form>
	<table border="0" cellpadding="0" cellspacing="0" class="table-a">
		<tr>
			<th>手机号码</th>
			<th>消费门店</th>
			<th>注册时间</th>
			<th>消费特权</th>
			<th>使用状态</th>
		</tr>

		<c:forEach items="${customerExchanges}" var="customer">
			<tr>
				<td>${customer.phoneNumber}</td>
				<td>${customer.registerAddress}</td>
				<td>${customer.registerTime}</td>
				<td>减免${customer.price}元特权</td>
				<td><select>
						<option value="1" <c:if
								test="${customer.couponStatus==1}"></c:if>>已使用
						</option>
						<option value="2" <c:if
								test="${customer.couponStatus==2}"></c:if>>未使用
						</option>
				</select></td>
			</tr>


		</c:forEach>
	</table>

	<a id="frist" href="">首页</a>
	<a id="perv" href="">上一頁</a>
	<a id="next" href="">下一頁</a>
	<a id="last" href="">末页</a>
	<span>共${pageSize}頁</span>

	<input type="hidden" id="header-nav-id" value="header-nav-
setup" />

	<!--内容-->
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
		<p>版权所有：深圳餐广传媒有限公司</p>
		<p>地址：深圳市福田区深南中路</p>
	</div>

</body>
</html>