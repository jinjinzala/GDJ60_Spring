<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>
<a href="./product/list?num=1&num=2&num=3">PRODUCTList</a>
<a href="/product/list">PRODUCTList</a>
<a href="/member/memberJoin">memberjoin</a>
<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
