<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="test.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
ApanaBankBean a1=(ApanaBankBean)request.getAttribute("abbean");
if(a1==null)
{
	out.println("please check username and pasword!!! ");
	
	
}
else
{
	out.println("Acc No"+"&nbsp&nbsp"+"User Name"+"&nbsp&nbsp"+"Balance"+"&nbsp&nbsp"+"Address"+"&nbsp&nbsp"+"Phome Num"+"<br>");
	out.println(a1.getAccno()+"&nbsp&nbsp&nbsp&nbsp&nbsp"+a1.getUname()+"&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp"+a1.getBalance()+"&nbsp&nbsp&nbsp&nbsp&nbsp"+a1.getAddr()+"&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp"+a1.getPhno()+"<br>");
}
%>
<a href="apanabank.html">Home Page</a>
</body>
</html>