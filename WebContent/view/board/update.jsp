<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="update.do" method="post">
		<c:if test="${user_code eq 0104 }">
			<input type="hidden" name="user_code" value="${user_code }">
			<table border="1">
				<tr>
					<td>구분</td>
					<td>
						<input type="text" name="board_gbn" required="required">
					</td>
				</tr>
				<tr>
					<td>제목</td>
					<td>
						<input type="text" name="title" required="required">
					</td>
				</tr>
				<tr>
					<td>내용</td>
					<td>
						<input type="text" name="content" required="required">
					</td>
				</tr>
				<tr>
					<td>이벤트시작일</td>
					<td>
						<input type="date" name="start_date" required="required">
					</td>
				</tr>
				<tr>
					<td>이벤트종료일</td>
					<td>
						<input type="date" name="end_date" required="required">
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="확인">
					</td>
				</tr>
			</table>

		</c:if>



		<c:if test="${user_code ne 0104} ">
			<c:forEach var="board" items="${board }">

				<input type="hidden" name="board_no" value="${board_no }">
				<table border="1">
					<tr>
						<td>구분</td>
						<td>
							<input type="text" name="board_gbn" value="${board.getBoard_gbn() }" required="required">
						</td>
					</tr>
					<tr>
						<td>제목</td>
						<td>
							<input type="text" name="title" value="${board.getTitle() }" required="required">
						</td>
					</tr>
					<tr>
						<td>내용</td>
						<td>
							<input type="text" name="content" value="${board.getContent()} " required="required">
						</td>
					</tr>
					<tr>
						<td>이벤트시작일</td>
						<td>
							<input type="date" name="start_date" value="${board.getStart_date()}" required="required">
						</td>
					</tr>
					<tr>
						<td>이벤트종료일</td>
						<td>
							<input type="date" name="end_date" value="${board.getEnd_date()}" required="required">
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="확인">
						</td>
					</tr>
				</table>

			</c:forEach>
		</c:if>
	</form>

</body>
</html>