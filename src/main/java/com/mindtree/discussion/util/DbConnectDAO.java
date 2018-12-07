package com.mindtree.discussion.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mindtree.discussion.exception.util.db.DBException;

public class DbConnectDAO implements DbConstant {
	public static Connection connect() throws DBException {

		Connection connection = null;
		try {
			connection = DriverManager.getConnection(url, user, password);
			// System.out.println("Connection Successful");
		} catch (SQLException e) {
			String msg = "ConnectionNotEstablished";
			throw new DBException(msg, e);
		}

		return connection;
	}

	static void disConnect(Connection connection) throws DBException {

		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				String msg = "SQL Disconnect Exception";
				throw new DBException(msg, e);
			}
		}
	}

}
