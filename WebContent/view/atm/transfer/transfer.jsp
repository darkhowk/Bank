<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
</style>
</head>
<script>
	history.pushState(null, null, location.href);
	window.onpopstate = function(event) {
		history.go(1);
	}
</script>
<body>
	<table class="input" border="1">
		<tr>
			<td valign="top" align="center" height="80" colspan="2">
				<p>
				<h2>계좌이체</h2>
			</td>
		</tr>

		<tr valign="top" style="WIDTH: 100px">
			<td>
				<a><jsp:include page="${transfer}" /></a>
			</td>

		</tr>
	</table>
</body>
</html>