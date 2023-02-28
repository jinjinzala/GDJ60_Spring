<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
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
   <div class= "row mb-4 ">
   
   <h1>${boardName} add page </h1>
   
	<h1 class="mb-2"> 상품 추가 등록
	</h1>
	</div>
	<form class = "row g-3 ms-auto" action="./add" method="post" enctype="multipart/form-data" >
		<div class ="col-12" >
			<label for="writer" class="form-label"  >작성자 </label>
  			<input type="text" class="form-control" id="writer" name="writer" readonly value="${member.id}">
 		</div>
 		<div class="col-12">
    		<label for="title" class="form-label">제목</label>
    		<input type="text" class="form-control" id="title" name="title" placeholder="제목">
  		</div>
  		<div class="col-12">
    		<label for="contents" class="form-label">내용</label>
    		<input type="text" class="form-control" id="contents" name="contents" placeholder="상세내용">
  		</div>

		<div id="fileList" class="my-5">
				
				<button type="button" class="btn btn-primary" id="fileAdd">ADD</button>
			</div>


	<!-- 	<div id="fileList">
		<div class="col-12">
    		<label for="files" class="form-label">이미지 첨부</label>
    		<input type="file" class="form-control" id="files" name="files" data-file="file">
    		<button type="button" id="x"> x </button>
  		</div> 
		<button type="button" id="add" >ADD</button>
		</div>
 -->

	  <div class="col-12">
	    <button type="submit" class="btn btn-primary">글쓰기</button>
	  </div>
	  
	</form>
   </div>
   
   <script src="../resources/js/filemanager.js"></script>
   <script> setMax(5); setParam('files');</script>
   <c:import url="../template/common_js.jsp"></c:import>
   
</body>
</html>