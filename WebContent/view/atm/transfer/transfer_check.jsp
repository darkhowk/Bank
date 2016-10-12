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
	<form action="mainview.do">

		<table border="1">

			<tr>
				<td>상대 계좌번호</td>
				<td>${other_account_no }</td>
			</tr>
			<tr>
				<td>이체 금액</td>
				<td>${trade_amount }</td>
			</tr>
			<tr>
				<td>수수료</td>
				<td>${commission }</td>
			</tr>
			<tr>
				<td>잔액</td>
				<td>${balance }</td>
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