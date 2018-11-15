package com.iotek.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlClose {

	public static void sqlclose(Statement stm,Connection con){
		try {
			stm.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
