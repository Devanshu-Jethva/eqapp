package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.bean.EquityBean;
import com.util.DBConnection;

public class EquityDao {

	public void addEquity(EquityBean eq) {
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("insert into equity (name,price) values (?,?)");
			pstmt.setString(1, eq.getName());
			pstmt.setFloat(2, eq.getPrice());

			pstmt.executeUpdate();// insert update delete

		} catch (Exception e) {

		}
	}

	public void updateEquity(EquityBean eq) {
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("update equity set price = ? where name = ? ");
			pstmt.setFloat(1, eq.getPrice());
			pstmt.setString(2, eq.getName());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<EquityBean> getEquity() {
		ArrayList<EquityBean> list = new ArrayList<EquityBean>();
		try {
			Connection conn = DBConnection.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from equity;");

			while (rs.next()) {
				EquityBean equityBean = new EquityBean();
				equityBean.setEquityId(rs.getInt(1));
				equityBean.setName(rs.getString(2));
				equityBean.setPrice(rs.getFloat(3));
				list.add(equityBean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}