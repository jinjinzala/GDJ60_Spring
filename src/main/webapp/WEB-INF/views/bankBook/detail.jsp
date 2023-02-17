<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bankBook detail page</title>
</head>
<body>
<h1>detail page</h1>
<c:if test="${not empty dto}"> 
<h3>  name : ${dto.bookNumber}  </h3>
<h3> name : ${dto.bookName} </h3>
<h3> rate : ${dto.bookRate} </h3>
<h3> sale : ${dto.bookSale} </h3>
<h3> detail : ${dto.bookDetail}</h3>
<div> 
	<img src="../resources/upload/bankBook/${dto.bankBookImgDTO.fileName}">
</div>

<a href ="./delete?bookNumber=${dto.bookNumber}">상품삭제</a>
</c:if>
 
<c:if test="${empty dto}"> 
<h3>존재하지 않는 상품입니다 고객센터로 문의바랍니다. </h3>
</c:if>
<a href="./update?bookNumber=${dto.bookNumber}">상품수정 </a>
<a href="./list">목록으로 </a>

</body>
</html>