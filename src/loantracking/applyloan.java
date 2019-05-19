package loantracking;
import com.mysql.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.*;
import java.util.Random;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;


public class applyloan extends HttpServlet{
	  private static final SimpleDateFormat sdf = new SimpleDateFormat("MMddHHmmss");
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		String l=request.getParameter("lid");
		String u=request.getParameter("uid");
		String A=request.getParameter("amneed");
		long insta=Integer.parseInt(A);
		String s="Not Sanctioned";
		System.out.println(l);
		System.out.println(u);
		System.out.println(A);
	Random Ran=new Random();
	int per=Ran.nextInt(9);
	int b=per*12;
      long In= insta/b;
		 Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	String Ap=sdf.format(timestamp);
	String[] monthNames = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};
	String aid=monthNames[per+2]+Ap;
	System.out.println(aid);
	System.out.println(In);
	System.out.println(per);
	System.out.println(b	);


response.sendRedirect( "apply.jsp?name='"+u+"'" );

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		    Connection con = DriverManager.getConnection("jdbc:mysql://dhananjayananya.cvmeotigpunf.ap-south-1.rds.amazonaws.com:3306/DhananjayAnanya","DhananjayAnanya","3B61b82e");
			Statement stmt=con.createStatement();
			
			String st="Insert into viewdetails values('"+aid+"','"+l+"','"+u+"','"+A+"','"+In+"','"+per+"','"+s+"')";
			stmt.execute(st);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}

