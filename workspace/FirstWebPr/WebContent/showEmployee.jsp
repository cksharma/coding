<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id = "employee" class = "com.buffalo.stock.Employee" scope = "request"></jsp:useBean> <%-- in the current request it searches for the request.. --%>
<%-- since if it current request it doesn't find employee then it will create new object with employee and prints the default values..... --%>
<pre>
Employee Id <jsp:getProperty name = "employee" property = "employeeId"/>
Employee Name <jsp:getProperty name = "employee" property = "employeeName"/>
Designation <jsp:getProperty name = "employee" property = "designation"/>
Salary <jsp:getProperty name = "employee" property = "salary"/>
Company Name <jsp:getProperty name = "employee" property = "company"/> <%--this is also the valid statementthough we dunn have company variable we can get it as the method name is getCompany() .. beans takes it as company --%>
</pre>
</body>
</html>