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
<title>Home</title>
<link rel="stylesheet" href="./resources/css/main.css">
<link rel="stylesheet" href="./resources/css/reset.css">

<body>
	<header>
		<div class="header_wrap">
			<div class="header_logo">
			<a href="../"><img src="/resources/images/logo.png" alt=""></a></div>
			<nav class="header_nav">
				<ul>
					<li><a href="#">공지사항</a></li>
					<li><a href="./product/list">제품목록</a></li>
					<li><a href="./bankBook/list">저축통장</a></li>
					<li><a href="#">저축상품</a></li>
				</ul>	
			</nav>
			<div class="header_sub">
				<ul>
					<li><a href="./member/memberLogin">LOGIN</a></li>
					<li><a href="./member/memberJoin">JOIN</a></li>
					<li><a href="#">KO</a></li>
					<li><a href="#">EN</a></li>
					<li><a href="#">JP</a></li>
					<li><a href="#">CN</a></li>
				</ul>
			</div>
			
		</div>
	   </header>
	</head>

<link rel="stylesheet" href="/resources/css/main.css">	

	
	<div class="title">
	<h1>product list page 입니당</h1>
    <%
        List<ProductDTO> ar = (List<ProductDTO>)request.getAttribute("list"); 
		for(ProductDTO productDTO : ar){		
	%>	
	<h3><%= productDTO.getProductName()%></h3>
	<h3><%= productDTO.getProductScore()%></h3>
	<%}%>  
	
	<hr>
	</div>
	<table class="title" >
	
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
	<a href="./productAdd">상품등록</a>
	 
</body>
</html>