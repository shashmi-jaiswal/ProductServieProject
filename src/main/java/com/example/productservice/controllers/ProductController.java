package com.example.productservice.controllers;

import com.example.productservice.exceptions.InvalidProductIdException;
import com.example.productservice.exceptions.ProductControllerSpecificException;
import com.example.productservice.models.Product;
import com.example.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;
    //selfProductService
    ProductController(@Qualifier("selfProductService") ProductService productService){
        this.productService = productService;
    }

    //localhost:8080/products/10  -- This number at the end can be any id.
    //The Pathvariable will read the id number and use as input.
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductbyId(@PathVariable("id") Long id) throws InvalidProductIdException {

        //throw new RuntimeException("Something went wrong");
//        Product product = null;
//        try {
//            product = productService.getProductById(id);
//        } catch (RuntimeException e) {
//            System.out.println("Something went wrong");
//            return new ResponseEntity<>(product, HttpStatus.NOT_FOUND);
//        } catch (ArrayIndexOutOfBoundsException e) {
//            return
//        }

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
        return productService.createProduct(product);
        //productService.createProduct(Product product);

        //return new Product();
    }

    //Partial Update of a product
    @PatchMapping("{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product){
        return productService.updateProduct(id, product);
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

    @ExceptionHandler(ProductControllerSpecificException.class)
    public ResponseEntity<Void> productControllerSpecificException(){
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    //This type of except ion is thrown only from this controller
    }
}
