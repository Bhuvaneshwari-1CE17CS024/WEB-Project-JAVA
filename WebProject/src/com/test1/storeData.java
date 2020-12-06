package com.test1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class storeData
 */
@WebServlet("/storeData")
public class storeData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public storeData() {
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
		try {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		int m=Integer.parseInt(request.getParameter("usn"));
		String n=request.getParameter("name");
		int o=Integer.parseInt(request.getParameter("join_yr"));
		int p=Integer.parseInt(request.getParameter("pass_yr"));
		String q=request.getParameter("choice0");
		String r=request.getParameter("choice1");
		String s=request.getParameter("choice2");
		String t=request.getParameter("choice3");
		String u=request.getParameter("choice4");
		String v=request.getParameter("choice5");

		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/project","root","root");  
		  
		PreparedStatement ps=con.prepareStatement(  
		"insert into student values(?,?,?,?,?,?,?,?,?,?)");  
		  
		     ps.setInt(1,m); 
			 ps.setString(2,n);
			 ps.setInt(3,o); 
			 ps.setInt(4,p); 
			 ps.setString(5,q);
			 ps.setString(6,r);
			 ps.setString(7,s);
			 ps.setString(8,t);
			 ps.setString(9,u);
			 ps.setString(10,v);
			
			int i=ps.executeUpdate();  
			if(i>0)
			{
				out.println("<html>"
						+ "<img src=\"images/StoreData.jpg\" style=\"z-index:-1;position:fixed;width:100%;height:100%\"/>"
						+" <h1><b><center><font size=7 color=black>SUCCESS PAGE</font></center></h1><br><br>");
				out.println("<font size=6 color=white>Successfully Registered</font><br><br><br><br>");
				out.println("<html><form method=post action=Home.html>"
						+ "<input type=submit name=submit value=Back></form>"
						+"<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>"
						+"<blockquote><footer><i><center><font size=7 color=white>'The harder you work for something, the greater you'll feel when you achieve it.'\r\n</font></center></i></footer></blockquote>"
						+ "</html>");
			}
			
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  	
	}
}
