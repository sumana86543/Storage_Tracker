package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;
import dbconnection.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbconnection.GetData;

/**
 * Servlet implementation class Delete
 */
@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			PrintWriter out=response.getWriter();
			Connection cn=GetData.getCn();
			String Spid=request.getParameter("Spid");
			String sql="delete from space where Spid=?";
			
			PreparedStatement pc=cn.prepareStatement(sql);
			pc.setString(1, Spid);
			pc.execute();
			
			out.print("Deletion Successful");
			RequestDispatcher rd=request.getRequestDispatcher("Delete_space.html");
			rd.include(request, response);
			
	}catch(Exception e){
		System.out.println(e);

	}
	}}
