<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
당신이 선택한것: <br>
아이디 : ${param.petid } <br>
동물 : 
${paramValues.pet[0]}, 
${paramValues.pet[1]},
${paramValues.pet[2]}

</body>
</html>








