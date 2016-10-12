<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style type="text/css">
/* body {
	BACKGROUND-COLOR: black;
}

input.button {
	background: url(view/atm/img/확인.png) no-repeat;
	border: none;
	width: 165px;
	height: 58px;
	cursor: pointer;
}
table{
background : ;
}
 */
</style>
<body>
	<form name="account" method="post" action="account_no_check.do">
		<table  border="1">
			<tr>
				<td valign="top" align="center" colspan="3">
					<p>
					<h2>삼조은행에 오신것을 환영합니다.</h2>
				</td>
			</tr>
			<tr style="WIDTH: 100px">
				<td align="center" colspan="3">
					계좌번호를 입력해 주세요 <input type="text" name="account_no" required="required">
				</td>
			</tr>
			<tr>
				<td align="center" colspan="2">
					<input type="submit" value="확인" class="button">
				</td>
				<td align="center">
					<a href="exit.do">종료<img src=""></a>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>