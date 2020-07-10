package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import dbconnection.*;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbconnection.GetData;

/**
 * Servlet implementation class User_Insert
 */
@WebServlet("/User_Insert")
public class User_Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			PrintWriter out=response.getWriter();
			Connection cn=GetData.getCn();
			String Cid="CID"+(int)(Math.random()*10000);
			String Cpass=request.getParameter("Cpass");
			String Cname=request.getParameter("Cname");
			String Caddr=request.getParameter("Caddr");
			String Cphn=request.getParameter("Cphn");
			String sql="insert into customer values(?,?,?,?,?)";
			
			PreparedStatement pc=cn.prepareStatement(sql);
			pc.setString(1, Cid);
			pc.setString(2, Cpass);
			pc.setString(3, Cname);
			pc.setString(4, Caddr);
			pc.setString(5, Cphn);
			pc.execute();
			
			out.print("your id is:  "+Cid);
			RequestDispatcher rd=request.getRequestDispatcher("UserLog.html");
			rd.include(request, response);
			
			
			//System.out.println("Database connected...");
			//System.out.println("SID"+(int)(Math.random()*10000));
			
			
			}catch(Exception e){
			System.out.println(e);
		}
	}

}
