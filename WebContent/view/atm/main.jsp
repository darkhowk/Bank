<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
/* body {
	BACKGROUND-COLOR: black;
} */
</style>
</head>
<body>

	<table>
		<tr>

			<td>

				<a><jsp:include page="${select}" /></a>
			</td>

			<td>
				<a><jsp:include page="${menu }" /></a>
			</td>
		
	</table>
</body>
</html>