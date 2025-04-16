<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Welcome
<%@page import="java.sql.*,GetConnection.*" %>
<%session=request.getSession(false);
String user=(String)session.getAttribute("adid");
System.out.println(user);
System.out.println((String)session.getAttribute("adid"));
%><font color="blue"><%=user %></font>

<a href="Destroy">Logout</a>


</body>
</html>