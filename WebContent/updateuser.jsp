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
<form action="UpdateUser">
<%
try{
	
	String Cid=request.getParameter("Cid");
	Connection cn=GetData.getCn();
	String sql="select Cid,Cname,Cpass,Caddr,Cphn from customer where Cid=?";
	PreparedStatement ps=cn.prepareStatement(sql);
	ps.setString(1, Cid);
	ResultSet rs=ps.executeQuery();
	if(rs.next()){
		session=request.getSession();
		session.setAttribute("Cid",rs.getString(1));
%>
	<table border="1" bgcolor="cyan">
	<tr><th colspan="2">Update information</th></tr>
	<tr><td><font color="red">User ID (not changable) :</td></font><td><input type="text" name="Cid" value=<%=rs.getString(1) %> readonly="readonly"></td></tr>
	<tr><th>Customer Name:</th><th><input type="text" name="Cname" value=<%=rs.getString(2)%> readonly="readonly"></th></tr>
	<tr><th>Customer Password:</th><th><input type="text" name="Cpass" value=<%=rs.getString(3)%>></th></tr>
	<tr><th>Customer Address:</th><th><input type="text" name="Caddr" value=<%=rs.getString(4)%>></th></tr>
	<tr><th>Customer Phone Number:</th><th><input type="text" name="Cphn" value=<%=rs.getString(5)%> readonly="readonly"></th></tr>
	<tr><th colspan="2"><input type="submit" value="Update"></th></tr>
	</table>
	<%}else{
	%>
	<font color="red">No record found</font>
	<%} %>
<%}catch(Exception e){
	
}%>
</body>
</body>
</html>