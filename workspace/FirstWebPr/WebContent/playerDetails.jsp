<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%--
<jsp:useBean id = "player" class = "com.onmobile.training.Player" scope = "request"></jsp:useBean>
<pre>
Player Id<jsp:getProperty property="playerId" name="player"/>
Player Name<jsp:getProperty property = "playerName" name = "player"/>
Sports Code<jsp:getProperty property = "sportsCode" name = "player"/>
Country Code<jsp:getProperty property = "countryCode" name = "player"/>
</pre>
--%> 
<pre>
<%-- 
Player Id ${player.playerId} 
Player Name ${player.playerName}
Sports code ${player.sportsCode}
Country code ${player.countryCode}
--%>
<%
	out.println(request.getAttribute("player"));
%>
</pre>
</body>
</html>