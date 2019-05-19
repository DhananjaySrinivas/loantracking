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
<h2>Customer Dashboard</h2>
	<nav class="side-menu">
		<ul>
			<li><a href="custdashboard.html">back<span><i
						class="fa fa-arrow-left"></i></span></a></li>

			<li><a href="applyloan.html">Apply For Loan<span><i
						class="fas fa-book"></i></span></a></li>
<li><a href="knowstatus.html">Know status<span><i
						class="fa fa-question"></i></span></a></li>

			<li><a href="index.html">Log Out<span><i
						class="fa fa-key"></i></span></a></li>


		</ul>
	</nav>


<%
try{
connection = DriverManager.getConnection(connectionUrl+database, userid, password);
statement=connection.createStatement();
String sql ="select * from viewdetails where applicationid ='"+request.getParameter("id")+"' ";
resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>

<div class="loa">
<P >
LOAN ID :- <%=resultSet.getString("loanid") %><br>
TYPE :-Not Specified<br>
PAYMENT PERIOD :- <%=resultSet.getString("period") %> years<br>
RATE OF INTREST:- 1.25%<br>
SPECIAL FEATURE:-  10% CASHBACK</p>
</div>
<%
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
</body>
</html>