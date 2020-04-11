<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<s:actionerror/>
		<s:form action="addUserAction">
			<s:textfield name="username" label="User Name"></s:textfield>
			<s:password name="password" label="Password"></s:password>
			<s:textfield name="email" label="Email Id"></s:textfield>
			<s:submit value="Add User"></s:submit>
		</s:form>
	</center>
	<s:a href="home.jsp">Home</s:a>
</body>
</html>