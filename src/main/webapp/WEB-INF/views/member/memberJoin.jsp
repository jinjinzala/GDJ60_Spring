<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> memberJoin page </h1>
<div class="col-6">
	   <form action="./memberJoin" method="post">
		   member
		    <input type="text" name="id" value="id"> 
			아이디
			<input type="text" name="pw" value="pw"> 
			비번
			<input type="text" name="membername" value="membername"> 
			이름 
			 <textarea name="memberJoin" rows="" cols =""> </textarea>
			 
			<button type="submit"> 전송 button</button>
</body>
</html>