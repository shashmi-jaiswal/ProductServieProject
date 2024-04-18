package com.example.productservice.services;

import com.example.productservice.exceptions.InvalidProductIdException;
import com.example.productservice.models.Product;

import java.util.List;

public interface ProductService {
    Product getAllProductbyId(Long id) throws InvalidProductIdException;
    List<Product> getAllProducts();
    Product createProduct(Product product);
    Product updateProduct(Long id, Product product);
    Product replaceProduct(Long id, Product product);
    void deleteProduct(Long id);



}
