package controller;
import GetConnection.*;
import java.sql.*;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import GetConnection.GetData;

/**
 * Servlet implementation class Signup2
 */
@WebServlet("/Signup2")
public class Signup2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			Connection cn=GetData.getCn();
			String dob=request.getParameter("udob");
			String age=request.getParameter("uage");
			String lsname=request.getParameter("usname");
			String saddr=request.getParameter("usaddr");
			String marks=request.getParameter("usper");
			String qual=request.getParameter("uqual");
			String gen=request.getParameter("gen");
			String paddr=request.getParameter("uaddr");
			String pin=request.getParameter("upin");
			String state=request.getParameter("ustate");
			String height=request.getParameter("uheg");
			String bmark=request.getParameter("umark");
			String mob=request.getParameter("umob");
			String fname=request.getParameter("fname");
			String fqual=request.getParameter("fqual");
			String mname=request.getParameter("mname");
			String mqual=request.getParameter("mqual");
			String name=request.getParameter("name");
			String ph=request.getParameter("uph");
			String sql="insert into AD2 values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps=cn.prepareStatement(sql);
			ps.setString(2, dob);
			ps.setString(3, age);
			ps.setString(4, lsname);
			ps.setString(5, saddr);
			ps.setString(6, marks);
			ps.setString(7, qual);
			ps.setString(8, gen);
			ps.setString(9, paddr);
			ps.setString(10, pin);
			ps.setString(11, state);
			ps.setString(12, height);
			ps.setString(13, bmark);
			ps.setString(14, fname);
			ps.setString(15, fqual);
			ps.setString(16, mname);
			ps.setString(17, mob);
			ps.setString(1, name);
			ps.setString(18, ph);
			ps.execute();
		RequestDispatcher rd=request.getRequestDispatcher("index.html");
		rd.include(request, response);
		
		}
		catch(Exception e){System.out.println(e);}
		
	}

}
