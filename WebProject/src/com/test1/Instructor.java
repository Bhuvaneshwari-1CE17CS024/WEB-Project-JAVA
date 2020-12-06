package com.test1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Commander
 */
@WebServlet("/Instructor")
public class Instructor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Instructor() {
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
			String code="internship";
			response.setContentType("text/html");  
			PrintWriter out = response.getWriter(); 
			
			int a=Integer.parseInt(request.getParameter("instructor_numb"));         
			String b=request.getParameter("instructor_name");   
			String c=request.getParameter("security_clearence");
			
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/project","root","root");  
			  
			PreparedStatement ps=con.prepareStatement("insert into instructor values(?,?,?)");  
			  
			ps.setInt(1,a);  
			ps.setString(2,b);  
			ps.setString(3,c);  
			          
			int i=ps.executeUpdate();  
			if(c.equals(code))
	        {
	           RequestDispatcher rd = request.getRequestDispatcher("CollegeForm.html");
	           rd.forward(request, response);
	        }
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("Home.html");
		           rd.forward(request, response);
			}
			out.close();  
			       
			}catch (Exception e2) {System.out.println(e2);} 
			

	}

}
