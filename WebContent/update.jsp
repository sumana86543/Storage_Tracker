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
<form action="Update">
<%
try{
	
	String Spid=request.getParameter("Spid");
	Connection cn=GetData.getCn();
	String sql="select Spid,Spsize,Sprent,Spstatus from space where Spid=?";
	PreparedStatement ps=cn.prepareStatement(sql);
	ps.setString(1, Spid);
	ResultSet rs=ps.executeQuery();
	if(rs.next()){
		session=request.getSession();
		session.setAttribute("Spid",rs.getString(1));
%>
	<table border="1" bgcolor="cyan">
	<tr><th colspan="2">Update information</th></tr>
	<tr><th>Space Id :</th><th><%=rs.getString(1) %></th></tr>
	<tr><th>Space Size:</th><th><input type="text" name="Spsize" value=<%=rs.getString(2)%>></th></tr>
	<tr><th>Space Rent:</th><th><input type="text" name="Sprent" value=<%=rs.getString(3)%>></th></tr>
	<tr><th>Space Status:</th><th><input type="text" name="Spstatus" value=<%=rs.getString(4)%>></th></tr>
	<tr><th colspan="2"><input type="submit" value="Update"></th></tr>
	</table>
	<%}else{
	%>
	<font color="red">No record found</font>
	<%} %>
<%}catch(Exception e){
	
}%>
</body>
</html>