<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/common_css.jsp"></c:import>
<link rel="stylesheet" href="../resources/css/table.css">
</head>
<body>
<!-- 서버 내부 주소, 상대 경로  -->
  <c:import url="../template/header.jsp"></c:import>
<h1 class="h11">bankBooklistpage</h1>

<div class="image">
<img 요건 아이유에용" src="../../resources/images/one.jpg">
</div>

<table class="tbl2"> 
	<thead>
		<tr>
		 <th>상품명</th>
		 <th>이자율</th>
		 <th>판매여부</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${list}" var="dto">
	<tr>
		<td><a href="./detail?bookNumber=${dto.bookNumber}"> ${pageScope.dto.bookName}</a> </td>
		<td><a class="tbl2_td"> ${pageScope.dto.bookRate} </a></td>
		<td class="tbl2_td">
		<c:choose>
		<c:when test="${dto.bookSale eq 1}"> 판매중 </c:when>
		<c:otherwise>판매중단</c:otherwise>
		</c:choose>
		 </td>
		<!-- pageScope는 생략가능  -->
	</tr>
	</c:forEach>

	</tbody>
</table>
	<a href="./add">상품등록</a>
</body>
</html>