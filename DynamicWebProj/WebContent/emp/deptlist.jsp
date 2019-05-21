<%@page import="com.encore.model.EmpDAO"%>
<%@page import="com.encore.model.DeptDTO"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	EmpDAO dao = new EmpDAO();
List<DeptDTO> deptlist = dao.selectAllDept();
pageContext.setAttribute("emplist", deptlist);
%>
<table border="1">
<tr>
<td>부서코드 </td><td>부서이름</td>
</tr>
<c:forEach items="${deptlist}" var="dept">
<tr>
	<td>${dept.department_id } </td>
	<td>${dept.department_name } </td>
</tr>
</c:forEach>
</table>