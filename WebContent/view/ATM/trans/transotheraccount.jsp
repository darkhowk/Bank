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
	<form name="transotheraccount" method="post" action="Index.jsp?select=trans/trans.jsp&trans=transmoney.jsp">
		<%
			String myaccountno = request.getParameter("myaccountno");
		%>
		<table>
			<tr>
				<td>내 계좌번호</td>
				<td>
					<input type="text" name="myaccountno" value="<%=myaccountno%>" readonly="readonly">
				</td>
			</tr>
			<tr>
				<td>상대방의 계좌번호를 입력해 주세요</td>
				<td valign="top" align="Left">
					<input type="text" name="otheraccountno" required="required">
				</td>
			<tr>
				<td align="center" colspan="2">
					<input type="submit" value="" class="button">
				</td>
			</tr>
		</table>
	</form>
</body>

</html>