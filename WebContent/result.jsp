<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form>
<%@page import="java.sql.*,GetConnection.*" %>
<table border="4" align="center" bgcolor="orange"><tr><th colspan="8">final Results</th></tr>
<tr><th>Uid</th><th>Name</th><th>Post</th><th>Photo</th><th>Qualified</th>
</tr>
<%try{
	Connection cn=GetData.getCn();
	
	String sql="select * from logincheck2 where qual='y'";	//*restset is req for select statement.
	PreparedStatement ps=cn.prepareStatement(sql);
		
	ResultSet rs=ps.executeQuery();
			while(rs.next()){%>
	<tr>	
	<td><%=rs.getString(1)%></td>
	<td><%=rs.getString(2)%></td>
	<td><%=rs.getString(3)%></td>
	<td><img src="<%=rs.getString(4)%>"></td>
	<td><%=rs.getString(5)%></td>
	
</tr>
			
			<% }%>
<%}catch(Exception e){System.out.println(e);} %><tr>

</form>
</body>
</html>