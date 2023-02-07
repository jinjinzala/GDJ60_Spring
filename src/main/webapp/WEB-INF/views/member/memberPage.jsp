<%@page import="com.iu.s1.member.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>memberPage page </h1>
<h1>여기는 멤버 </h1>
<% MemberDTO memberDTO = (MemberDTO)request.getAttribute("dto"); %>
<h3> <%= memberDTO.getMemberName() %></h3>
<h3> <%= memberDTO.getMemberPhone() %></h3>
<h3> <%= memberDTO.getId() %></h3>
<h3> <%= memberDTO.getPw() %></h3>
<hr>

<h3>${requestScope.dto.memberName}</h3>
<h3>${dto.getProductDetail()}</h3>
<h3>${dto.productJumsu * dto.productNum }</h3>


</body>
</html>