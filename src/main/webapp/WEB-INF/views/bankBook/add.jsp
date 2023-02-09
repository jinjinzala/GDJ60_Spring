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
		<fieldset>
		 	<legend>상품명</legend>
			<input type="text" name="bookName" value="bookName" placeholder="제품명입력">
		</fieldset> 
		<fieldset>
			<legend>이자율</legend>
			<input type="text" name="bookRate" value="bookRate"> 
		</fieldset> 
		<fieldset>
		<legend>상세정보</legend>
		<textarea rows="" cols=""  name="bookDetail"></textarea> 
		</fieldset>
		<fieldset>	
		<legend>판매여부</legend>
		<label for="bs1">판매</label>
			<input id="bs1" type="radio"  checked="checked"  name="bookSale" value="1">
		<label for="bs2">판매중단</label>
			<input id="bs2" type="radio" name="bookSale" value="0">
		</fieldset>
		<fieldset>
		<legend>판매여부설정</legend>	
			<select name="bookSale">
					<option value="1">판매</option>
					<option seleted value="0">판매중단</option>
			</select> 
		</fieldset>	
			<button type="submit" value="등록"> 등록 </button>
	</form>	

</body>
</html>