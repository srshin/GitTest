<%@ page contentType="text/html; charset=UTF-8" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html lang="UTF-8">
<head>
<meta charset="UTF-8">
<title>HTML5</title>
</head>
<body>
	<h1>등록 결과</h1>
	<p>
		아이디: ${param.id}<br>
		전화번호: ${param.phone}<br>
		나이: ${param.age}<br>
		홈페이지: ${param.homepage}<br>
		이메일: ${param.email}<br>
	</p>
</body>
</html>
















