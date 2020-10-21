package com.music.CatalogService.domain;

public class LineItem {

	private long id;
	private String productCode;
	private int quantity;
	private Invoice invoice; 

	public LineItem() {}

	public LineItem(long id, String productCode, Invoice invoice, int quantity) {
		this.id = id;
		this.productCode = productCode;
		this.invoice = invoice;
		this.quantity = quantity;
	}
	
	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public long getId() {
		return id;
	}

	public void setId(long lineitem_id) {
		this.id = lineitem_id;
	}

	public void setInvoice(Invoice inv){
		this.invoice = inv;
	}
	
	public Invoice getInvoice(){
		return invoice;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

//	public BigDecimal calculateItemTotal() {
//		// We can't use * to multiply with BigDecimal, but it knows how--
//		BigDecimal total = product.getPrice().multiply(new BigDecimal(quantity));
//		return total;
//	}

}
