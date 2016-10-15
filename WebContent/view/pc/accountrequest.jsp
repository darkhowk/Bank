<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html >
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/jquery/1.9.0/jquery.js"></script>
<script type="text/javascript">
	$(function() {
		//전체선택 체크박스 클릭
		$("#allCheck").click(function() {
			//만약 전체 선택 체크박스가 체크된상태일경우
			if ($("#allCheck").prop("checked")) {
				//해당화면에 전체 checkbox들을 체크해준다
				$("input[type=checkbox]").prop("checked", true);
				// 전체선택 체크박스가 해제된 경우
			} else {
				//해당화면에 모든 checkbox들의 체크를해제시킨다.
				$("input[type=checkbox]").prop("checked", false);
			}
		})
	})
</script>
</head>
<body>
	<!-- 테스트를 위해 넣은 버튼 -->
	<button type="button" onclick="location.href = 'accountrequest.do?code=0104'" value="admin">관리자</button>
	<button type="button" onclick="location.href = 'accountrequest.do'" value="user">유저</button>

	<!--  코드가 비어있다면 => 유저라면 -->
	<c:if test="${code eq null }">
		<table border="1">
			<tr>
				<th colspan="6">계좌 개설 신청</th>
			</tr>
			<tr>
				<th>상품번호</th>
				<th>상품명</th>
				<th>출시일</th>
			</tr>
			<c:forEach var="product" items="${product_list }">
				<tr>
					<td>${product.getProduct_no() }</td>
					<td>
						<!--  해당 상품 명을 클릭하면 세부정보로 넘김. -->
						<a href="productselect.do?select=${product.getProduct_no() }">${product.getProduct_name() }</a>
					</td>
					<td>${product.getRelease_date() }</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>

	<!--  코드가 메니저라면 -->
	<c:if test="${code eq 0104 }">
		<form action="accountrequestconfirm.do">
			<table border="1">
				<tr>
					<th colspan="6">계좌 개설 신청 현황</th>
				</tr>
				<tr>
					<th><input type="checkbox" id="allCheck" /></th>
					<th>요청 번호</th>
					<th>고객번호</th>
					<th>상품번호</th>
					<th>신청일자</th>
					<th>접근방법</th>
				</tr>
				<c:forEach var="product" items="${product_list }">
					<tr>
						<td>
							<input type="checkbox" name="checkbox" value="${product.getOpen_no()}" >
						</td>
						<td>${product.getOpen_no() }</td>
						<td>
							<input type="hidden" value="${product.getUser_no() }" name="user_no">${product.getUser_no() }</td>
						<td>
							<input type="hidden" value="${product.getProduct_no() }" name="product_no">${product.getProduct_no() }</td>
						<td>${product.getOpen_datetime() }</td>
						<td>
							<input type="hidden" value="${product.getConnect_gbn() }" name="connect_gbn">${product.getConnect_gbn() }</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="2">
						<input type="submit" value="승인">
					</td>
				</tr>
			</table>
		</form>
	</c:if>
</body>
</html>