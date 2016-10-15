<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
</style>
</head>
<body>
	<form method="post" action="deposit_check.do">
		<table border="1">
			<tr>
				<td>입금 금액</td>
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