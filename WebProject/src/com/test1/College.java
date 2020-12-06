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
 * Servlet implementation class Division
 */
@WebServlet("/College")
public class College extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public College() {
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
			
			String a=request.getParameter("college_name");         
			String b=request.getParameter("college_loc");   
		
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/project","root","root");  
			  
			PreparedStatement ps=con.prepareStatement(  
			"insert into college values(?,?)");  
			  
			ps.setString(1,a);  
			ps.setString(2,b);   
			          
			int i=ps.executeUpdate();  
			
	           RequestDispatcher rd = request.getRequestDispatcher("CourseForm.html");
	           rd.forward(request, response);
	                 
			out.close();  
			       
			}catch (Exception e2) {System.out.println(e2);} 
			

	}

}
