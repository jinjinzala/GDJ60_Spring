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
<c:import url="../template/common_css.jsp"></c:import>
<link rel="stylesheet" href="../resources/css/table.css">
<link rel="stylesheet" href="/resources/css/main.css">
</head>

<body>
<!-- 서버 내부 주소, 상대 경로  -->
  <c:import url="../template/header.jsp"></c:import>
	<div class="container-fluid my-5">
	<div class="row mb-4 border-bottom border-dark">
	<h1 class="col-md-7 mx-auto text-center pb-4"> Productlist page</h1>
	</div>	
	
<%-- 	<div class="title">
    <%
        List<ProductDTO> ar = (List<ProductDTO>)request.getAttribute("list"); 
		for(ProductDTO productDTO : ar){		
	%>	
	<h3><%= productDTO.getProductName()%></h3>
	<h3><%= productDTO.getProductScore()%></h3>
	<%}%>  
	
	<hr>
	</div> --%>
	
<div class="row col-md-7 mx-auto">
	<table class="table table-hover"> 
	
	<thead>
		 <tr>
		  	<th>상품명</th>
		  	<th>상품평점</th>
		 </tr>
	</thead>
	<tbody class="table-group-divider">
	<c:forEach items="${list}" var="dto"> <!-- dto는 page 영역에 담긴다 -->
	<tr>
			<td><a href="./detail?productNum=${dto.productNum}">${pageScope.dto.productNum}</a></td>
			<td><a class="tbl2_td"> ${pageScope.dto.productName}</a></td>
			<td class="tbl2_td">		
			<td><a class="tbl2_td">${ dto.productScore}</a></td>
	</tr>
	</c:forEach>
	</tbody>
	</table>
	<div class="row col-md-7 mx-auto">
	<a href="./productAdd" class="btn btn-primary col-2">상품등록</a>
	</div>
</div>	 
<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>