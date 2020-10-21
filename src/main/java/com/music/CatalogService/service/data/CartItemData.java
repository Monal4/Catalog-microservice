package com.music.CatalogService.service.data;

import java.math.BigDecimal;

public class CartItemData {

	private long productId;
	private int quantity;
	private String code;
	private String description;
	private BigDecimal price;

	public CartItemData() {}
	
	public CartItemData(long productId, int quantity, String code, String description, BigDecimal price) {
		this.productId = productId;
		this.quantity = quantity;
		this.code = code;
		this.description = description;
		this.price = price;
	}
	
	public long getProductId() {
		return productId;
	}

	public int getQuantity() {
		return quantity;
	}
	
	public String getDescription() {
		return description;
	}

	public String getCode() {
		return code;
	}

	public BigDecimal getPrice() {
		return price;
	}

}
