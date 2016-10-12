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
}

body {
	BACKGROUND-COLOR: black;
} */
</style>
</head>
<body>

	<form action="mainview.do">
		<table border="1">

			<tr valign="top">
				<td>계좌번호</td>
				<td>:</td>
				<td colspan="2">${account_no}</td>
			</tr>
			<tr>
				<td>입금금액</td>
				<td>:</td>
				<td>${trade_amount}</td><td>원</td>
			</tr>
			<tr>

				<td>잔 액</td>
				<td>:</td>
				<td>${balance }</td><td>원</td>
			</tr>
			<tr>
				<td colspan="4" align="center">
					<input type="submit" value="확인" class="button">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>