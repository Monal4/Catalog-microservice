package com.music.CatalogService.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

public class Invoice implements Serializable {

	private static final long serialVersionUID = 1L;
	private long invoiceId;
	private User user;
	private Date invoiceDate;
	private BigDecimal totalAmount;
	private boolean isProcessed;
	private Set<LineItem> lineItems;
	
	public Invoice() {}
	
	public Invoice(long id, User u, Date d, boolean isProc, Set<LineItem> items, BigDecimal totAmount) {
		invoiceId = id;
		user = u;
		invoiceDate = d;
		isProcessed = isProc;
		lineItems = items;
		totalAmount = totAmount;
	}
	
	public long getInvoiceId() {
		return invoiceId;
	}
	
	public void setInvoiceId(long invoice_id) {
		this.invoiceId = invoice_id;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setLineItems(Set<LineItem> items) {
		lineItems = items;
	}

	public Set<LineItem> getLineItems() {
		return lineItems;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totAmount) {
		this.totalAmount = totAmount;
	}

	public boolean isProcessed() {
		return isProcessed;
	}

	public void setProcessed(boolean isProcessed) {
		this.isProcessed = isProcessed;
	}
	
	// calculate the invoice total
//	public BigDecimal calculateTotal() {
//		BigDecimal total = new BigDecimal(0);
//		for (LineItem item: lineItems){
//			 total = total.add(item.calculateItemTotal());	
//		}
//		return total;
//	}
}
