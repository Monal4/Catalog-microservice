package com.music.CatalogService.dao;

import com.music.CatalogService.domain.Download;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import static com.music.CatalogService.dao.DBConstants.DOWNLOAD_TABLE;
import static com.music.CatalogService.dao.DBConstants.SYS_TABLE;

@Repository
public class DownloadDAO {
	@Autowired
	private ProductDAO proddb;

	private void advanceDownloadID(Connection connection) throws SQLException
	{
		Statement stmt = connection.createStatement();
		try {
			stmt.executeUpdate(" update " + SYS_TABLE
					+ " set download_id = download_id + 1");
		} finally {
			stmt.close();
		}
	}

	private int getNextDownloadID(Connection connection) throws SQLException
	{
		int nextDID;
		Statement stmt = connection.createStatement();
		try {
			ResultSet set = stmt.executeQuery(" select download_id from " + SYS_TABLE);
			set.next();
			nextDID = set.getInt("download_id");
		} finally {
			stmt.close();
		}
		advanceDownloadID(connection);
		return nextDID;
	}

	public void insertDownload(Connection connection, Download download) throws SQLException {
		Statement stmt = connection.createStatement();
		int download_id = getNextDownloadID(connection);
		download.setDownloadId(download_id);
		try{
			String sqlString = "insert into "+ DOWNLOAD_TABLE + " values (" +
			download.getDownloadId() + ", '" + 
			download.getEmailAddress() + "', " + 
			"current_timestamp" +
			", " +  download.getTrack().getId() + ")" ;
			stmt.execute(sqlString);
		} finally {
			stmt.close();
		}
	}

	public Set<Download> findAllDownloads(Connection connection)throws SQLException {
		Download download=null;
		Set<Download> downloads = new HashSet<Download>();
		Statement stmt = connection.createStatement();
		String sqlString = "select * from "+ DOWNLOAD_TABLE + 
		     " order by download_date";
		try{
			ResultSet set = stmt.executeQuery(sqlString);
			while (set.next()){
				download = new Download();
				download.setDownloadId(set.getInt("download_id"));
				download.setDownloadDate(set.getTimestamp("download_date"));
				download.setEmailAddress(set.getString("email_address"));
				download.setTrack(proddb.findTrackByTID(connection,set.getInt("track_id")));
				downloads.add(download);
			}
		} finally{
			stmt.close();
		}
		return downloads;
	}
	
	public void clearDownloads(Connection connection) throws SQLException {
		
		String sql = "DELETE FROM "+ DOWNLOAD_TABLE;
		Statement stmt = connection.createStatement();
		
		try {
			stmt.executeQuery(sql);
		}finally {
			stmt.close();
		}
	}
}
