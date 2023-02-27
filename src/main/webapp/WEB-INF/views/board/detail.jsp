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
   <div class="container fluid my-5">
   
   <div class="row"> 
		<h1>${boardName} Detail Page</h1>
		<h3>${dto.title}</h3>
		<h3>${dto.writer}</h3>
		<p>${dto.contents}</p>
  	
  	
  	<c:forEach items="${dto.boardFileDTOs}" var="fileDTO">
  	
	 <a href="../resources/upload/${boardName}/${fileDTO.fileName}">${fileDTO.oriName}</a>
	</c:forEach>
   
   <c:if test="${boardName ne 'notice'}">
   <a href="./reply?num=${dto.num}" class="btn btn-danger"> 답글 </a>
   </c:if>
      
      <div>
      <!--  -->
      <form action="./update" id="frm">
      <input type="hidden" name="num" value="${dto.num}">
      <button id="update" type="submit" class="btn btn-primary">UPDATE</button>
      <button id="delete" type="button" class="btn btn-info">DELETE</button>
      	</form>
      </div>
   </div> 
</div>

 <script type="text/javascript" src="../resources/js/boardForm.js"></script>
   <c:import url="../template/common_js.jsp"></c:import>
</body>
</html>