package controller;
import java.sql.*;
import GetConnection.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Check
 */
@WebServlet("/Check")
public class Check extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			Connection cn=GetData.getCn();
			PrintWriter out=response.getWriter();
			String adid=request.getParameter("adid");
			String adps=request.getParameter("adps");
			System.out.println("ok");
			System.out.println(adid);
			System.out.println(adps);
			String sql="select uid from AD1 where uid=? and pass=?";
			PreparedStatement ps=cn.prepareStatement(sql);
			ps.setString(1, adid);
			ps.setString(2, adps);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()){
				System.out.println("Applicant login successful ");
				HttpSession session=request.getSession();
				session.setAttribute("adid","adps");
				out.print("<a href='applicanthome.jsp'>Go to Home</a>");
			}
			else if(adid.equals("admin")&& adps.equals("admin")){
				HttpSession session=request.getSession();
				session.setAttribute("admin","admin");
				System.out.println("Prasun is right.");
				out.print("<a href='adminhome.jsp'>Go to Home</a>");
			}
			else {
				out.print("<font color='red'>Wrong user id or pass</font>");
				RequestDispatcher rd=request.getRequestDispatcher("Login.html");
				rd.include(request,response);
			}
			
			
			
			
		}
		catch(Exception e){System.out.print(e);}
		
	}

}
