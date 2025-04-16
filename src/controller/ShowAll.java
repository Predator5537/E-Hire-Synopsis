package controller;
import GetConnection.*;
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Executable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowAll
 */
@WebServlet("/ShowAll")
public class ShowAll extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			PrintWriter out=response.getWriter();
			Connection cn=GetData.getCn();
			String showall="select uid,pass from AD1";
			PreparedStatement ps=cn.prepareStatement(showall);
			ResultSet rs=ps.executeQuery();
				while(rs.next()){
					out.println((rs.getString(1))+" "+(rs.getString(2))+"<br>");
					
					
				}
			
		}
		catch(Exception e){
			System.out.println(e);
		}
		
		
		
	}
}
