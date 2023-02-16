<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
   <c:import url="../template/common_css.jsp"></c:import>
      <link rel="stylesheet" href="/resources/css/table.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
  <c:import url="../template/header.jsp"></c:import>
   <div class="container fluid my-5">
   <div class= "row mb-4 ">
   
   
	<h1 class="text-center mb-2 border-bottom border-warning">은행 상품 등록
	<div class = "mb-3"></div>
	</h1>
	</div>
	<form class = "row g-3 ms-auto" action="./add" method="post" enctype="multipart/form-data">
		<div class ="col-md-6">
			<label for="bookName" class="form-label">상품명</label>
  			<input type="text" class="form-control" id="bookName" name="bookName">
 		</div>
 		<div class="col-md-5">
    		<label for="bookRate" class="form-label">이자율</label>
    		<input type="text" class="form-control" id="bookRate" name="bookRate">
  		</div>
  		<div class="col-12">
    		<label for="bookDetail" class="form-label">상품 설명</label>
    		<input type="text" class="form-control" id="bookDetail" name="bookDetail" placeholder="간단한 설명">
  		</div>
		<div class="col-12">
    		<label for="files" class="form-label">이미지 첨부</label>
    		<input type="file" class="form-control" id="files" name="pic">
  		</div>
  		<div class="form-check form-switch ms-2 my-4">
 			<input class="form-check-input" type="checkbox" role="switch" id="bookSale" name="bookSale" value="1" checked>
  			<label class="form-check-label" for="bookSale" >판매여부</label>
		</div>
		
		

	  <div class="col-12">
	    <button type="submit" class="btn btn-primary">등록</button>
	    <a class ="btn btn-primary" href="./list">리스트</a>
	  </div>
	</form>
   </div>
   <c:import url="../template/common_js.jsp"></c:import>
   
</body>
</html>