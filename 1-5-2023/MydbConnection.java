package com.dal.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MydbConnection {
	static Connection con;
	public static Connection getMyConnection() {
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "admin");
		//System.out.println(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getMyConnection());
		
	}

}
