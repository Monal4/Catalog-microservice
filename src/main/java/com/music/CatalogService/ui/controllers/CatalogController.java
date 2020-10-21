package com.music.CatalogService.ui.controllers;


import com.music.CatalogService.Exceptions.ServiceException;
import com.music.CatalogService.domain.Cart;
import com.music.CatalogService.domain.Product;
import com.music.CatalogService.service.CatalogService;
import com.music.CatalogService.service.data.CartItemData;
import com.music.CatalogService.service.data.DownloadData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.condition.ProducesRequestCondition;

import javax.print.attribute.standard.Media;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.MediaType;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

@RestController
public class CatalogController{

    private CatalogService catalogService;
    

    @Autowired
    public void setCatalogService(CatalogService catalogService) {
        this.catalogService = catalogService;
    }
    
    @GetMapping("/getAllDownloads")
    public Set<DownloadData> getAllDownloads() throws ServletException{
    	try {
			return catalogService.getListofDownloads();
		} catch (ServiceException e) {
			throw new ServletException(e);
		}
    }

    @GetMapping("/createCart")
    public Cart getCart() {
        return catalogService.createCart();
    }
    
    @PostMapping("/cart/save/{productId}/{productQuantity}")
    public void saveCartInfo(@PathVariable(value="productId") long productId,
    						 @PathVariable(value="productQuantity") Integer quantity,
    						 @RequestBody Cart cart) {

    	catalogService.addItemtoCart(productId, cart, quantity);	
    }
    
    @GetMapping(value = "/cart/data")
    public Set<CartItemData> getCatInfo(@RequestBody Cart cart) throws ServletException {
    
		try {
			return catalogService.getCartInfo(cart);
		} catch (ServiceException e) {
			throw new ServletException(e);
		}
    }

    @GetMapping("/getProduct/{Id}")
    public Product getProductById(@PathVariable(value = "Id", required = true) long Id) throws ServletException {
        Product product = null;
    	try {
            if(catalogService.getProduct(Id) != null) {
                product = catalogService.getProduct(Id);
            }
        } catch (ServiceException e) {
            throw new ServletException(e);
        }

        return product;
    }
    
    @PutMapping("cart/update/{id}/{quantity}")
    public void updateCart(@PathVariable(value="id") Integer id,
    						@PathVariable(value="quantity") Integer quantity,
    						@RequestBody Cart cart) {
    	
    	catalogService.changeCart(id, cart, quantity);
    }

    @GetMapping("/getProductByCode/{productCode}")
    public Product getProductByCode(@PathVariable(value = "productCode", required = true) String productCode)
    throws ServletException{
        try {
        	catalogService.getProductByCode(productCode).getTracks().forEach(t -> System.out.println(t.getTitle()));
            return catalogService.getProductByCode(productCode);
        } catch (ServiceException e) {
            throw new ServletException(e);
        }
    }
    
    @DeleteMapping("/cart/remove/{Id}")
    public Cart removeItemFromCart(@PathVariable(value="Id") Integer Id,
    								@RequestBody Cart cart) {
    	catalogService.removeCartItem(Id, cart);
    	return cart;
    }
    
//  @GetMapping("/")
//  public String handleWelcome() {
//      return "/catalog";
//  }

//    @RequestMapping("AddToCart")
//    public String addtoCart(HttpServletRequest request, @RequestParam(value="quantity", required=false) Integer productQuantity
//            , @RequestParam(value = "productCode", required=false) String productCode) throws ServletException{
//        if(request.getSession().getAttribute("user") == null) {
//            return "userWelcome";
//        }
//        Product product = null;
//        Cart cart = null;
//
//        try {
//            product = catalogService.getProductByCode(productCode);
//        } catch (Exception e) {
//            throw new ServletException("productCode not found" + e);
//        }
//
//        try {
//            cart = (Cart) request.getSession().getAttribute("cart");
//            if (checkCart(request) == false) {
//                cart = catalogService.createCart();
//                request.getSession().setAttribute("cart", cart);
//            }
//
//            catalogService.addItemtoCart(product.getId(), cart, productQuantity);
//        }catch(Exception e) {
//            throw new ServletException(e);
//        }
//
//        return "catalog";
//    }

    
//    @GetMapping("cart.html")
//    public String showcart(Model model,HttpServletRequest request) throws ServletException {
//
//        if(request.getSession().getAttribute("user") == null) {
//            return "userWelcome";
//        }
//        Set<CartItemData> setofcartdata = new HashSet<CartItemData>();
//
//        Cart cart = null;
//        try {
//            cart = (Cart) request.getSession().getAttribute("cart");
//            //cart.getItems().forEach(i->System.out.println(i.getProductId()));
//            setofcartdata = catalogService.getCartInfo(cart);
//        }catch(Exception e) {
//            System.out.println("Exception in setofcartdata" + e);
//        }
//        model.addAttribute("products", setofcartdata);
//
//        BigDecimal total = GetSubTotal(0,setofcartdata);
//
//        model.addAttribute("Total", total);
//        return "cart";
//    }
    
//    @GetMapping("/download")
//    public String showProduct(Model model, @RequestParam(value = "productCode", required=false)
//            String productCode, HttpServletRequest request) throws ServletException
//    {
//        String url = null;
//        if(request.getSession().getAttribute("user") == null) {
//            return "/userWelcome";
//        }
//        model.addAttribute("productCode", productCode);
//        return "/sound/" + productCode + "/sound";
//    }

    
//    @GetMapping("/Update/{id}")
//    public String updateQuantity(HttpServletRequest request, Model model, @PathVariable("id") Integer id,
//                                 @RequestParam(value="newQuantity", required=false) Integer quantity) throws ServletException{
//
//        System.out.println(quantity);
//        Cart cart = (Cart) request.getSession().getAttribute("cart");
//        Set<CartItemData> set = new HashSet<>();
//
//        catalogService.changeCart(id, cart, quantity);
//
//        try{
//            set = catalogService.getCartInfo(cart);
//        }catch(Exception e) {
//            System.out.println("Exception in updating cart: " + e);
//        }
//
//        model.addAttribute("products", set);
//
//        BigDecimal total = GetSubTotal(0,set);
//
//        model.addAttribute("Total", total);
//
//        return "cart";
//    }

    
//    public static BigDecimal GetSubTotal(int init, Set<CartItemData> set) {
//        BigDecimal total = new BigDecimal(init);
//
//        if(set.size()!=0) {
//            for(CartItemData item : set) {
//                BigDecimal newquantity = new BigDecimal(item.getQuantity());
//                total = total.add(item.getPrice().multiply(newquantity));
//            }
//        }
//        System.out.println(total);
//        return total;
//    }

//    @GetMapping("/checkout")
//    public String checkout(HttpServletRequest request, Model model) throws ServletException{
//        Cart cart = (Cart) request.getSession().getAttribute("cart");
//        Set<CartItemData> allproducts = new HashSet<>();
//
//        try{
//            allproducts = catalogService.getCartInfo(cart);
//        }catch(Exception e) {
//            System.out.println("Exception in updating cart: " + e);
//        }
//
//        System.out.println("Checkout initiated" + cart.getItems().size());
//
//        if(cart.getItems().size() == 0) return "catalog";
//        model.addAttribute("Products", allproducts);
//
//        BigDecimal total = GetSubTotal(0,allproducts);
//        model.addAttribute("total", total);
//
//        return "checkout";
//    }

//    @RequestMapping("/remove/{ID}")
//    public String removeCartItem(HttpServletRequest request, Model model, @PathVariable("ID") Integer Id) throws ServletException {
//        Cart cart = (Cart) request.getSession().getAttribute("cart");
//        catalogService.removeCartItem(Id, cart);
//
//        Set<CartItemData> setofcartdata = new HashSet<CartItemData>();
//
//        try {
//            setofcartdata = catalogService.getCartInfo(cart);
//        }catch(Exception e) {
//            System.out.println("Exception in setofcartdata" + e);
//        }
//        model.addAttribute("products", setofcartdata);
//
//        BigDecimal total = GetSubTotal(0,setofcartdata);
//        model.addAttribute("Total", total);
//
//        return "cart";
//    }

    
//    private boolean checkCart(HttpServletRequest request) throws IOException {
//        HttpSession session = request.getSession();
//        Cart cart = (Cart) session.getAttribute("cart");
//        return (cart != null);
//    }
}
