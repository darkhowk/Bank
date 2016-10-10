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
	<form name="outputmoney" method="post" action="Index.jsp?select=output/output.jsp&output=outputcheck.jsp">
		<%
			String account = request.getParameter("accountno");
			String money = request.getParameter("outputmoney");
		%>
		<table border="1">
			<tr>
				<td>계좌번호</td>
				<td>
					<input type="text" name="accountno" value="<%=account%>" readonly="readonly">
				</td>
			</tr>
			<tr>
				<td>
					<input type="text" name="outputmoney" value="<%=money%>" readonly="readonly" hidden="hidden">
				</td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td>
					<input type="text" name="outputpassword">
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