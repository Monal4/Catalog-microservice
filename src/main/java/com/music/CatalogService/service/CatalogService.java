package com.music.CatalogService.service;

import com.music.CatalogService.Exceptions.ServiceException;
import com.music.CatalogService.domain.Cart;
import com.music.CatalogService.domain.Product;
import com.music.CatalogService.domain.Track;
import com.music.CatalogService.service.data.CartItemData;
import com.music.CatalogService.service.data.DownloadData;

import java.util.Set;

public interface CatalogService {

    Set<Product> getProductList() throws ServiceException;

    Cart createCart();

    Set<CartItemData> getCartInfo(Cart cart) throws ServiceException;

    void addItemtoCart(long productId, Cart cart, int quantity);

    void changeCart(long productId, Cart cart, int quantity);

    void removeCartItem(long productId, Cart cart);

    Product getProduct(long productId) throws ServiceException;

    Product getProductByCode(String prodCode) throws ServiceException;

    void addDownload(String emailAddress, Track track) throws ServiceException;

    void initializeDB()throws ServiceException;

    Set<DownloadData> getListofDownloads() throws ServiceException;

    void clearDownloads() throws ServiceException;

}
