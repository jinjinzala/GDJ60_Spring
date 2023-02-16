<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/common_css.jsp"></c:import>
</head>
<body>
 <c:import url="../template/header.jsp"></c:import>
 <div class="text-center">
<h1> memberJoin page </h1>
</div>
<div class="text-center">

	   <form action="./memberJoin" method="post">
		   member
		    <div class="mb-3">
		    아이디
		    <input type="text" name="id" value="id"> 
			 </div>
			 <div class="mb-3">
			비번
			<input type="text" name="pw" value="pw"> 
			 </div>
			 
			 <div class="mb-3">
			이름 
			<input type="text" name="memberName" value="memberName"> 
			 </div>
			 
			<div class="mb-3">
			폰
			<input type="text" name="memberPhone" value="memberPhone"> 
			</div>
			
			<div class="mb-3">
			이메일
			<input type="text" name="email" value="email"> 
			</div>
			
			 <div class="mb-3">
			 <textarea name="memberJoin" rows="" cols ="">  </textarea>
			  </div>
			  
			<button type="submit"> 전송 button</button>
</body>

   <c:import url="../template/common_js.jsp"></c:import>
</html>