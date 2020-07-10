package controller;
import java.sql.*;
import dbconnection.*;
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

import dbconnection.GetData;

/**
 * Servlet implementation class Search2
 */
@WebServlet("/Search2")
public class Search2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			PrintWriter out=response.getWriter();
			Connection cn=GetData.getCn();
			String sid=request.getParameter("sid");
			String sql="select*from stud where sid=?";
			PreparedStatement pc=cn.prepareStatement(sql);
			pc.setString(1, sid);
			ResultSet rs=pc.executeQuery();
			if(rs.next()){
				out.print("record found");
				RequestDispatcher rd=request.getRequestDispatcher("Search.html");
				rd.include(request,response);

			}else{
				out.print("record not found");
				RequestDispatcher rd=request.getRequestDispatcher("Search.html");
				rd.include(request,response);
			}
			}catch(Exception e){
			System.out.println(e);
		}
	}

}
