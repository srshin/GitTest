<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<pre>
1.값을 setting :
<c:set var="count" value="100" scope="request"></c:set>
2.값을 얻기 : ${count+1}
3.값지우기 :<c:remove var="count"/>
4.다시 값을 얻기 : ${count+1}
<c:set var="score" value="90" scope="request"></c:set>
5.if : 
<c:if test="${score>=90 && score<=100 }">A학점</c:if>
<c:if test="${score>=80 && score <90}">B학점</c:if>
<c:if test="${score>=70 && score < 80}">C학점</c:if>
<c:if test="${score>=60 && score <70 }">D학점</c:if>
<c:if test="${score<60 }">F학점</c:if>
6.choose:
<c:choose>
  <c:when test="${score>=90}">A학점</c:when>
  <c:when test="${score>=80}">B학점</c:when>
  <c:when test="${score>=70}">C학점</c:when>
  <c:when test="${score>=60}">D학점</c:when>
  <c:otherwise>F학점</c:otherwise>
</c:choose>

7.반복문:
<c:set var="total" value="0"></c:set>
<c:forEach begin="1" end="10" var="su" step="2">
   <h${su}>${su}</h${su}> 
   <c:set var="total" value="${total+su}"></c:set>
</c:forEach>
합계는 ${total}

8.forTokens :
<c:forTokens var="fruit"  items="사과 귤 바나나" delims=" ">
   ${fruit}**
</c:forTokens>

<!-- 요청주소가 변경  즉,현재요청무시하고 다른 요청으로 간다.  -->
<%-- <c:redirect url="elTest.jsp">
 <c:param name="cnt" value="555"></c:param>
</c:redirect> --%>
<!-- import는 다른 웹자원도 가능  -->
<c:import url="https://www.daum.net"></c:import>
<!-- include는 같은 웹자원만 가능  --><!-- 
<jsp:include page="jstlTest2.jsp"/> -->

</pre>
</body>
</html>





