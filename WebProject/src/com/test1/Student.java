package com.test1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Student
 */
@WebServlet("/Student")
public class Student extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Student() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter ps = response.getWriter();
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");
			String sql ="select * from college";
			Statement st = con.createStatement();
			ps.println("<html>"
					+ "<img src=\"images/Student.png\" style=\"z-index:-1;position:fixed;width:100%;height:100%\"/>"
					+" <h1><b><center><font size=7 color=black>STUDENT REGISTRATION</font></center></b><br></h1>");
			ps.println("<form method=post action=storeData>"
					+
					"<font size=6 color=black>USN:<input type='text' name='usn'/>\r\n" + 
					"<font size=6 color=black>STUDENT NAME:<input type='text' name='name'/>\r\n" + 
					"<font size=6 color=black>JOINED YEAR:<input type='text' name='join_yr'/>\r\n" + 
					"<font size=6 color=black>PASSING YEAR:<input type='text' name='pass_yr'/></font><br>"
					+ ""
					+ "<h1><font size=6 color=black>College Name</h1><select name=choice0></font>");
			ResultSet rs = st.executeQuery(sql);
			while(rs.next())
			{
				
				ps.print("<option>"+rs.getString(1)+"</option>");
			}
			ps.println("</select>");
			
			String sql1 ="select * from college";
			Statement st1 = con.createStatement();
			ps.println("<h1><font size=6 color=black>College Location</h1><select name=choice1></font>");
			ResultSet rs1 = st1.executeQuery(sql1);
			while(rs1.next())
			{
				
				ps.print("<option>"+rs1.getString(2)+"</option>");
			}
			ps.println("</select>");
			
			String sql2 ="select * from course";
			Statement st2 = con.createStatement();
			ps.println("<h1><font size=6 color=black>Course Name</h1><select name=choice2></font>");
			ResultSet rs2 = st2.executeQuery(sql2);
			while(rs2.next())
			{
				
				ps.print("<option>"+rs2.getString(1)+"</option>");
			}
			ps.println("</select>");
			
			String sql3 ="select * from course";
			Statement st3 = con.createStatement();
			ps.println("<h1><font size=6 color=black>Well Known Language</h1><select name=choice3></font>");
			ResultSet rs3 = st3.executeQuery(sql3);
			while(rs3.next())
			{
				
				ps.print("<option>"+rs3.getString(2)+"</option>");
			}
			ps.println("</select>");
			
			String sql4 ="select * from internship";
			Statement st4 = con.createStatement();
			ps.println("<h1><font size=6 color=black>Domain</h1><select name=choice4></font>");
			ResultSet rs4 = st4.executeQuery(sql4);
			while(rs4.next())
			{
				
				ps.print("<option>"+rs4.getString(1)+"</option>");
			}
			ps.println("</select>");
			
			String sql5 ="select * from internship";
			Statement st5 = con.createStatement();
			ps.println("<h1><font size=6 color=black>Project Topic</h1><select name=choice5></font>");
			ResultSet rs5 = st5.executeQuery(sql5);
			while(rs5.next())
			{
				
				ps.print("<option>"+rs5.getString(2)+"</option>");
			}
			
			
			ps.println("</select><br><br><input type=submit name=submit value=Register></form></html>");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
