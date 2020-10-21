package com.music.CatalogService.domain;

import java.io.Serializable;
import java.util.Date;

public class Download implements Serializable {
	private static final long serialVersionUID = 1L;
	private long id;
	private String emailAddress;
	private Track track;

	private Date downloadDate;

	public Download() {
		emailAddress = null;
		downloadDate = new Date();
	}

	public long getDownloadId() {
		return id;
	}

	public void setDownloadId(long download_id) {
		this.id = download_id;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}
	
	public void setEmailAddress(String email) {
		emailAddress = email;
	}
	public Track getTrack() {
		return track;
	}

	public void setTrack(Track track) {
		this.track = track;
	}

	public Date getDownloadDate() {
		return downloadDate;
	}

	public void setDownloadDate(Date download_date) {
		this.downloadDate = download_date;
	}

}
