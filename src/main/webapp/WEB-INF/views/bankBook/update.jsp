<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bankbook update page</title>
</head>
<body>
	<h1>Update page</h1>
	<from action="./update" method="post">
			<input type="text" name="bookName" value="${dto.bookName}" placeholder="제품명입력"> 
			<input type="text" name="bookRate" value="${dto.bookRate}"> 
			<input type="text" name="bookSale" value="${dto.bookSale}">
			<textarea rows="" cols=""  name="bookDetail">${dto.bookDetail}</textarea> 
			<button type="submit" value="등록"> 수정 </button>
	</from>
	
</body>
</html>