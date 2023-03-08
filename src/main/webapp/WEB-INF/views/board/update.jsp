<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
   <c:import url="../template/common_css.jsp"></c:import>
    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
</head>
<body>
  <c:import url="../template/header.jsp"></c:import>
   <div class="container fluid my-5">
   <div class= "row mb-4 ">
   
   <h1>${boardName} update page </h1>
   
	<h1 class="mb-2"> 상품 추가 등록
	</h1>
	</div>
	<form class = "row g-3 ms-auto" action="./update" method="post" enctype="multipart/form-data" >
	<input type="hidden" name="num" value="${dto.num}">
		<div class ="col-12" >
			<label for="writer" class="form-label"  >작성자 </label>
  			<input type="text" class="form-control" id="writer" name="writer" readonly value="${member.id}">
 		</div>
 		<div class="col-12">
    		<label for="title" class="form-label">제목</label>
    		<input type="text" class="form-control" id="title" value="${dto.title}" name="title" placeholder="제목">
  		</div>
  		<div class="col-12">
    		<label for="contents" class="form-label">내용</label>
    		<%-- <input type="text" class="form-control" id="contents" name="contents"  value="${dto.contents}" placeholder="상세내용">  --%>
			<textarea name="contents" class="form-control" id="contents" name="contents" placeholder="내용 입력" rows="7">${dto.contents}</textarea>
  		</div>

		
		<div id="fileList" class="my-5">
				<button type="button" class="btn btn-primary" id="fileAdd">ADD</button>
		<c:forEach items="${dto.boardFileDTOs}" var="fileDTO">
      		<div class="input-group mb-3">
  	<div class="input-group-text">
    <input class="form-check-input mt-0 deleteCheck" type="checkbox" value="${fileDTO.fileNum}" name="fileNum" aria-label="Checkbox for following text input">
  	</div>
  	<input type="text" class="form-control" disabled value="${fileDTO.oriName}" aria-label="Text input with checkbox">
	</div>
    	</c:forEach>
    	</div>

	  <div class="col-12">
	    <button type="submit" class="btn btn-primary">글쓰기</button>
	  </div>
	</form>
	</div>
   <c:import url="../template/common_js.jsp"></c:import> 
   <script src="../resources/js/filemanager.js"></script>
   <script>
   setParam('addFiles');
   setCount('${dto.boardFileDTOs.size()}');
   $("#contents").summernote();
   </script>
   
</body>
</html>