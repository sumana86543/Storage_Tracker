package controller;

import java.io.IOException;
import dbconnection.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.io.PrintWriter;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			PrintWriter out=response.getWriter();
			String Spsize=request.getParameter("Spsize");
			String Sprent=request.getParameter("Sprent");
			String Spstatus=request.getParameter("Spstatus");
			HttpSession s=request.getSession(false);
			String Spid=(String)s.getAttribute("Spid");
			Connection cn=GetData.getCn();
			String sql="update space set Spsize=?,Sprent=?,Spstatus=? where Spid=?";
			PreparedStatement ps=cn.prepareStatement(sql);
			ps.setString(1, Spsize);
			ps.setString(2, Sprent);
			ps.setString(3, Spstatus);
			ps.setString(4, Spid);
			ps.execute();
			out.print("record updated");
			RequestDispatcher rd=request.getRequestDispatcher("Update_Space.html");
			rd.include(request, response);
		}catch(Exception e){
			System.out.println(e);
			
		}
	}

}
