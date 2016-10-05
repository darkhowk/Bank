<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.input {
  BACKGROUND-COLOR: black;
}
</style>

<%
  String trans = request.getParameter("trans");

  if (trans == null || trans == "") {
	  trans = "transaccount.jsp";
  } else
%>
</head>
<body>
  <table class="input" width="533" height="350" background="img/패드배경.png">
    <tr>
      <td valign="top" align="center" height="80" colspan="2">
        <p>
        <h2>계좌이체</h2>
      </td>
    </tr>

    <tr valign="top" style="WIDTH: 100px">
      <td>
        <a><jsp:include page="<%=trans%>" /></a>
      </td>

    </tr>
  </table>
</body>
</html>