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
	<form method="post" action="withdraw.do?withdraw=withdraw_pw.jsp">
		
		<table border="1">
	
			<tr>
				<td>출금 금액</td>
				<td>
					<input type="text" name="trade_amount" required="required">
				</td>
			</tr>
			<tr>
				<td >
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