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
		Welcome
		<s:property value="#session.user" default="Guest" />
		<s:if test="#session.user!=null">
			<s:url id="logout" action="logout"></s:url>
			<s:a href="%{logout}">Logout</s:a>
		</s:if>

		<table>
			<tr align="center">
				<td>
					<s:url id="hello" action="hello"></s:url>
					<s:a href="%{hello}">Hello Action</s:a>
				</td>
			</tr>
			<tr>
				<td>
					<s:a href="addUser.jsp">Add User</s:a>
				</td>
			</tr>
			<tr align="center">
				<td>
					<s:a href="viewUser.jsp">View User</s:a>
				</td>
			</tr>
			<tr align="center">
				<td>
					<s:a href="login.jsp">Login</s:a>
				</td>
			</tr>
		</table>
	</center>
</body>
</html>