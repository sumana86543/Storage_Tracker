package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminLog
 */
@WebServlet("/AdminLog")
public class AdminLog extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			PrintWriter out=response.getWriter();
			String aid=request.getParameter("aid");
			String apass=request.getParameter("apass");
			if((aid.equals("admin"))&&(apass.equals("admin"))){
				RequestDispatcher rd=request.getRequestDispatcher("Admin_Home.html");
				rd.forward(request, response);
				
			}else{
				out.print("wrong id and password");
				RequestDispatcher rd=request.getRequestDispatcher("Admin_Log.html");
				rd.include(request, response);
				
			}
		}catch(Exception e){
			System.out.println(e);
		}
	}

}
