package controller;
import java.sql.*;
import GetConnection.*;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class Signup2
 */
@WebServlet("/Signup1")
@MultipartConfig(fileSizeThreshold=1024*1024*2,maxFileSize=1024*1024*30,maxRequestSize=1024*1024*50)
public class Signup1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SAVE_DIR="image";
	
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try
		{
		    PrintWriter out = response.getWriter();
			String name=request.getParameter("uname");
			String email=request.getParameter("uemail");
			String pass=request.getParameter("upass");
			String exp=request.getParameter("exp");
			String imgPath=null;
			String id=request.getParameter("upost");
			String uid=null;
			String post=id;
		
			if(id.equals("technical"))
			{System.out.print("Technical Section");
			uid="t"+((int)(Math.random()*10000));
		
			}
			else if(id.equals("mangement"))
			{System.out.print("Management Section");
			uid="m"+((int)(Math.random()*10000));
			
			}
			else if(id.equals("clerical"))
			{System.out.print("Clerical Section");
			uid="c"+((int)(Math.random()*10000));
			
			}
			System.out.println(name);
			System.out.println(pass);
			System.out.println(uid);
			System.out.println(exp);
			System.out.println(post);
			System.out.println(email);
			try{
				Connection con=GetData.getCn();
				//parsing the picture
				String filePath="D:"+File.separator+SAVE_DIR;
				File directory =new File(filePath);
				if(!directory.exists()){
					directory.mkdir();
					}
					Part part=request.getPart("photo");
					String path=extractPath(part);
					String fileName=path.substring(path.lastIndexOf("\\")+1,path.length());
					imgPath=filePath+File.separator+fileName;
					part.write(imgPath);
					System.out.println(imgPath);
					String sql="insert into AD1 values(?,?,?,?,?,?,?)";
					
					PreparedStatement pos=con.prepareStatement(sql);
			
					pos.setString(1, uid);
					pos.setString(2, name);
					pos.setString(4, pass);
					pos.setString(3, email);
					pos.setString(5, post);
					pos.setString(6, exp);
					pos.setString(7, imgPath);
				
			        pos.execute();
			out.print("This is your uid:"+uid+"<br>This is your password."+pass);   
			RequestDispatcher rd=request.getRequestDispatcher("Signup2.html");
			rd.include(request,response);}
			catch(Exception e){System.out.println(e);}
			
		 }
		catch(Exception e){System.out.println(e);}
		
		
		
		
	}

	private String extractPath(Part part){
		String condis=part.getHeader("Content-Disposition");
		String [] item=condis.split(";");
		for(String x:item){
			if(x.trim().startsWith("filename")){
			return	x.substring(x.indexOf("=")+2,x.length()-1);
			}
			
		}
	return null;
	}
	
}

