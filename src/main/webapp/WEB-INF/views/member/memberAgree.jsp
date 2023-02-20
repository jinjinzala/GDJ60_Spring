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
<div class="container-fluid" ></div>
<div class="row col-md-6 mx-auto my-5">
		<div class="form-check">
		  <input class="form-check-input" type="checkbox" value="" id="CheckAll">
		  <label class="form-check-label" for="CheckAll">
		 전체동의
		  </label>
		</div>
		
		<div class="form-check">
		  <input class="form-check-input" type="checkbox" value="" id="Check1" >
		  <label class="form-check-label" for="Check1">
		   동의1
		  </label>
		</div>
		
		<div class="form-check">
		  <input class="form-check-input" type="checkbox" value="" id="Check2" >
		  <label class="form-check-label" for="Check2">
		   동의2
		  </label>
		</div>
		
		<div class="form-check">
		  <input class="form-check-input" type="checkbox" value="" id="Check3" >
		  <label class="form-check-label" for="Check3">
		   동의3
		  </label>
		</div>
</div>
</body>

<script type="text/javascript" src="../resources/js/memberAgree.js"></script>
<c:import url="../template/common_js.jsp"></c:import>
</html>