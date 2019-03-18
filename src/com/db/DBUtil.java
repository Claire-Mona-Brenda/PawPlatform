package com.db;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class DBUtil {
	private static Connection conn=null;
	private static final String URL="jdbc:mysql://127.0.0.1/pawdb?user=root&password=753zxc&characterEncoding=utf-8&useSSL=false";
	
	static{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(URL);
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
	public static Connection getConnection(){
		return conn;
	}

}
