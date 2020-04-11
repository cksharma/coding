<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file = "header.jsp" %>
This is my first jsp
<br> <br>
<%
	out.println("This is java code within jsp");
%>

<br> <br>
Square root <%=Math.sqrt(25) %>
List <%=new ArrayList()%>
<br> <br>
Current Date and Time <%=new Date() %>
<br> <br>
<%@ include file = "footer.jsp" %>
</body>
</html>
