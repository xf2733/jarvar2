package com.JDBCTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Statement;

public class JDBCTest01 {

	public static void main(String[] args) {
		
		String sql = "SELECT * FROM tbl_user";
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp_db","root","123456");
			
			st = (Statement) conn.createStatement();
			rs = st.executeQuery(sql);
			
			while(rs.next()){
				System.out.print(rs.getInt("id") + "  ");
				System.out.print(rs.getString("name") + "　");
				System.out.print(rs.getString("password") + " ");
				System.out.print(rs.getString("email" )+ "　");
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
			} catch (Exception e2) {
			}
			try {
				st.close();
			} catch (Exception e3) {
			}
			try {
				conn.close();
			} catch (Exception e4) {
			}
		}
	}
}
