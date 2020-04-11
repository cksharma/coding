<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<h2>
<s:property value="message" default="User Management Action Message"/>
</h2>
<br></br>
Hi <s:property value="#session.user" default="Guest"/>
<br></br>
<s:a href="home.jsp">Home</s:a>
</center>
</body>
</html>