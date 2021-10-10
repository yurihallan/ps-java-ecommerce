package com.superogame.supero.Controller;

import java.util.List;

import com.superogame.supero.Entity.Cart;
import com.superogame.supero.Entity.ItemCart;
import com.superogame.supero.service.CartService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController {
    
    private CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    //Get All ItemCart
    @RequestMapping(value = "/CartItem/",method = RequestMethod.GET)
    public ResponseEntity<List<ItemCart>> getAllItemCart(){
        return cartService.getAllCartItem();
    }
    //Create ItemCart
    @RequestMapping(value = "/CartItem/",method = RequestMethod.POST)
    public ResponseEntity<ItemCart> createItemCart(@RequestBody ItemCart itemCart){
        return cartService.createItemCart(itemCart);
    }

    //Delete itemCart
    @RequestMapping(value = "/CartItem/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<Object> DeleteItemCart(@PathVariable Long id){
        return cartService.DeleteItemCart(id);
    }


    //Get All Item by Cart
    @RequestMapping(value = "/Carts/", method = RequestMethod.GET)
    public ResponseEntity<List<Cart>> getAllCart(){
        return cartService.getAllCart();
    }
    
    //Get Checkout
    @RequestMapping(value = "/Cart/{id_client}", method = RequestMethod.GET)
    public ResponseEntity<List<Cart>> getCheckout(@PathVariable Long id_client){
        return cartService.getCheckout(id_client);
    }

    //Create Cart Product
    @RequestMapping(value = "/Cart/", method = RequestMethod.POST)
    public ResponseEntity<Cart> createCart(@RequestBody Cart cart){
        return cartService.createCart(cart);
    }
    
    //Delete cart item
    @RequestMapping(value = "/Cart/",method = RequestMethod.DELETE)
    public ResponseEntity<Object> DeleteCart(@PathVariable Long id){
        return cartService.DeleteCart(id);
    }
}
