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
}

body {
	BACKGROUND-COLOR: black;
} */
</style>
</head>
<body>

	<form action="Index.jsp">
		<table border="1">
			
			<tr valign="top">
				<td>계좌번호 : ${accountno}</td>
			</tr>
			<tr>
				<td>입금금액 :${inputmoney}</td>
			</tr>
			<tr>
				<td>잔　　액 : ${balance }</td>
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