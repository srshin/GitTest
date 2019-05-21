
<%@ page contentType="text/html; charset=UTF-8" %>
<%
	String method = request.getMethod();
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>HTML5</title>
</head>
<body>
	<h1>등록 결과</h1>
	<p>
		요청방식: <%= method %><br>
		공개키: ${param.key}<br>
		이메일: ${param.email}<br>
	</p>
</body>
</html>






