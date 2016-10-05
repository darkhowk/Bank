<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

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
	<form name="inputmoney" method="post" action="Index.jsp?select=input/input.jsp&input=inputcheck.jsp">
		<%
			String account = request.getParameter("accountno");
		%>
		<table>
			<tr>
				<td>계좌번호</td>
				<td>
					<input type="text" value="<%=account%>" name ="inputaccount" readonly="readonly" >
				</td>
			</tr>
			<tr>
				<td>입금 금액</td>
				<td>
					<input type="text" name="inputmoney">
				</td>
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