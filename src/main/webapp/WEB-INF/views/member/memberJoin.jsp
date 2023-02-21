<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/common_css.jsp"></c:import>
<style>
.redRedult{
	color: red;
}

.blueRedult{
	color: blue;
}
</style>



</head>
<body>
 <c:import url="../template/header.jsp"></c:import>
 <div class="text-center">
<h1> memberJoin page </h1>
</div>

<div class="text-center">
	   <form action="./memberJoin" method="post" id="frm">
		   member
		    <div class="mb-3">
		    아이디
		    <input type="text" name="id" value="id" id="id">  
		    <div id="idResult">
		    </div>
			 </div>
			 <div class="mb-3">
			비번
			<input type="text" name="pw" value="pw" id="pw"> 
			<div id="pwResult"> </div>
			</div>
			 
			 <div class="mb-3">
				비번2
			<input type="text" name="pw" value="pw" id="pw2"> 
			<div id="pwResult2"> </div>
				</div>
			 <div class="mb-3">
				이름 
			<input type="text" name="memberName" value="memberName" id="memberName"> 
			 </div>
			 
			<div class="mb-3">
			폰
			<input type="text" name="memberPhone" value="memberPhone" id="memberPhone"> 
			</div>
			
			<div class="mb-3">
			이메일
			<input type="text" name="email" value="email" id="email"> 
			</div>
			
			 <div class="mb-3">
			 <textarea name="memberJoin" rows="" cols ="">  </textarea>
			 </div>
			  
			 <button type="button" id="btn">전송click</button>
			  
			  <button type="button" id="btn" >버튼 텍스트</button>
			<!-- <button type="submit"> 전송 button</button> -->
			<script type="text/javascript" src="../../resources/js/memberJoin.js"></script>
		</body>

   <c:import url="../template/common_js.jsp"></c:import>
</html>