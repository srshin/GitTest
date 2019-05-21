<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>


</head>
<body>
<h1>현재 구매 현황</h1>
<hr>
<%
Object obj = session.getAttribute("cart");
if(obj == null) return;
Map<String, Integer> cart = (Map<String, Integer>)obj;
for(String key:cart.keySet()) {
	   out.println("<p>" + key + "==>" + cart.get(key) + "</p>");
}
%>
${cart} <br>

<a href="input.jsp">계속구매하기</a>
<form action="shopping" method="post" onsubmit="return call();">
  <input type="submit" value="장바구니 비우기" >
</form>

<script>
  function call(){
	  //alert("정말로?");
	  result = confirm("정말로?");
	  return result;
  }

</script>

</body>
</html>




