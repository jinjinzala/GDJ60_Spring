<%@page import="com.iu.s1.product.ProductDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.List" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
 	
	<h1>product list page 입니당</h1>
    <%
        List<ProductDTO> ar = (List<ProductDTO>)request.getAttribute("list"); 
		for(ProductDTO productDTO : ar){		
	%>	
	<h3><%= productDTO.getProductName()%></h3>
	<h3><%= productDTO.getProductScore()%></h3>
	<%}%>  
	
	<hr>
	<div class="col-6">
	<table class = "table table-hover">
	
	<thead>
		 <tr>
		  	<th>상품명</th><th>상품평점</th>
		 </tr>
	</thead>
	<tbody>
			<c:forEach items="${list}" var="dto"> <!-- dto는 page 영역에 담긴다 -->
			<tr>
			<td><h3> <a href="./detail?productNum=${dto.productNum}">${pageScope.dto.productNum}</a></h3></td>
			<td><h3>${ pageScope.dto.productName}</h3></td>
			<td><h3>${ dto.productScore}</h3></td>
			</tr>
			</c:forEach>
	</tbody>
	</table>
	<a class="btn btn-danger" href="./productAdd">상품등록</a>
	
	</div>
	 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
</body>
</html>