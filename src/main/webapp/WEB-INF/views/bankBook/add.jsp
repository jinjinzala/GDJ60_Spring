<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bankBook add page</title>
<c:import url="../template/common_css.jsp"></c:import>
</head>
<body>
<!-- 서버 내부 주소, 상대 경로  -->
  <c:import url="../template/header.jsp"></c:import>
  <div class="container-fluid">
  <div class="container-fluid my-5">
<h1 class="text-center">상품 등록 페이지입니다</h1>
</div  >
<div class="my-5">
	<form action="./add" method="post" class="text-center">
		
	 <div class="mb-3">
		 	<legend>상품명</legend>
			<input type="text" name="bookName" id="bookname" value="bookName" placeholder="제품명입력">
		</div>
		<div class="mb-3">
			<legend>이자율</legend>
			<input type="text" name="bookRate" value="bookRate"> 
		</div>
		<div class="mb-3">
			<legend>상세정보</legend>
			<textarea  rows="" cols=""  name="bookDetail"></textarea> 
		</div>
				
		<div>
			<legend>판매여부</legend>
			<label for="bs1"  >판매</label>
				<input  id="bs1" type="radio"  checked="checked"  name="bookSale" value="1">
			<label for="bs2" >판매중단</label>
				<input  id="bs2" type="radio" name="bookSale" value="0">
		</div>
		</div>
		<div class="mx-auto col-md-7">
			<select name="bookSale" class="form-select form-select-lg mb-3" multiple aria-label="multiple select example">
			  <option selected>판매여부를 골라주세요</option>
			  <option value="1">판매</option>
			  <option seleted value="0">판매중단</option>
			</select>
		</div>
	 <button type="submit" value="등록" class="btn btn-outline-success"> 등록 </button>
	</form>	
		<a href="./add" class="btn btn-primary">상품등록</a>
</div>
      <c:import url="../template/common_js.jsp"></c:import>
</body>
</html>