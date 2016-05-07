<%@page import="java.sql.ResultSet"%>
<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%@ page import="java.util.*" %>
<%@ page import="java.sql.*" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
    <body>
  <%
  
  		String user = "sa";
		String password = "123456";
		Statement stmt = null;
		Connection con = null;
  		String JDriver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String connectDB = "jdbc:sqlserver://127.0.0.1:1433;databaseName=AIOC";
		
		Class.forName(JDriver);
		con = DriverManager.getConnection(connectDB, user, password);
		stmt = con.createStatement();
		
		ResultSet rs = stmt.executeQuery("select  * from TeaStatus");
		
		while(rs.next()){
    		String stuno=rs.getString(1);
    		//String stuname=rs.getString("stuname");
    		out.print(stuno+" "+"<br>");
    	}

%>
 
  

    This is my JSP page. <br>
  </body>
</html>
