package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbconnection.GetData;

/**
 * Servlet implementation class SessionServlet
 */
@WebServlet("/SessionServlet")
public class SessionServlet extends HttpServlet {
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
			String sql="select Spsize from stud where Spid=?";
			PreparedStatement ps=cn.prepareStatement(sql);
			ps.setString(1, Spid);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				HttpSession ses=request.getSession();
				ses.setAttribute("name", rs.getString(1));
				RequestDispatcher rd=request.getRequestDispatcher("Serv");
				rd.forward(request, response);
			}else{
				out.println("id not found...");
				RequestDispatcher rd=request.getRequestDispatcher("SessionSearch");
				rd.include(request, response);
			}
		}catch(Exception e){
			System.out.println(e);
		}
	}

}
