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
ApanaBankBean ab=(ApanaBankBean)request.getAttribute("abbean");
if(ab==null)
{
	out.println("Account Not Created!!!!!!!!!!!!!!!");
}
else
{
	out.println("Acc No"+"&nbsp&nbsp"+"User Name"+"&nbsp&nbsp"+"Password"+"&nbsp&nbsp"+"Balance"+"&nbsp&nbsp"+"Address"+"&nbsp&nbsp"+"Phome Num"+"<br>");
	out.println(ab.getAccno()+"&nbsp&nbsp"+ab.getUname()+"&nbsp&nbsp"+ab.getPword()+"&nbsp&nbsp"+ab.getBalance()+"&nbsp&nbsp"+ab.getAddr()+"&nbsp&nbsp"+ab.getPhno()+"<br>");
	
}
%>
<br><a href="apanabank.html">Home</a>
</body>
</html>