<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
input.button {
	background: url(img/확인.png) no-repeat;
	border: none;
	width: 165px;
	height: 58px;
	cursor: pointer;
}
</style>
</head>
<body>
	<form name="inputaccount" method="post" action="Index.jsp?select=input/input.jsp&input=inputmoney.jsp">
		<table>
			<tr align="top" style="WIDTH: 100px">
				<td>계좌번호를 입력해 주세요</td>
				<td valign="top" align="Left">
					<input type="text" name="accountno" required="required">
				</td>
			</tr>
			<tr>
				<td align="center" colspan="2">
					<input type="submit" value="" class="button">
				</td>
			</tr>
		</table>
	</form>
</body>

</html>