package com.music.CatalogService.service;

import com.music.CatalogService.Exceptions.ServiceException;
import com.music.CatalogService.dao.CatalogDbDAO;
import com.music.CatalogService.dao.DownloadDAO;
import com.music.CatalogService.dao.ProductDAO;
import com.music.CatalogService.domain.*;
import com.music.CatalogService.service.data.CartItemData;
import com.music.CatalogService.service.data.DownloadData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Service
public class CatalogServiceImpl implements CatalogService {
    private CatalogDbDAO catalogDbDAO;

    private DownloadDAO downloadDb;

    private ProductDAO prodDb;

    @Autowired
    public void setCatalogDbDAO(CatalogDbDAO catalogDbDAO) {
        this.catalogDbDAO = catalogDbDAO;
    }

    @Autowired
    public void setDownloadDb(DownloadDAO downloadDb) {
        this.downloadDb = downloadDb;
    }

    @Autowired
    public void setProdDb(ProductDAO prodDb) {
        this.prodDb = prodDb;
    }

    public Set<Product> getProductList() throws ServiceException {
        Connection connection = null;
        try {
            connection = catalogDbDAO.startTransaction();
            Set<Product> prodList = prodDb.findAllProducts(connection);
            catalogDbDAO.commitTransaction(connection);
            return prodList;
        } catch (Exception e) {
            catalogDbDAO.rollbackAfterException(connection);
            throw new ServiceException("Can't find product list in db: ", e);
        }
    }

    public Cart createCart() {
        return new Cart();
    }

    public Set<CartItemData> getCartInfo(Cart cart) throws ServiceException {
        Set<CartItemData> items = new HashSet<CartItemData>();
        Connection connection = null;
        try {
            connection = catalogDbDAO.startTransaction();
            for (CartItem item : cart.getItems()) {
            	System.out.println(item.getQuantity());
                Product product = prodDb.findProductById(connection, item.getProductId());
                CartItemData itemData = new CartItemData(item.getProductId(), item.getQuantity(), product.getCode(),
                        product.getDescription(), product.getPrice());
                items.add(itemData);
            }
            catalogDbDAO.commitTransaction(connection);
        } catch (Exception e) {
            catalogDbDAO.rollbackAfterException(connection);
            throw new ServiceException("Can't find product in cart: ", e);
        }
        return items;

    }

    public void addItemtoCart(long productId, Cart cart, int quantity) {
        System.out.println("The product Quantity is:=" + quantity);
        CartItem item = cart.findItem(productId);
        if (item != null) {
            int qty = item.getQuantity();
            item.setQuantity(qty + quantity);
//            System.out.println("Item Inserted");
        } else {
            item = new CartItem(productId, quantity);
            cart.getItems().add(item);
        }
    }

    public void changeCart(long productId, Cart cart, int quantity) {
        CartItem item = cart.findItem(productId);
        if (item != null) {
            if (quantity > 0) {
                item.setQuantity(quantity);
            } else {
                cart.removeItem(productId);
            }
        }
    }

    public void removeCartItem(long productId, Cart cart) {
        CartItem item = cart.findItem(productId);
        if (item != null) {
            cart.removeItem(productId);
        }
    }

    public Product getProduct(long productId) throws ServiceException {
        Connection connection = null;
        try {
            connection = catalogDbDAO.startTransaction();
            Product prd = prodDb.findProductById(connection, productId);
            if (prd == null)
                return null;
            for (Track track : prd.getTracks())
                track.getSampleFilename();
            catalogDbDAO.commitTransaction(connection);
            return prd;
        } catch (Exception e) {
            catalogDbDAO.rollbackAfterException(connection);
            throw new ServiceException("Error accessing product " + productId, e);
        }
    }

    public Product getProductByCode(String prodCode) throws ServiceException {
        Connection connection = null;
        Product prd = null;
        try {
            connection = catalogDbDAO.startTransaction();
            prd = prodDb.findProductByCode(connection, prodCode);
//            for (Track track : prd.getTracks())
//                track.getSampleFilename();
            catalogDbDAO.commitTransaction(connection);
        } catch (Exception e) {
            catalogDbDAO.rollbackAfterException(connection);
            throw new ServiceException("Error accessing product " + prodCode, e);
        }
        return prd;
    }

    public void addDownload(String emailAddress, Track track) throws ServiceException {
        Connection connection = null;
        try {
            connection = catalogDbDAO.startTransaction();
            Download download = new Download();
            download.setEmailAddress(emailAddress);
            download.setTrack(track);
            download.setDownloadDate(new Date());
            downloadDb.insertDownload(connection, download);
            catalogDbDAO.commitTransaction(connection);
        } catch (Exception e) {
            catalogDbDAO.rollbackAfterException(connection);
            throw new ServiceException("Can't add download: ", e);
        }
    }

    public void initializeDB() throws ServiceException {
        try {
            catalogDbDAO.initializeDb();
        } catch (Exception e) {
            throw new ServiceException(
                    "Can't initialize DB: (probably need to load DB)", e);
        }
    }

    public Set<DownloadData> getListofDownloads() throws ServiceException {
        Connection connection = null;

        Set<Download> downloads = null;
        try {
            connection = catalogDbDAO.startTransaction();
            downloads = downloadDb.findAllDownloads(connection);
            catalogDbDAO.commitTransaction(connection);
        } catch (Exception e) {
            catalogDbDAO.rollbackAfterException(connection);
            throw new ServiceException("Can't find download list: ", e);
        }
        Set<DownloadData> downloads1 = new HashSet<DownloadData>();
        for (Download d : downloads) {
            downloads1.add(new DownloadData(d));
        }
        return downloads1;
    }

	@Override
	public void clearDownloads() throws ServiceException {
		Connection connection = null;
		
		try {
			connection = catalogDbDAO.startTransaction();
			downloadDb.clearDownloads(connection);
			catalogDbDAO.commitTransaction(connection);
		}catch(Exception e) {
			catalogDbDAO.rollbackAfterException(connection);
			throw new ServiceException("Cannot clear Downloads"+e);
		}
	}
}
