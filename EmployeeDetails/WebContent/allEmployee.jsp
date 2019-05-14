<%@page import="java.util.StringTokenizer"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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
<b><a href = "retriveemployee.html">Retrieve Employee Details </a></b> <br /> <br>
<b><a href = "removeemployee.html">Remove Employee</a></b> <br /> <br>
<b><a href = "updateemployee.html">Update Employee </a> </b><br /> <br>
</td>
<td style="background-color:#eeeeee;height:200px;width:400px;text-align:top;">
<table border = '1'>
<pre>
<th>Employee   ID  </th>
<th>Employee Name</th>
<th>Designation  </th>
<th>Salary       </th>
</pre>

<%
	List lst = (List )request.getAttribute("showall");	
	Iterator it = lst.iterator(); 
	int cnt = 0;
	
	while(it.hasNext())
	{
		String str = it.next().toString();
		String res[] = str.split("-->");
		String id = res[0]; String name = res[1]; String designation = res[2]; String salary = res[3];
		out.println("<tr><td>" + id + "</td><td>" + name + "</td><td>" + designation + "</td><td>" + salary + "</td></tr>");
		//out.println("<tr><td>" + id + "</td><td>" + name + "</td><td>" + designation + "</td><td>" + salary + "</td></tr>");
	}
	
%>
</table>
</td>
</tr>

<tr>
<td colspan="2" style="background-color:#FFA500;text-align:center;">
Copyright © 2011 OnMobile</td>

</tr>

</table>

</body>
</html>