<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table width="1200" height = "600" border="0">
<tr>
<td colspan="2" style="background-color:#FFA500;">

<h1 align = "center">OnMobile Employee Desk</h1>
</td>
</tr>

<tr valign="top">
<td style="background-color:#FFD700;width:200px;text-align:top;">
<h1><a href = "employee.html">Home</a></h1>
<br>
<b><a href = "addemployee.html">Add Employee</a></b> <br /><br>
<b><a href = "allemployee.html">List all employees </a> </b><br /> <br>
<b><a href = "retriveemployee.html">Retrive Employee Details </a></b> <br /> <br>
<b><a href = "removeemployee.html">Remove Employee</a></b> <br /> <br>
<b><a href = "updateemployee.html">Update Employee </a> </b><br /> <br>
</td>
<td style="background-color:#eeeeee;height:200px;width:400px;text-align:top;">
<h2><font color = "green">Employee Details have been successfully added</font></h2>
<br>
<table border = '2'>
<th>Employee ID</th>
<th>Employee Name </th>
<th>Designation</th>
<th>Salary<th>
<tr>
<td>${employee.employeeId }</td>
<td>${employee.employeeName }</td>
<td>${employee.designation }</td>
<td>${employee.salary }</td>
</tr>
</table>
<pre>

</pre>
</td>
</tr>

<tr>
<td colspan="2" style="background-color:#FFA500;text-align:center;">
Copyright © 2011 OnMobile</td>

</tr>

</table>

</body>
</html>