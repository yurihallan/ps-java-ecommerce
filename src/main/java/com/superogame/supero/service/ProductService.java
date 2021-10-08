package com.superogame.supero.service;

import java.util.List;
import java.util.Optional;

import com.superogame.supero.Entity.Product;
import com.superogame.supero.Repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public ResponseEntity<List<Product>> getAllProducts(){
       try {
           
            return new ResponseEntity<List<Product>>(productRepository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        
        
    }

    public ResponseEntity<Product> createProduct(Product product){

        try {
            
            Product product2 = new Product();
            product2.setName(product.getName());
            
            product2.setPrice(product.getPrice());
            product2.setScore(product.getScore());
            product2.setImage(product.getImage());
            
            return new ResponseEntity<Product>( productRepository.save(product2), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
        
    }

    public ResponseEntity<Object> DeleteProduct(Long id){
        
        try {
            
            productRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Product> findOne(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
       
        if(productOptional.isPresent()){

            return new ResponseEntity<>(productOptional.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
    }

    
    public ResponseEntity<Product> updateOneProduct(Product newProduct , Long id){
        // Optional<Product> productOptional = productRepository.findById(id);

        

            return productRepository.findById(id)
                    .map(record -> {
                                record.setName(newProduct.getName());
                                record.setPrice(newProduct.getPrice());
                                record.setScore(newProduct.getScore());
                                record.setImage(newProduct.getImage());
                                Product updated = productRepository.save(record);
                                return new ResponseEntity<Product>(updated, HttpStatus.OK);

                                }).orElse(ResponseEntity.notFound().build());
                


            // Product product2 = new Product();
            // product2.setName(newProduct.getName());
            // product2.setPrice(newProduct.getPrice());
            // product2.setScore(newProduct.getScore());
            // product2.setImage(newProduct.getImage());
            // productRepository.save(product2);
            

        
    }
}
