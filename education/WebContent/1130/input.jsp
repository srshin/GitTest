<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<hr>
<h1>과일을 선택하고 수량을 입력한 후 장바구니에 담으세요</h1>
<hr>
<form action="shopping">
	<select name="fruitName">
	 <option value="사과">사과(1개 800)</option>
	 <option value="한라봉">한라봉(1개 2000)</option>
	 <option value="메론">메론(1개 20000</option>
	 <option value="복숭아">복숭아(1개 6000)</option>
	</select>	
	<input type="number" name="count" value="1">개
	<input type="submit" value="장바구니담기">
</form>
</body>
</html>