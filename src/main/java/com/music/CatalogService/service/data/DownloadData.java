package com.music.CatalogService.service.data;

import com.music.CatalogService.domain.Download;

import java.io.Serializable;
import java.util.Date;

public class DownloadData implements Serializable {

	private static final long serialVersionUID = 1L;
	private String emailAddress;
	private String productCode;
	
	private Date downloadDate;
	private String trackTitle;

	public DownloadData() {
	}
	
	public DownloadData(Download d) {
		emailAddress = d.getEmailAddress();
		productCode = d.getTrack().getProduct().getCode();
		downloadDate = d.getDownloadDate();
		trackTitle = d.getTrack().getTitle();		
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}
	
	public String getProductCode() {
		return productCode;
	}

	public String getTrackTitle() {
		return trackTitle;
	}

	public Date getDownloadDate() {
		return downloadDate;
	}

}
