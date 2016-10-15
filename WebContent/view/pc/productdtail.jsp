<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="accountrequestsubmit.do">
		<table border="1">
			<tr>
				<th colspan="6">계좌 개설 신청</th>
			</tr>
			<tr>
				<th>상품번호</th>
				<th>상품명</th>
				<th>상품설명</th>
				<th>계약기간</th>
				<th>등록일시</th>
				<th>출시일</th>
			</tr>
			<tr>
				<c:forEach var="product" items="${product_list }">
					<input type="hidden" name="product_no" value="${product.getProduct_no() }">
					<td>${product.getProduct_no() }</td>
					<td>${product.getProduct_name() }</td>
					<td>${product.getContent() }</td>
					<td>${product.getContract_period_year() }년</td>
					<td>${product.getReg_datetime() }</td>
					<td>${product.getRelease_date() }</td>
				</c:forEach>
			</tr>
			<tr>
				<td colspan="3" align="center">
					<input type="submit" value="신청">
				</td>
				<td colspan="3" align="center">
					<input type="button" onclick="location.href='accountrequest.do' " value="뒤로">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>