package com.iotek.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlConnect {

	public static Connection sqlconnect(){
		String JDBCDriver = "com.mysql.jdbc.Driver";
		String conURL = "jdbc:mysql://localhost:3306/studentMessage";
		
		try {
			Class.forName(JDBCDriver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Connection con = DriverManager.getConnection(conURL,"root","123456");
			return con;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
