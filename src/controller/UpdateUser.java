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
import javax.servlet.http.HttpSession;

import dbconnection.GetData;

/**
 * Servlet implementation class UpdateUser
 */
@WebServlet("/UpdateUser")
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			PrintWriter out=response.getWriter();
			String Cid=request.getParameter("Cid");
			String Cname=request.getParameter("Cname");
			String Cpass=request.getParameter("Cpass");
			String Caddr=request.getParameter("Caddr");
			String Cphn=request.getParameter("Cphn");
			
			HttpSession s=request.getSession(false);
			String Cpid=(String)s.getAttribute("Cid");
			Connection cn=GetData.getCn();
			String sql="update customer set Cname=?,Cpass=?,Caddr=?,Cphn=? where Cid=?";
			PreparedStatement ps=cn.prepareStatement(sql);
			ps.setString(1, Cname);
			ps.setString(2, Cpass);
			ps.setString(3, Caddr);
			ps.setString(4, Cphn);
			ps.setString(5, Cid);

			ps.execute();
			out.print("record updated");
			RequestDispatcher rd=request.getRequestDispatcher("Update_User.html");
			rd.include(request, response);
		}catch(Exception e){
			System.out.println(e);
			
		}
	}

}
