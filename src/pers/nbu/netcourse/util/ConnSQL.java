package pers.nbu.netcourse.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnSQL {

	private String user = "sa";
	private String password = "123456";
	private Statement stmt = null;
	private Connection con = null;
	
	
	public Statement getStmt() {
		return stmt;
	}

	public void setStmt(Statement stmt) {
		this.stmt = stmt;
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
	public ConnSQL() {
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * 打开数据库连接
	 */
	public void openSQL() {
		String JDriver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String connectDB = "jdbc:sqlserver://127.0.0.1:1433;databaseName=AIOC";
		/*Connection con = null;
		Statement stmt = null;*/
		try {
			Class.forName(JDriver);
		} 
		catch (ClassNotFoundException e) {
			System.out.println("数据库加载失败");
			System.exit(0);
		}
		try {
			System.out.println("数据库连接成功");
			con = DriverManager.getConnection(connectDB, user, password);
			stmt = con.createStatement();
		} 
		catch (SQLException e) {
			System.out.println("数据库连接出错");
		}
	}
	
	
	/**
	 * 执行SQL语句
	 */
	public void execute(String SQL) {
		try {
			stmt.execute(SQL);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
	}
	public ResultSet executeQuery(String SQL) {
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(SQL);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		return rs;
	}
	
	/**
	 * 关闭数据库连接
	 */
	public void closeSQL()
	{
		try {
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("数据库连接出错");
		}
	}
	
}
