package controller;
import java.sql.*;
import dbconnection.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Insert
 */
@WebServlet("/Insert")
public class Insert extends HttpServlet {
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
			String Spsize=request.getParameter("Spsize");
			String Sprent=request.getParameter("Sprent");
			String Spstatus=request.getParameter("Spstatus");
			String sql="insert into Space values(?,?,?,?)";
			
			PreparedStatement pc=cn.prepareStatement(sql);
			pc.setString(1, Spid);
			pc.setString(2, Spsize);
			pc.setString(3, Sprent);
			pc.setString(4, "free");
			pc.execute();
			
			out.print("your information is saved");
			RequestDispatcher rd=request.getRequestDispatcher("Add_space.html");
			rd.include(request, response);
			
			
			//System.out.println("Database connected...");
			//System.out.println("SID"+(int)(Math.random()*10000));
			
			
			}catch(Exception e){
			System.out.println(e);
		}
	}

}
