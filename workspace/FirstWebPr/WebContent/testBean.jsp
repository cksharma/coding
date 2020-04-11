<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id = "emp" class = "com.buffalo.stock.Employee"></jsp:useBean>
<jsp:setProperty property = "employeeId" name = "emp" value = "101"/>
<jsp:setProperty property = "employeeName" name = "emp" value = "Rajesh"/>
<jsp:setProperty property = "designation" name = "emp" value = "Developer"/>
<jsp:setProperty property = "salary" name = "emp" value = "56000"/>
<pre>
Employee Id <jsp:getProperty name = "emp" property = "employeeId"/>
Employee Name <jsp:getProperty name = "emp" property = "employeeName"/>
Designation <jsp:getProperty name = "emp" property = "designation"/>
Salary <jsp:getProperty name = "emp" property = "salary"/>
Company Name <jsp:getProperty name = "emp" property = "company"/> <%--this is also the valid statementthough we dunn have company variable we can get it as the method name is getCompany() .. beans takes it as company --%>
</pre>
</body>
</html>