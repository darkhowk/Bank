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
	<form method="post" action="transfer_other_check.do">

		<table border="1">
			<tr>
				<td>상대방의 계좌번호를 입력해 주세요</td>
				<td valign="top" align="Left">
					<input type="text" name="other_account_no" required="required">
				</td>
			<tr>
				<td align="center">
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