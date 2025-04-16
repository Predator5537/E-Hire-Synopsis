package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import GetConnection.GetData;

/**
 * Servlet implementation class ResultCheck
 */
@WebServlet("/ResultCheck")
public class ResultCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			try{
		
			Connection cn=GetData.getCn();
			PrintWriter out=response.getWriter();
			String uid=request.getParameter("uid");
			String upass=request.getParameter("apass");
			System.out.println("ok");
			String sql="select uid from AD1 where uid=? and pass=?";
			PreparedStatement ps=cn.prepareStatement(sql);
			ps.setString(1, uid);
			ps.setString(2, upass);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				String sql2="select uid from logincheck where uid=? and qual=y";
				PreparedStatement ps2=cn.prepareStatement(sql2);
				ps2.setString(1, uid);
				ResultSet rs2=ps2.executeQuery();
				if(rs2.next()){
					out.println("Congratulations, you have passed the written test selection.");
				}}
				if(rs.next()){
					String sql3="select uid from logincheck2 where uid=? and qual=y";
					PreparedStatement ps3=cn.prepareStatement(sql3);
					ps3.setString(1, uid);
					ResultSet rs3=ps3.executeQuery();
					if(rs3.next()){
						out.println("Congratulations, you have passed the final interview.");
					}	
				}}
			
			
			
		catch(Exception e){System.out.println(e);}

}}
