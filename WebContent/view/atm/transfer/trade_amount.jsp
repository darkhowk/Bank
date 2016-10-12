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
	<form method="post" action="transfer.do?transfer=transfer_pw.jsp">

		<input type="hidden" value=${other_user_name } name="other_user_name"> <input type="hidden" value=${other_account_no } name="other_account_no">

		<table border="1">

			<tr>
				<td>상대 계좌번호</td>
				<td>
					<input type="text" name="other_account_no" value="${other_account_no }" readonly="readonly">
				</td>
			</tr>
			<tr>
				<td>이체 금액</td>
				<td>
					<input type="text" name="trade_amount">
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