package com.example.productservice.controllers;

import com.example.productservice.models.Product;
import com.example.productservice.services.FakeStoreProductService;
import com.example.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    ProductController(@Qualifier("fakeStoreProductService") ProductService productService){
        this.productService = productService;
    }

    //localhost:8080/products/10  -- This number at the end can be any id.
    //The Pathvariable will read the id number and use as input.
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductbyId(@PathVariable("id") Long id){

        Product product =  productService.getAllProductbyId(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    //localhost:8080/products

    @GetMapping
    public List<Product> getAllProducts(){

        return productService.getAllProducts();
    }
    //Request Body will read the given JSON input and convert it to class Product
    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return new Product();
    }
    //Partial Update of a product
    @PatchMapping("{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product){
        return new Product();
    }
    //Replace a product
    @PostMapping("{id}")
    public Product replaceProduct(@PathVariable("id") Long id, @RequestBody Product product){
        return productService.replaceProduct(id, product);
    }

    //Delete a product
    @DeleteMapping("{id}")
    public void deleteProduct(@PathVariable("id") Long id){
        return;
    }
}
