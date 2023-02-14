<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<html>
<head>
   <title>Home</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
   	<c:import url="./template/common_css.jsp"></c:import>
</head>
<body>
<!-- 서버 내부 주소, 상대 경로  -->
  <c:import url="./template/header.jsp"></c:import>
  <div class="container-fluid-magin-5">
  <section class="container border border-danger">
  <article class="row">
  <div class="col border border-danger">1</div>
  <div class="col border border-primary">2</div>
  <div class="col border border-danger">3</div>
 </article>

  </section>
  <section class="container-fluid border border-prmary">
  <article class="row">
  <div class="col-2 border border-danger">1</div>
  <div class="col-2 border border-primary">2</div>
  <div class="col-8 border border-danger">3</div>
  </section>
  
  <section class="container-md border border-danger">
    <article class="row">
		  <div class="col-md-3 col-lg-6 border border-danger">1</div>
		  <div class="col-md-3 col-lg-6 border border-primary">2</div>
		  <div class="col-md-6 col-lg-12 border border-danger">3</div>
		  </section>
      <div class= "container-fluid">
		  <div class= "row col-md-6 offset-md-3">
		  	<div id="carouselExample" class="carousel slide">
		  <div class="carousel-inner">
		    <div class="carousel-item active">
		      <img src="/resources/images/s1.jpg" class="d-block w-100" alt="...">
		    </div>
		    <div class="carousel-item">
		      <img src="/resources/images/s2.jpg" class="d-block w-100" alt="...">
		    </div>
		    <div class="carousel-item">
		      <img src="/resources/images/s3.jpg" class="d-block w-100" alt="...">
		    </div>
		  </div>
		  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExample" data-bs-slide="prev">
		    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
		    <span class="visually-hidden">Previous</span>
		  </button>
		  <button class="carousel-control-next" type="button" data-bs-target="#carouselExample" data-bs-slide="next">
		    <span class="carousel-control-next-icon" aria-hidden="true"></span>
		    <span class="visually-hidden">Next</span>
		  </button>
		</div>
		</div>
    </div>
    <div> 
    <h1>${member.name}</h1>
    
    </div>
   <c:import url="./template/common_js.jsp"></c:import>
	
</body>
</html>