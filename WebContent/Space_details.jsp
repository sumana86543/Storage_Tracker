<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%@page import="java.sql.*,dbconnection.*" %>
<body>
<table border="1">
<tr><th colspan="4">Space Information</th></tr>
<tr><th>Space Id</th><th>Space size</th><th>Space rent</th><th>Space status</th></tr>
<li><a href="Admin_Home.html">Go Back</a></li>
<%
try{
	Connection cn=GetData.getCn();
	String sql="select * from space";
	PreparedStatement ps=cn.prepareStatement(sql);
	ResultSet rs=ps.executeQuery();
	while(rs.next()){
		
%>
<tr>
<td><%=rs.getString(1) %></td>
<td><%=rs.getString(2) %></td>
<td><%=rs.getString(3) %></td>
<td><%=rs.getString(4) %></td>
</tr>
<%} %>
<%}catch(Exception e){
	System.out.println(e);
	}%>
</table>
</body>
</html>