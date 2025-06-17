<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="test.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Account Info</h3>
 <% 
ApanaBankBean ab=(ApanaBankBean)request.getAttribute("abbean1");
out.println("your balance increased to :"+ab.getBalance());
%>
<br><a href="apanabank.html">Home</a>
</body>
</html>