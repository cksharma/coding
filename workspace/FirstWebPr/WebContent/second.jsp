<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%--<%@ page errorPage = "errorDisplay.jsp" --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%=
Math.sqrt(25.0)%>
<% out.println(10 / Integer.parseInt(request.getParameter("no"))); // now to deal with this we use errorpage...
%>
<%=10/0 %>
<%=Math.sqrt(25)%>
</body>
</html>