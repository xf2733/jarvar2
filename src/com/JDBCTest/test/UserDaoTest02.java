package com.JDBCTest.test;

import java.sql.Connection;

import com.JDBCTest.dao.UserDao;
import com.JDBCTest.dao.impl.UserDaoImpl;
import com.JDBCTest.entity.User;
import com.JDBCTest.util.ConnectionFactory;

public class UserDaoTest02 {

	public static void main(String[] args) {
		Connection conn = null;
		try {
			conn = ConnectionFactory.getInstance().makeConnection();
			conn.setAutoCommit(false);
			
			UserDao userDao = new UserDaoImpl();
			User tom = new User();
			tom.setId((long) 4);
			
			
			userDao.delete(conn, tom);
			
			conn.commit();
			
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

}
