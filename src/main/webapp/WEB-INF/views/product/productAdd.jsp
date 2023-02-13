<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>저축상품</title>
</head>
<body>
	<h1>productAdd page</h1>
	<div class="col-6">
	   <form action="./productAdd" method="post">
		   상품명
		    <input type="text" name="productName" value="상품명을 여기에 입력해주세요"> 
			상품정보 
			 <textarea name="productDetail" rows="" cols =""> </textarea>
			 
			<button type="submit"> 전송 button</button>
			
		</form>
	</div>

</body>
</html>