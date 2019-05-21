<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


${sessionScope.student.name}
==================================================
<br>student: ${sessionScope.student}
<br>

<c:if test="${sessionScope.student==null}">
 <c:redirect url="/index.jsp">
</c:redirect>
</c:if>

<c:if test="${sessionScope.student!=null}">
${sessionScope.student.name}
</c:if>


