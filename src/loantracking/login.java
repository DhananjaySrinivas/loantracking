package loantracking;
import com.mysql.*;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.swing.JOptionPane;

import java.io.*;

public class login extends HttpServlet{
	
	String name;
	String password;
	

	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		String s=request.getParameter("name");
		String s1=request.getParameter("password");
		 System.out.println(s);
		 System.out.println(s1);
     
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection con = DriverManager.getConnection("jdbc:mysql://dhananjayananya.cvmeotigpunf.ap-south-1.rds.amazonaws.com:3306/DhananjayAnanya","DhananjayAnanya","3B61b82e");
			Statement stmt=con.createStatement();
			String pas="select * from customerreg where name='"+s+"' and password='"+s1+"'";
			ResultSet se=stmt.executeQuery(pas);
			
			
			while(se.next())
			{	
			name=se.getString(1);
			 password=se.getString(5);
		}
			 if (name.equals(s) && password.equals(s1)) 
			 {	
				 System.out.println("login successfull");
				 response.getWriter().append("Served at: ").append(request.getContextPath());
				 RequestDispatcher rd = request.getRequestDispatcher("custdashboard.html");
			        rd.forward(request, response);
			  
		}
			 else
			 {
				 System.out.println("Failure");
			 
			 }
			
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	}
    