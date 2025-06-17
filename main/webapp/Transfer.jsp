<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Account Info</h3>
<%
long a=(Long)request.getAttribute("fbal");
long b=(Long)request.getAttribute("lbal");
out.println("Target Account Balance is "+a+" reduced amount to "+b);
%>
<br>
<a href="apanabank.html">Home</a>
</body>
</html>