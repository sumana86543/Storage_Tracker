<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@page import="java.sql.*,dbconnection.*" %>
<form action="Update">
<%
try{
	Connection cn=GetData.getCn();
	session=request.getSession(false);
	String Cid=(String)session.getAttribute("Cid");
	PreparedStatement ps=cn.prepareStatement("select * from space where Cid=?");
	ps.setString(1, Cid);
	ResultSet rs=ps.executeQuery();
	while(rs.next()){
%>
<table align="center">
<tr>
<td rowspan="2">
<img  src="background.jpg">
</td>
<td>
<fieldset>
<legend>Personal Information</legend>
<table id="info">
<tr><td><font color="red">User ID (not changable) :</td></font><td><input type="text" name="Cid" value=<%=rs.getString(1) %> readonly="readonly"></td></tr>
<tr><td>Password :</td><td><input type="text" name="pwd" value=<%=rs.getString(2) %>></td></tr>
<tr><td><font color="red">Name (not changable) :</font></td><td><input type="text" name="Cname" value=<%=rs.getString(3) %> readonly="readonly"></td></tr>
<tr><td>Address :</td><td><input type="text" name="Caddr" value=<%=rs.getString(4) %>></td></tr>
<tr><td>Email :</td><td><input type="text" name="Cphn" value=<%=rs.getString(5) %>></td></tr>
<tr><td colspan="2" align="center"><input type="submit" value="Update"></td></tr>
</table>
</fieldset>
<%} %>
<%}catch(Exception e){
	e.printStackTrace();
	}%>

</td>
</tr>
<tr>
<td>
<fieldset>
<legend>Transaction Details :</legend>
<table id="booking" border="1">
<%
try{
	Connection cn=GetData.getCn();
	session=request.getSession(false);
	String Cid=(String)session.getAttribute("Cid");
	PreparedStatement ps=cn.prepareStatement("select booking.Spid,booking.Spdate,space.Sprent from booking,space where booking.Spid=space.Spid and booking.Cid=?");
	ps.setString(1, Cid);
	ResultSet rs=ps.executeQuery();
	if(rs.next()){
%>
<tr><td>Space ID :</td><td><%=rs.getString(1) %></td></tr>
<tr><td>Date Of Booking :</td><td><%=rs.getString(2) %></td></tr>
<tr><td>Cost :</td><td><%=rs.getString(3) %></td></tr>
<%} %>
</table>
</fieldset>
</td>
</tr>
<%}catch(Exception e){
	e.printStackTrace();
} %>
</table>
</form>
</body>
</html>