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
				<td valign="top" align="center" height="80" colspan="2">
					<p>
					<h2>삼조은행에 오신것을 환영합니다.</h2>
				</td>
			</tr>
			<tr align="top" style="WIDTH: 100px">
				<td>계좌번호가 틀리거나, 존재하지 않습니다</td>
			</tr>
			<tr>
				<td>가까운 지점에 방문하여 계좌를 개설하시거나, 다시 입력해 주세요.</td>
			</tr>
			<tr>

				<td align="center">
					<a href="mainview.do">확인<img src=""></a>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>