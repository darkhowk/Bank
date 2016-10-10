<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

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
	<form name="transmoney" method="post" action="Index.jsp?select=trans/trans.jsp&trans=transpassword.jsp">
		<%
			String myaccount = request.getParameter("myaccountno");
			String otheraccount = request.getParameter("otheraccountno");
		%>
		<table border="1">
			<tr>
				<td>내 계좌번호</td>
				<td>
					<input type="text" name="myaccountno" value="<%=myaccount%>" readonly="readonly">
				</td>
			</tr>
			<tr>
				<td>상대 계좌번호</td>
				<td>
					<input type="text" name="otheraccountno" value="<%=otheraccount%>" readonly="readonly">
				</td>
			</tr>
			<tr>
				<td>출금 금액</td>
				<td>
					<input type="text" name="transmoney">
				</td>
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