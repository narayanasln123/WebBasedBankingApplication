<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String accno=(String)request.getAttribute("accno");
String uname=(String)request.getAttribute("aname");
out.println("Welcome "+uname+" your account no "+accno+" closed");
%>
<br>
<a href="apanabank.html">Home</a>
</body>
</html>