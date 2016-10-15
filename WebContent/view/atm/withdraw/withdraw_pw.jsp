<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<form name="outputmoney" method="post" action="withdraw_pw.do">

		<input type="text" value=${trade_amount } name="trade_amount">

		<table border="1">

			<tr>
				<td>비밀번호</td>
				<td>
					<input type="password" name="user_pw">
				</td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="확인" class="button">
				</td>
				<td>
					<a href="mainview.do">거래종료</a>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>