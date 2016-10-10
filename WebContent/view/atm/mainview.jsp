<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
} */
</style>
<body>
	<form name="account" method="post" action="accountnocheck.do">
		<table width="533" height="350" background="" border="1">
			<tr>
				<td valign="top" align="center" colspan="3">
					<p>
					<h2>삼조은행에 오신것을 환영합니다.</h2>
				</td>
			</tr>
			<tr align="top" style="WIDTH: 100px" >
				<td align="center" colspan="3">
					계좌번호를 입력해 주세요 <input type="text" name="accountno" required="required">
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