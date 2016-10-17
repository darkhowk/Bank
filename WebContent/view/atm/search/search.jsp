<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
history.pushState(null, null, location.href); 
window.onpopstate = function(event) { 
history.go(1); 
}
</script>
</head>
<body>
	<table border="1">
		<caption>거래 목록</caption>
		<tr>
			<th>거래번호</th>
			<th>계좌번호</th>
			<th>거래구분</th>
			<th>거래계좌번호</th>
			<th>거래은행</th>
			<th>거래금액</th>
			<th>메모1</th>
			<th>메모2</th>
			<th>거래장소</th>
			<th>거래시간</th>

		</tr>

		<c:forEach var="brd" items="${list}" varStatus="status">
			<tr>
				<td>${status.count}</td>
				<td>${brd.getAccount_no()}</td>
				<td>${brd.getTrade_gbn()}</td>
				<td>${brd.getTrade_account_no()}</td>
				<td>${brd.getTrade_bank()}</td>
				<td>${brd.getTrade_amount()}</td>
				<td>${brd.getContent1()}</td>
				<td>${brd.getContent2()}</td>
				<td>${brd.getConnect_gbn()}</td>
				<td>${brd.getTrade_datetime()}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>