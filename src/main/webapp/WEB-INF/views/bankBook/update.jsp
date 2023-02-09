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
	<form action="./update" method="post">
	<fieldset>
	<legend>상품이름</legend>
			<input type="hidden" name="bookNumber" readonly="readonly" value="${dto.bookNumber}">
			<input type="text" name="bookName" value="${dto.bookName}" placeholder="제품명입력"> 
    </fieldset>
    <fieldset>
    <legend>상품할인율</legend>
			<input type="text" name="bookRate" value="${dto.bookRate}"> 
	</fieldset>		
	<fieldset>
	<legend>상품판매여부</legend>
		<!-- <input type="text" name="bookSale" value="${dto.bookSale}"> -->
		<label for="bs1">판매</label>
			<input id="bs1" type="radio" ${dto.bookSale eq '1' ? 'selected':''} checked="checked"  name="bookSale" value="1">
		<label for="bs2">판매중단</label>
			<input id="bs2" type="radio" ${dto.bookSale eq '0' ? 'selected':''} name="bookSale" value="0">
	</fieldset>		
	<fieldset>
	<legend>상품설명</legend>
			<textarea rows="" cols=""  name="bookDetail">${dto.bookDetail}</textarea> 
	</fieldset>	
	<fieldset>	
			<input type="submit" value="수정">
			<button type="submit"> 수정 </button>
	</fieldset>		
			
	</form>
	
</body>
</html>