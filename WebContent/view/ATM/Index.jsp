<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
body {
	BACKGROUND-COLOR: black;
}
</style>

</head>

<%
	String select = request.getParameter("select");

	if (select == null || select == "") {
		select = "notice.jsp";

	} else
%>
<body>
	<table>
		<tr>
			<td>
				<a><jsp:include page="<%=select%>" /></a>
			</td>
			<td>
				<a><jsp:include page="menu.jsp" /></a>
			</td>
		</tr>
	</table>
</body>
</html>