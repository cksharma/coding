<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<s:text name="companyName"></s:text> <!--  text tag is used for the key which has to be internatilization. -->
		<s:actionerror/>
		<s:form action="testAliasInterceptorAction">
			<s:textfield name="uname" label="User Name"></s:textfield>
			<s:password name="pwd" label="Password"></s:password>
			<s:submit value="Login"></s:submit>
		</s:form>
	</center>
</body>
</html>