<%@ page import="edu.buffalo.stock.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	pageContext.setAttribute("customer", new Customer(110, "Arun", 5000));
%> 
<pre>
Company       : ${company}
Customer Id   : ${customer.customerId}
Customer Name : ${customer.customerName}
Balance       : ${customer.balance}
Location      : ${requestScope.customer.address.location}
City          : ${requestScope.customer.address.city}
Customer Id   : ${customerList.A.customerId}
City          : ${customerList.A.address.city}
<!-- this last statement is equivalent to City  -->

City <%=((edu.buffalo.stock.Customer) ((java.util.Map)request.getAttribute("customerList")).get("A")).getAddress().getCity()%>

City <%=(((java.util.Map<String, edu.buffalo.stock.Customer>)request.getAttribute("customerList")).get("A")).getAddress().getCity()%>

Customer Name : ${customer.customerName }
Customer Name : ${requestScope.customer.customerName}
Customer Name : ${sessionScope.customer.customerName }
Customer Name : ${applicationScope.customer.customerName }
</pre>
</body>
</html>