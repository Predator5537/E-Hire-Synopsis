package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import GetConnection.GetData;

/**
 * Servlet implementation class list
 */
@WebServlet("/List2")
public class List2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			Connection cn=GetData.getCn();
			String qual[]=request.getParameterValues("qual");
			String fail[]=request.getParameterValues("fail");
		System.out.println(qual);
		for(String x:qual){
			String sql="select uid,name,post,photo from logincheck where uid=?";
			PreparedStatement ps=cn.prepareStatement(sql);
			ps.setString(1, x);
			ResultSet rs=ps.executeQuery();
			
	
		if(rs.next()){
			System.out.println("qualified");
			String sql2="insert into logincheck2 values(?,?,?,?,?,?)";
			PreparedStatement pos=cn.prepareStatement(sql2);
			pos.setString(1, rs.getString(1));
			pos.setString(2, rs.getString(2));
			pos.setString(3, rs.getString(3));
			pos.setString(4, rs.getString(4));
			pos.setString(5, "y");
			pos.setString(6, "");
			pos.execute();
		}
		
		}
		
		
		for(String x:fail){
			String sql="select uid,name,post,photo from logincheck where uid=?";
			PreparedStatement pos=cn.prepareStatement(sql);
			pos.setString(1, x);
			ResultSet ros=pos.executeQuery();
			
	
		if(ros.next()){
			System.out.println("not qualified");
			String sql2="insert into logincheck2 values(?,?,?,?,?,?)";
			PreparedStatement poos=cn.prepareStatement(sql2);
			poos.setString(1, ros.getString(1));
			poos.setString(2, ros.getString(2));
			poos.setString(3, ros.getString(3));
			poos.setString(4, ros.getString(4));
			poos.setString(5, "");
			poos.setString(6, "y");
			poos.execute();
			
		}}
		RequestDispatcher rd=request.getRequestDispatcher("index.html");
		rd.include(request,response);
		}
		catch(Exception e){System.out.println(e);}
		
		
	}

}
