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
	<form name="transpasswrod" method="post" action="Index.jsp?select=trans/trans.jsp&trans=transcheck.jsp">
		<%
			String myaccount = request.getParameter("myaccountno");
			String otheraccount = request.getParameter("otheraccountno");
			String transmoney = request.getParameter("transmoney");
		%>
		<table>
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
				<td>이체 금액</td>
				<td>
					<input type="text" name="transmoney" value="<%=transmoney%>" readonly="readonly">
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
					<input type="submit" value="" class="button">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>