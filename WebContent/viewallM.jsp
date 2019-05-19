<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
String id = request.getParameter("uid");
String driver = "com.mysql.cj.jdbc.Driver";
String connectionUrl = "jdbc:mysql://dhananjayananya.cvmeotigpunf.ap-south-1.rds.amazonaws.com:3306/";
String database = "DhananjayAnanya";
String userid = "DhananjayAnanya";
String password = "3B61b82e";
try {
Class.forName(driver);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" type="text/css" href="dashboard.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.4.1/css/all.css">

<body>
<h2>ALL CUSTOMERS LOAN DETAILS </h2>
	<nav class="side-menu">
		<ul>
			<li><a href="viewbyuseridm.html">View Loan By User<span><i
						class="fa fa-eye"></i></span></a></li>

			<li><a href="managerdashboard.html">back<span><i
						class="fa  fa-arrow-left"></i></span></a></li>
<li><a href="san.jsp">Change status<span><i
						class="fas fa-bed"></i></span></a></li>

			<li><a href="index.html">Log Out<span><i
						class="fa fa-key"></i></span></a></li>


		</ul>
	</nav>
<table border="1">
<tr>
<th>APPLICATION ID</th>
<th>LOAN ID</th>
<th>USER ID</th>
<th>AMOUNT</th>
<th>INSTALLMENT</th>
<th>PERIOD</th>
<th>STATUS</th>
</tr>
<%
try{
connection = DriverManager.getConnection(connectionUrl+database, userid, password);
statement=connection.createStatement();
String sql ="select * from viewdetails";
resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<tr>
<td><%=resultSet.getString("applicationid") %></td>
<td><%=resultSet.getString("loanid") %></td>
<td><%=resultSet.getString("userid") %></td>
<td><%=resultSet.getString("amount") %> Rs</td>
<td><%=resultSet.getString("installment") %> Rs/month</td>
<td><%=resultSet.getString("period") %> yrs</td>
<td><%=resultSet.getString("stauts") %></td>
</tr>
<%
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
</table>
</body>
</html>