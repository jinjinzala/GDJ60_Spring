<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    
<html>
<head>
	<title>Home</title>
	<link rel="stylesheet" href="./resources/css/main.css">
</head>
<body>
<h1>
	Hello world!  
</h1>
<a class="c3" href="./product/list?num=1&num=2&num=3">PRODUCTList</a>
<a class="c3" href="/product/list">PRODUCTList</a>
<a class="c3" href="/member/memberJoin">memberjoin</a>
<a class="c3" href="/bankBook/list">bankbookList</a>
<a class="c3" href="./bankBook/list">bankbookList</a>

<img alt="요건 아이유에용" src="/resources/images/one.jpg">
<img alt="요건 윈터입니당" src="./resources/images/two.jpg">


<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
