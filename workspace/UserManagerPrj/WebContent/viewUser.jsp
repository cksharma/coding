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
	<s:set name="users" value="#application.users"></s:set> <!--  this users is coming from the exeute method, where we set the context of the users -->
	<table border="1">
		<tr>
			<td>UserName</td>
			<td>Password</td>
			<td>Email</td>
		</tr>
		<s:iterator id="user" value="users">
			<tr>
				<td><s:property value="username" /></td>
				<td><s:property value="password" /></td>
				<td><s:property value="email" /></td>
			</tr>
		</s:iterator>
	</table>
	<s:a href="home.jsp">Home</s:a>
	<s:a href="addUser.jsp">Add more users</s:a>
</body>
</html>