package com.kitm.Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class DatabaseDriver {
	//Database connection instance
	private Connection connection;

	private static final Logger logger = Logger.getLogger(DatabaseDriver.class.getName());

	/*
	 * Manage connection to database
	 */
	public DatabaseDriver() {
		try {
			this.connection = DriverManager.getConnection("jdbc:sqlite:library.db");
			logger.info("Connected to database");
		} catch (SQLException e) {
			logger.severe("Error connecting to database: " + e.getMessage());
		}
	}

	/*
	 * Get connection to database
	 * @return the connection
	 */
	public Connection getConnection() {
		return connection;
	}

	/*
	 * Close connection to database
	 */
	public void closeConnection() {
		try {
			//Close the connection if not already closed
			connection.close();
		} catch (SQLException e) {
			logger.severe("Error closing database connection: " + e.getMessage());
		}
	}
}
