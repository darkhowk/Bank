<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
/* input.button {
	background: url(view/atm/img/확인.png) no-repeat;
	border: none;
	width: 165px;
	height: 58px;
	cursor: pointer;
} */
</style>
</head>
<body>
	<form action="Index.jsp">
		<%
			String account = request.getParameter("accountno");
			String money = request.getParameter("outputmoney");
		%>
		<table border="1">
			<tr>
				<td>계좌번호</td>
				<td><%=account%></td>
			</tr>
			<tr>
				<td>입금 금액</td>
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
					<input type="submit" value="확인" class="button">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>