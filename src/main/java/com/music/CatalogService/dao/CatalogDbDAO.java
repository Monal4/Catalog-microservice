package com.music.CatalogService.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static com.music.CatalogService.dao.DBConstants.DOWNLOAD_TABLE;
import static com.music.CatalogService.dao.DBConstants.SYS_TABLE;

@Repository
public class CatalogDbDAO {
	@Autowired
	private DataSource dataSource;  
	@Autowired
	private DbUtils dbUtil;

	public CatalogDbDAO(DbUtils dbUtil, DataSource ds) throws SQLException {
		this.dataSource = ds;
		this.dbUtil = dbUtil;
	}

	public void initializeDb() throws SQLException {
		Connection connection = dataSource.getConnection();
		dbUtil.clearTable(connection, DOWNLOAD_TABLE);
		initSysTable(connection);
		connection.close();
	}

	private void initSysTable(Connection connection) throws SQLException {
		Statement stmt = connection.createStatement();
		try {
			stmt.execute("update " + SYS_TABLE + " set download_id = 1");
		} finally {
			stmt.close();
		}
	}
	
	public Connection startTransaction() throws SQLException {
		Connection connection = dataSource.getConnection();
		connection.setAutoCommit(false);
		return connection;
	}

	public void commitTransaction(Connection connection) throws SQLException {
		connection.commit();
		connection.close();
	}

	public void rollbackTransaction(Connection connection) throws SQLException {
		connection.rollback();
		connection.close();
	}

	public void rollbackAfterException(Connection connection) {
		try {
			rollbackTransaction(connection);
		} catch (Exception e) {

		}
		try {
			connection.close();
		} catch (Exception e) {

		}
	}

}
