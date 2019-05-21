<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>   
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>format</h1>
<%Date d = new Date(); %>
<c:set var="today" value="<%=d %>"></c:set>
1번. ${today}<br>
2번.<fmt:formatDate value="${today }"/><br>
2번.<fmt:formatDate value="${today }" type="date"/><br>
2번.<fmt:formatDate value="${today }" type="time"/><br>
2번.<fmt:formatDate value="${today }" type="both"/><br>
3번.<fmt:formatDate value="${today }" dateStyle="long"/><br>
3번.<fmt:formatDate value="${today }" dateStyle="short"/><br>
3번.<fmt:formatDate value="${today }" type="time"  timeStyle="long"/><br>
3번.<fmt:formatDate value="${today }" type="time" timeStyle="short"/><br>
4번.<fmt:formatDate value="${today }"   type="time" pattern="(a)hh:mm:ss"/><br>
5번.<fmt:formatNumber value="10000000000000" pattern="###,###,###,###"></fmt:formatNumber>
<br>
6번.${fn:toUpperCase("oracle") } <br>
6번.${fn:length("oracle") } <br>

</body>
</html>






