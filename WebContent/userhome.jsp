<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style type="text/css">
a:link, a:visited {
    background-color: #f44336;
    color: white;
    padding: 14px 25px;
    text-align: center;	
    text-decoration: none;
    display: inline-block;
}


a:hover, a:active {
    background-color: red;
}

</style>
<body>
<table align="right">
<tr>
<td><b>Welcome:&nbsp&nbsp</b></td>
<td>
<%
session=request.getSession(false);
String Cid=(String)session.getAttribute("Cid");
%>
<%=Cid %>
&nbsp&nbsp
</td>
<td><a href="UserLogout">Logout</a></td>
</tr>
</table>

<table align="center">
<tr>
<td><a href="freespace.jsp">Book Space</a></td><td><a href="profile.jsp">MyProfile</a></td>

</tr>

</table>
<br><br>
<table align="center">
<tr>
<td align="center">
<img  src="storage.jpg" height="400" width="400">
</td>
</tr>
</table>
</body>
</html>