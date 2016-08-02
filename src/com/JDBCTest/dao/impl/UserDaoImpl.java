package com.JDBCTest.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;

import com.JDBCTest.dao.UserDao;
import com.JDBCTest.entity.User;
import com.mysql.jdbc.PreparedStatement;

public class UserDaoImpl implements UserDao {
  /**
   * 保存用户信息.
   * */
	@Override
	public void save(Connection conn, User user) throws SQLException {
		PreparedStatement ps = (PreparedStatement) conn
				.prepareCall("INSERT INTO tbl_user(name,password,email) VALUES(?,?,?)");
		
		ps.setString(1, user.getName());
		ps.setString(2, user.getPassword());
		ps.setString(3, user.getEmail());
		ps.execute();
				
	}

	
	 /**
	   * 根据用户指定的ID更新用户信息.
	   * */
	@Override
	public void update(Connection conn, Long id, User user) throws SQLException {
		String updateSql = "UPDATE tbl_user SET name = ?,password = ?,email = ? WHERE id = ?";
		PreparedStatement ps = (PreparedStatement) conn.prepareStatement(updateSql);
		
		ps.setString(1, user.getName());
		ps.setString(2, user.getPassword());
		ps.setString(3, user.getEmail());
		ps.setLong(4,id);
		ps.execute();

	}
	 /**
	   * 删除指定的用户信息.
	   * */
	@Override
	public void delete(Connection conn, User user) throws SQLException {
		PreparedStatement ps = (PreparedStatement) conn.prepareStatement("DELETE FROM tbl_user WHERE id = ?");
		ps.setLong(1, user.getId());
		ps.execute();
	}

}
