<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>bankBooklistpage</h1>

<table> 
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
		<td> ${pageScope.dto.bookName} </td>
		<td> ${pageScope.dto.bookRate} </td>
		<td> ${pageScope.dto.bookSale}</td>
	</tr>
	</c:forEach>

	</tbody>
</table>
</body>
</html>