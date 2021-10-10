package com.superogame.supero.service;


import java.util.List;

import com.superogame.supero.Entity.Cart;
import com.superogame.supero.Entity.ItemCart;
import com.superogame.supero.Repository.CartItemRepository;
import com.superogame.supero.Repository.CartRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    public CartRepository cartRepository;

    @Autowired
    public CartItemRepository cartItemRepository;

    //Get All cart item
    public ResponseEntity<List<ItemCart>> getAllCartItem(){
        try {
            return new ResponseEntity<List<ItemCart>>(cartItemRepository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    //Create cart item
    public ResponseEntity<ItemCart> createItemCart(ItemCart itemCart){
        try {
            ItemCart itemCart2 = new ItemCart();
            itemCart2.setId_client(itemCart.getId_client());
            itemCart2.setId_product(itemCart.getId_product());
            itemCart2.setQtdProduct(itemCart.getQtdProduct());
            return new ResponseEntity<ItemCart>(cartItemRepository.save(itemCart2), HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
    }

    //Delete cart item
    public ResponseEntity<Object> DeleteItemCart(Long id){
        try {
            cartItemRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Get All Item by Cart
    public ResponseEntity<List<Cart>> getAllCart(){
        try {
            return new ResponseEntity<List<Cart>>(cartRepository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

     //Get Checkout
     public ResponseEntity<List<Cart>> getCheckout(Long id_client){
        try {

            return new ResponseEntity<List<Cart>>(cartRepository.getCheckout(id_client), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    //Create Cart Product
    public ResponseEntity<Cart> createCart(Cart cart){
        try {
            Cart cart2 = new Cart();
            cart2.setId_client(cart.getId_client());
            cart2.setId_product(cart.getId_product());
            cart2.setTotal(cart.getTotal());
            cart2.setFreight(10);
            return new ResponseEntity<Cart>(cartRepository.save(cart2), HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
    }

     //Delete cart item
     public ResponseEntity<Object> DeleteCart(Long id){
        try {
            cartRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    
}
