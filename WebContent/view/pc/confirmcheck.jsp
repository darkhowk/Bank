<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
	<form name="frm">

		<input type="hidden" name="count" value="${count }">


	</form>

	<script type="text/javascript">
		alert("총" + document.frm.count.value + "건의 정보를 처리하였습니다.");
		location.href = "accountrequest.do";
	</script>

</body>
</html>