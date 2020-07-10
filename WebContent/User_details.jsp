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
<table border="4">
<tr><th colspan="5">Customer Information</th></tr>
<tr><th>Customer Id</th><th>Customer password</th><th>Customer Name</th><th>Customer address</th><th>Customer Phone</th></tr>
<li><a href="Admin_Home.html">Go Back</a></li>
<%
try{
	Connection cn=GetData.getCn();
	String sql="select * from customer";
	PreparedStatement ps=cn.prepareStatement(sql);
	ResultSet rs=ps.executeQuery();
	while(rs.next()){
		
%>
<tr>
<td><%=rs.getString(1) %></td>
<td><%=rs.getString(2) %></td>
<td><%=rs.getString(3) %></td>
<td><%=rs.getString(4) %></td>
<td><%=rs.getString(5) %></td>
</tr>
<%} %>
<%}catch(Exception e){
	System.out.println(e);
	}%>
</table>
</body>
</html>