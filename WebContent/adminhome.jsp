<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Applicant List</title>
</head>
<body>
<%@page import="java.sql.*,GetConnection.*" %>
<form action="list"> 


Welcome
<%session=request.getSession(false);
String user=(String) session.getAttribute("admin");
%><font color="blue"><%=user %></font>

<a href="Destroy">Logout</a>


<table border="4" align="center" bgcolor="cyan"><tr><th colspan="8">Written Test Results</th></tr>
<tr><th>Uid</th><th>Name</th><th>Email</th><th>Post</th><th>Experience</th><th>Photo</th><th>Qualified</th><th>Failed</th>
</tr>
<%try{
	Connection cn=GetData.getCn();
	
	String sql="select * from AD1";	//*restset is req for select statement.
	PreparedStatement ps=cn.prepareStatement(sql);
		
	ResultSet rs=ps.executeQuery();
			while(rs.next()){%>
	<tr>	
	<td><%=rs.getString(1)%></td>
	<td><%=rs.getString(2)%></td>
	<td><%=rs.getString(3)%></td>
	<!--  <td><%=rs.getString(4)%></td> -->
	<td><%=rs.getString(5)%></td>
	<td><%=rs.getString(6)%></td>
	<td><img src="<%=rs.getString(7)%>"></td>
	<td><input type="checkbox" name="qual" value=<%=rs.getString(1)%>></td>
	<td><input type="checkbox" name="fail" value=<%=rs.getString(1)%>></td>
</tr>
			
			<% }%>
<%}catch(Exception e){System.out.println();} %><tr>
<td colspan="8" align="center"><input type="submit" value="list"></td></tr>
</table>
</form>
</body>
</html>
