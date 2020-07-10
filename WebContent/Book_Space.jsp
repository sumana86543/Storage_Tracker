<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Connection"%>
<!DOCTYPE html PUBLIC>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table align="center">
<tr>
<td>
<img  src="space.jpg" height="400" width="400">
</td>
</tr>
</table>
<table border="4" align="center">

<tr>
<th>Space Id</th>
<th>Size</th>
<th>Rent</th>
<th>Status</th>
</tr>
<%@page import="dbconnection.*,java.sql.*,java.util.*" %>
<%try{
		
	Connection cn=GetData.getCn();
	
	String sql="select * from space where spstatus='free'";
	PreparedStatement ps=cn.prepareStatement(sql);
	ResultSet rs=ps.executeQuery();
	while(rs.next()){ 
	
%>
	<tr>
	<td><%=rs.getString(1) %></td><td><%=rs.getString(2) %></td>
	<td><%=rs.getString(3) %></td><td><%=rs.getString(4) %></td>
	</tr>
<%} %>
		<%}catch(Exception e){
			e.printStackTrace();
		}%>
	
	

</table>
<%
session=request.getSession(false);
String Cid=(String)session.getAttribute("Cid");
%>
<form action="BookSpace">
<%
Date d=new Date();
SimpleDateFormat sd=new SimpleDateFormat("dd-MM-yyyy");
String date=sd.format(d);
%>
<table align="center" border="4">
<tr>
<th>Space Id </th>
<td>
<select name="spid">
<option>---Select From Here---</option>
<%
try{
Connection cn=GetData.getCn();
PreparedStatement p=cn.prepareStatement("select Spid from space");
ResultSet r=p.executeQuery();
while(r.next()){
%>
<option><%=r.getString(1) %></option>
<%} %>
<%}catch(Exception e){
	e.printStackTrace();
} %>
</select>
</td>
</tr>
<td>User Id :</td><td><input type="text" name="Cid" value=<%=Cid %> readonly="readonly"></td>
</tr>
<tr>
<td>Date :</td><td><input type="date" name="date" value=<%=date%> readonly="readonly"></td>
</tr>
<tr>


<td colspan="2" align="center"><input type="submit" value="Book"></td>
</tr>

</table>
</form>
</body>
</html>