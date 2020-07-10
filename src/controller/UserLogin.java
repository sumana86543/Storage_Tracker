package controller;

import java.io.IOException;
import java.io.PrintWriter;
import dbconnection.*;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbconnection.GetData;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			PrintWriter out=response.getWriter();
			String Cid=request.getParameter("Cid");
			String Cpass=request.getParameter("Cpass");
			Connection cn=GetData.getCn();
			String sql="select Cid,Cpass from customer where Cid=? and Cpass=?";
			PreparedStatement ps=cn.prepareStatement(sql);
			ps.setString(1, Cid);
			ps.setString(2, Cpass);
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()){
				HttpSession ses1=request.getSession();
				ses1.setAttribute("Cid", rs.getString(1));
				HttpSession ses2=request.getSession();
				ses2.setAttribute("Cpass", rs.getString(2));
				RequestDispatcher rd=request.getRequestDispatcher("User_Home.html");
				rd.forward(request, response);
				
			}else{
				out.println("<script>alert('wrong id or password');</script>");
				RequestDispatcher rd=request.getRequestDispatcher("WELCOME.html");
				rd.include(request, response);
			}
			
		}catch(Exception e){
			System.out.println(e);
		}
	}

}
