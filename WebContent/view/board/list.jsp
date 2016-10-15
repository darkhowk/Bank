<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 테스트를 위해 넣은 버튼 -->
	<button type="button" onclick="location.href = 'list.do?user_code=0104'" value="admin">관리자</button>
	<button type="button" onclick="location.href = 'list.do?user_code=0103'" value="user">유저</button>
	<table border="1">

		<tr>
			<th>번호</th>
			<th>구분</th>
			<th>제목</th>
			<th>작성자</th>
			<th>내용</th>
			<th>이벤트 시작일</th>
			<th>이벤트 종료일</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>

		<c:forEach var="board" items="${list }">
			<tr>
				<td>${board.getBoard_no() }</td>
				<td>${board.getBoard_gbn() }</td>
				<td>
					<a href="modify.do?board_no=${board.getBoard_no() }&user_code=${user_code}">${board.getTitle() }</a>
				</td>
				<td>${board.getUser_id() }</td>
				<td>${board.getContent() }</td>
				<td>${board.getStart_date() }</td>
				<td>${board.getEnd_date() }</td>
				<td>${board.getReg_date() }</td>
				<td>${board.getRead_count() }</td>
			<tr>
		</c:forEach>
		<c:if test="${user_code eq 0104 }">
			<tr>
				<td>
					<a href="modify.do?user_code=${user_code }">쓰기</a>
				</td>
			</tr>
		</c:if>

	</table>
</body>
</html>

