package com.superogame.supero.Controller;

import java.util.List;

import com.superogame.supero.Entity.Product;
import com.superogame.supero.service.ProductService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    
    private ProductService productService;
    

    public ProductController(ProductService productService){
        this.productService = productService;
    }
    
    @RequestMapping(value = "/Products", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> getAllProducts(){

        return productService.getAllProducts();
    }

    @RequestMapping(value = "/Product/", method = RequestMethod.POST)
    public ResponseEntity<Product> CreateProduct(@RequestBody Product product){

        return productService.createProduct(product);
    }

    @RequestMapping(value = "/Product/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> DeleteProduct(@PathVariable Long id){

        return productService.DeleteProduct(id);
        
    }
    
    @RequestMapping(value = "/Product/{id}", method = RequestMethod.GET)
    public ResponseEntity<Product> getOneProduct(@PathVariable Long id){
        return productService.findOne(id);
        
        
    }

    @RequestMapping(value = "/Product/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Product> updateOneProduct( @RequestBody Product product, @PathVariable(value="id") Long id){
        
        return productService.updateOneProduct(product, id);
    }

}
