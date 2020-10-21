package com.music.CatalogService.domain;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

public class Cart {

	private static final long serialVersionUID = 1L;
	private Set<CartItem> items;
	private ReentrantLock lock = new ReentrantLock();
    
	public Cart() {
		items = new HashSet<CartItem>();
	}
	
	public Set<CartItem> getItems() {
		return items;
	}
	
	public CartItem findItem(long productId) {
		for (CartItem i : items) {
			if (i.getProductId() == productId) {
				return i;
			}
		}
		return null;
	}

	public void addItem(CartItem item) {
		if (items == null) {
			items = new HashSet<CartItem>();
		}
		// If the item already exists in the cart, only the quantity is changed.
		long prodId = item.getProductId();
		int quantity = item.getQuantity();

		for (CartItem l : items) {
			if(l.getProductId() == prodId) {
				lock.lock();
				try {
					l.setQuantity(quantity+1);
					return;
				}finally {
					lock.unlock();
					}
				}
			}
		
			items.add(item);
		}

	public void removeItem(long productId) {

		for (CartItem l : items) {
			if (l.getProductId() == productId) {
				lock.lock();
				try {
					items.remove(l);
					return;
				}finally {
					lock.unlock();
				}
			}
		}
	}
	
	public void clear() {
		lock.lock();
		
		try {
			items.clear();
		}finally {
			lock.unlock();
		}
	}
}