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
		<h1>User Details</h1>
		<s:form action="firstAction">
			<s:textfield label="Customer Id" name="customerId"></s:textfield>
			<s:textfield label="Customer Name" name="customerName"></s:textfield>
			<s:textfield label="Balance" name="balance"></s:textfield>
			<s:submit value="Submit"></s:submit>
		</s:form>
	</center>
</body>
</html>