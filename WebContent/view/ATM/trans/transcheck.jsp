<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
input.button {
	background: url(img/확인.png) no-repeat;
	border: none;
	width: 165px;
	height: 58px;
	cursor: pointer;
}
</style>
</head>
<body>
	<form action="Index.jsp">
		<%
			String myaccountno = request.getParameter("myaccountno");
			String otheraccount = request.getParameter("otheraccountno");
			String money = request.getParameter("transmoney");
		%>
		<table>
			<tr>
				<td>내 계좌번호</td>
				<td><%=myaccountno%></td>
			</tr>
			<tr>
				<td>상대 계좌번호</td>
				<td><%=otheraccount%></td>
			</tr>
			<tr>
				<td>이체 금액</td>
				<td><%=money%></td>
			</tr>
			<tr>
				<td>수수료</td>
				<td>***원</td>
			</tr>
			<tr>
				<td>잔액</td>
				<td>***원</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="" class="button">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>