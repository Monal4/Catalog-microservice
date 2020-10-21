package com.music.CatalogService.dao;

import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@Repository
public class DbUtils {

	public DbUtils() {
	}

	public void clearTable(Connection connection, String tableName) throws SQLException {
		System.out.println("Clearing table " + tableName);
		Statement stmt = connection.createStatement();
		try {
			stmt.execute("delete from " + tableName);
		} finally {
			stmt.close();
		}
	}

}
