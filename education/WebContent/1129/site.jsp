<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<jsp:include page="/header.jsp"></jsp:include>
<%-- <jsp:forward page="/header.jsp"></jsp:forward> --%>
<form action="portalSite">
 <input type="radio" name="site" value="http://www.naver.com" checked="checked">네이버<br>
 <input type="radio" name="site" value="http://www.daum.net">다음<br>
 <input type="radio" name="site" value="http://www.google.com">구글<br>
 <input type="radio" name="site" value="http://playdata.io">playdata<br>
 <input type="submit" value="이동">
</form>
</body>
</html>


