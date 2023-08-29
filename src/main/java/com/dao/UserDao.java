package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bean.UserBean;
import com.util.DBConnection;

public class UserDao {
	public void addUser(UserBean user) {
		try {
			Connection conn = com.util.DBConnection.getConnection();
			PreparedStatement pstmt = conn
					.prepareStatement("insert into users (firstName, email, password, role) values (?, ?, ?, ?)");
			pstmt.setString(1, user.getFirstName());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getPassword());
			pstmt.setString(4, user.getRole());

			int row = pstmt.executeUpdate();
			System.out.println("number of rows affected " + row);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public UserBean authenticate(String email, String password) {
		try {

			Connection conn = DBConnection.getConnection();
			// below query will check email and password for user
			// it will search for given email and password if match then it return data in
			// rs
			PreparedStatement pstmt = conn.prepareStatement("select * from users where email = ? and password = ?");
			pstmt.setString(1, email);
			pstmt.setString(2, password);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				UserBean user = new UserBean();
				user.setFirstName(rs.getString("firstName"));
				user.setUserId(rs.getInt("userId"));
				user.setEmail(email);
				user.setPassword(password);
				user.setRole(rs.getString("role"));

				return user;// user's email and password match
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
