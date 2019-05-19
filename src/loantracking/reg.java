package loantracking;
import com.mysql.*;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.*;
import java.util.Random;
import java.text.SimpleDateFormat;
import java.util.Date;

public class reg extends HttpServlet{
	  private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		String s=request.getParameter("name");
		String s1=request.getParameter("address");
		String s2=request.getParameter("phonenumber");
		String s3=request.getParameter("password");
		System.out.println(s);
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		 Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	String T=sdf.format(timestamp);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection con = DriverManager.getConnection("jdbc:mysql://dhananjayananya.cvmeotigpunf.ap-south-1.rds.amazonaws.com:3306/DhananjayAnanya","DhananjayAnanya","3B61b82e");
			Statement stmt=con.createStatement();
			
			String st="Insert into customerreg values('"+s+"','"+s1+"','"+s2+"','"+T+"','"+s3+"')";
			stmt.execute(st);
			 response.getWriter().append("Served at: ").append(request.getContextPath());
			 RequestDispatcher rd = request.getRequestDispatcher("Customer.html");
		        rd.forward(request, response);

		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	

}

