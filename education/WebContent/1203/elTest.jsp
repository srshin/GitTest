<%@page import="com.encore.model.BookDTO"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%
//자바변수 
int cnt=100;
//저장된 속성
pageContext.setAttribute("cnt", 200);
request.setAttribute("cnt", 300);
session.setAttribute("cnt", 400);
application.setAttribute("cnt", 500);

Cookie c1 = new Cookie("cart", "apple");
c1.setMaxAge(60*60*30*24);
response.addCookie(c1);
%>
</head>
<body>




Expression  : <%=cnt+1 %> <br>
EL 문법 ---pageContext : ${cnt+1 } <br>
EL 문법 ---request : ${requestScope.cnt+1 } <br>
EL 문법 ---session : ${sessionScope.cnt+1 } <br>
EL 문법 ---application : ${applicationScope.cnt+1 } <br>
parameter읽기 : ${param.cnt+1 } <br> <!-- 601 -->
parameter읽기 : ${param["cnt"]+1 } <br>
parameter읽기 : ${paramValues.habby[0] } <br>
parameter읽기 : ${paramValues.habby[1] } <br>
parameter읽기 : ${paramValues.habby[2] } <br>
<hr>
header읽기 : ${header["user-agent"]} <br>
쿠키정보 : ${cookie.cart.value } <br>
${cookie.cart["value"] } <br>
${cookie.cart.maxAge } <br>
${cookie.cart["maxAge"] } <br>
<br>
initParam: ${initParam["DB_NAME"]} <br>
initParam: ${initParam["userID"]} <br>
initParam: ${initParam.userID} <br>
<br>
request객체의 정보들:
contextPath : ${pageContext.request.contextPath } <br>
contextPath : ${pageContext["request"]["contextPath"] } <br>

상대경로 이용하기 :
<a href="../1130/input.jsp">쇼핑하러가기</a> <br>
절대경로 이용하기1:
<a href="/education/1130/input.jsp">쇼핑하러가기</a> <br>
절대경로 이용하기2:
<a href="${pageContext.request.contextPath}/1130/input.jsp">쇼핑하러가기</a> <br>
URI :
${pageContext.request.requestURI } <br>
URL :
${pageContext.request.requestURL } <br>

EL의 연산자 :
<%
pageContext.setAttribute("num1", 100);
pageContext.setAttribute("num2", 5);
%>
산술연산자: 
더하기 : ${num1+num2 } <br>
- : ${num1-num2 } <br>
* : ${num1*num2 } <br>
/ : ${num1/num2 } <br>
% : ${num1%num2 } <br>

 비교연산자 : ${num1 > num2 } <br>
비교연산자 : ${num1 - num2 > 0  } <br>
논리연산자 :

AND : ${num1 lt 0 && num2 gt 100 } <br>

${num1>100?"네":"아니오" }
<br>
문자비교: 
${"apple"=="apple"}<br>
${"apple"=="apple2"}<br>
${"apple"<"apple2"}<br>
${"apple">"apple2"}<br>
${empty id }<br>
${empty id2 }<br>
<%
//배열
String[] fruit = {"사과","귤","바나나"};
pageContext.setAttribute("fruits", fruit);
pageContext.setAttribute("book", new BookDTO("JSP","A저자","B출판사"));
//list
List<String> fruitList = new ArrayList<>();
fruitList.add("사과2");
fruitList.add("귤2");
fruitList.add("바나나2");
pageContext.setAttribute("fruitsList", fruitList);
//map
Map<String,String> fruitMap = new HashMap<>();
fruitMap.put("1", "사과3");
fruitMap.put("2", "귤3");
fruitMap.put("3", "바나나3");
pageContext.setAttribute("fruitsMap", fruitMap);
%>
과일1: ${fruits[0]}<br>
과일2: ${fruits[1]}<br>
과일3: ${fruits[2]}<br>
과일1: ${fruitsList[0]}<br>
과일2: ${fruitsList[1]}<br>
과일3: ${fruitsList[2]}<br>
과일1: ${fruitsMap["1"]}<br>
과일2: ${fruitsMap["2"]}<br>
과일3: ${fruitsMap["3"]}<br>

<h1>JSTL 사용하기(배열) </h1>
<ul>
 <c:forEach var="f" items="${fruits}">
  <li>${f}</li>
 </c:forEach>
</ul>

<h1>JSTL 사용하기(List) </h1>
<ul>
 <c:forEach var="f" items="${fruitsList}">
  <li>${f}</li>
 </c:forEach>
</ul>

<h1>JSTL 사용하기(Map) </h1>
<ul>
 <c:forEach var="f" items="${fruitsMap}">
  <li>${f.key}------${f.value}</li>
 </c:forEach>
</ul>

BOOK : ${book.title}
${book.author}
${book.publisher}
${book["title"]}


<!-- http://localhost:9090/education/1203/elTest.jsp
                     ?cnt=700&habby=aa&habby=bb -->

</body>
</html>



