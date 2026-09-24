
package com.sunilos.p4.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.sunilos.p4.exception.DatabaseException;

/**
 * JDBC DataSource is a Data Connection Pool
 *
 * @author Durgesh Lohiya
 * @version 1.0 Copyright (c) Rays EdTech
 */
public final class JDBCDataSource {

	/**
	 * JDBC Database connection pool (DCP)
	 */
	private static JDBCDataSource datasource;

	private ComboPooledDataSource cpds = null;

	/**
	 * Private constructor
	 */
	private JDBCDataSource() {
	}

	/**
	 * Create instance of Connection Pool
	 *
	 * @return JDBCDataSource instance
	 */
	public static JDBCDataSource getInstance() {

		if (datasource == null) {

			ResourceBundle rb = ResourceBundle.getBundle("com.sunilos.p4.bundle.system");

			datasource = new JDBCDataSource();
			datasource.cpds = new ComboPooledDataSource();

			try {

				// Set JDBC Driver
				datasource.cpds.setDriverClass(rb.getString("driver"));

				/*
				 * Database URL
				 *
				 * Docker: DATABASE_URL=jdbc:mysql://mysql:3306/project04
				 *
				 * Local: jdbc:mysql://localhost:3306/project04
				 */
				String dbUrl = System.getenv("DATABASE_URL");

				if (dbUrl == null || dbUrl.trim().isEmpty()) {
					dbUrl = rb.getString("url.local");
				}

				datasource.cpds.setJdbcUrl(dbUrl);

				// Database username
				datasource.cpds.setUser(rb.getString("username"));

				// Database password
				datasource.cpds.setPassword(rb.getString("password"));

				// Connection Pool Configuration
				datasource.cpds.setInitialPoolSize(DataUtility.getInt(rb.getString("initialPoolSize")));

				datasource.cpds.setAcquireIncrement(DataUtility.getInt(rb.getString("acquireIncrement")));

				datasource.cpds.setMaxPoolSize(DataUtility.getInt(rb.getString("maxPoolSize")));

				datasource.cpds.setMaxIdleTime(DataUtility.getInt(rb.getString("timeout")));

				datasource.cpds.setMinPoolSize(DataUtility.getInt(rb.getString("minPoolSize")));

			} catch (Exception e) {

				e.printStackTrace();

				throw new DatabaseException("Database connection pool initialization failed: " + e.getMessage());
			}
		}

		return datasource;
	}

	/**
	 * Gets the connection from ComboPooledDataSource
	 *
	 * @return connection
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		return getInstance().cpds.getConnection();
	}

	/**
	 * Closes a connection
	 *
	 * @param connection connection object
	 */
	public static void closeConnection(Connection connection) {

		if (connection != null) {

			try {
				connection.close();

			} catch (SQLException e) {

				throw new DatabaseException("Connection close exception " + e.getMessage());
			}
		}
	}

	/**
	 * Rollback transaction
	 *
	 * @param connection connection object
	 */
	public static void rollBack(Connection connection) {

		if (connection != null) {

			try {
				connection.rollback();

			} catch (SQLException e) {

				e.printStackTrace();

				throw new DatabaseException("Rollback exception " + e.getMessage());
			}
		}
	}
}
