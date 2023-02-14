<%@page import="com.iu.s1.member.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/common_css.jsp"></c:import>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
<div class="container-fluid">

<div class="row">
<h1>member page</h1>
</div>

<div class="row">
<h1>Name : ${member.memberName}</h1>
<h1>Phone : ${member.memberPhone}</h1>
<h1>Email : ${member.email}</h1>
<a href="./memberUpdate" class="btn btn-info">정보수정</a>
</div>
</div>
<h1>memberPage page </h1>
<h1>여기는 멤버 </h1>
<% MemberDTO memberDTO = (MemberDTO)request.getAttribute("dto"); %>
<h3> <%= memberDTO.getMemberName() %></h3>
<h3> <%= memberDTO.getMemberPhone() %></h3>
<h3> <%= memberDTO.getId() %></h3>
<h3> <%= memberDTO.getPw() %></h3>
<hr>




</body>
</html>