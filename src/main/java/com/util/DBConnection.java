package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	public static Connection getConnection() {
		try {
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/eqapp";
			String username = "root";
			String password = "root";

			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, username, password);
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
