package com.test1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Vision
 */
@WebServlet("/Vision")
public class Vision extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Vision() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try
		{
			response.setContentType("text/html");  
			PrintWriter out = response.getWriter();    
						
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/project","root","root"); 
			
			int a=Integer.parseInt(request.getParameter("usn"));     
			
			PreparedStatement ps=con.prepareStatement("select * from student where usn=?");
			ps.setInt(1,a);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				out.println("<html>"
						+"<img src='images/Vision.png' style='z-index:-1;position:fixed;width:100%;height:100%'/>"
						+" <h1><b><center><font size=7 color=black>STUDENT DETAILS</font></center></h1><br><br><font size=6 color=black>STUDENT USN= ");
				out.println(rs.getInt(1)+"<br>STUDENT NAME= "+rs.getString(2)+"<br>JOINING YEAR=  "+rs.getInt(3)+"<br>PASS YEAR= "+rs.getInt(4)+"<br>COLLEGE NAME= "+rs.getString(5)+"<br>COLLEGE LOCATION= "+rs.getString(6)+"<br>COURSE NAME= "+rs.getString(7)+"<br>WELL KNOWN LANGUAGE= "+rs.getString(8)+"<br>DOMAIN= "+rs.getString(9)+"<br>PROJECT TOPIC= "+rs.getString(10));
				out.println("<br><form method=post action=Home.html></font>"
						+ "<input type=submit name=submit value=Back></form>"
						+"<br><br><blockquote><footer><i><center><font size=7 color=black>\"Work to become, not to acquire.\r\n" + 
						"\"\r\n" + 
						"</font></center></i></footer></blockquote>"
						+ "</html>");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}
}
