<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bankBook add page</title>
</head>
<body>
<h1>여기에다가 입력해주세요</h1>

	<form action="./add" method="post">
			
			<input type="text" name="bookName" value="bookName" placeholder="제품명입력"> 
			<input type="text" name="bookRate" value="bookRate"> 
			<input type="text" name="bookSale" value="bookSale">
			<textarea rows="" cols=""  name="bookDetail"></textarea> 
			<button type="submit" value="등록"> 등록 </button>
	</form>	

</body>
</html>