<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.iu.s1.member.MemberDTO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<title>Insert title here</title>
<c:import url="../template/common_css.jsp"></c:import>
<link rel="stylesheet" href="../resources/css/table.css">

</head>
<body>
 <c:import url="../template/header.jsp"></c:import>
<h1> member login </h1>
 <section class="pb-4">
<form action="./memberLogin" method="post">
  <div class="mb-3">
    
  <input type="text" id="id" class="form-control"  name="id" >
  <label for="id" class="form-label">ID</label>
  </div>
  <div class="mb-3">
  
    <input type="text" id="pw" class="form-control"  name="pw">
      <label for="pw" class="form-label">PW</label>
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
</section>


 <c:import url="../template/common_js.jsp"></c:import>
</body>
</html>