<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id = "playerAdded" class = "com.buffalo.stock.Player" scope = "request"></jsp:useBean>
<h2>Player added</h2>
<pre>
Player Id<jsp:getProperty property="playerId" name="playerAdded"/>
Player Name<jsp:getProperty property = "playerName" name = "playerAdded"/>
Sports Code<jsp:getProperty property = "sportsCode" name = "playerAdded"/>
Country Code<jsp:getProperty property = "countryCode" name = "playerAdded"/>
</pre>
</body>
</html>