<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전화번호부</title>
</head>
<body>

	<h2>주소록 Web</h2>
	<h3>목록 (검색어: )</h3>
	<form id="search-form">

		<label for="keyword">검색어</label> <input type="text" name="keyword">
		<input type="submit" value="검색">
	</form>
	<c:forEach items="${list }" var="vo" varStatus="status">
		<table id="phonebook" width="640" border="1">
			<tr>
				<th class="col_name">이름</th>
				<th class="col_phone">휴대전화</th>
				<th class="col_phone">전화번호</th>
				<th class="col_toolbar">도구</th>
			</tr>
			<tr>
				<td>${vo.name}</td>
				<td>${vo.hp}</td>
				<td>${vo.tel }</td>
				<td>
					<form method="POST" action="/phonebook/delete">
						<input type="hidden" name="id" value="${vo.id}">
						<button type="submit">삭제</button>
					</form>
				</td>
			</tr>
		</table>
	</c:forEach>

	<p>
		<a href="<c:url value = "/addform" />">새 주소 추가</a>
</body>
</html>