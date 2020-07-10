package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbconnection.*;

/**
 * Servlet implementation class BookSpace
 */
@WebServlet("/BookSpace")
public class BookSpace extends HttpServlet {
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
			String Cid=request.getParameter("Cid");
			String Spdate=request.getParameter("Spdate");
			
			String sql1="insert into booking values(?,?,?)";
			String sql2="update space set Spstatus='booked' where Spid=?";
			
			PreparedStatement ps=cn.prepareStatement(sql1);
			ps.setString(1, Spid);
			ps.setString(2, Cid);
			ps.setString(3, Spdate);
			
			ps.execute();
			
			PreparedStatement ps1=cn.prepareStatement(sql2);
			ps1.setString(1, Spid);
			ps1.execute();
			
			out.println("Space Booked...");
			RequestDispatcher rd=request.getRequestDispatcher("User_Home.html");
			rd.include(request, response);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
