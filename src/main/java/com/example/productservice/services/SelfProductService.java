package com.example.productservice.services;

import com.example.productservice.models.Product;
import com.example.productservice.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")
public class SelfProductService implements ProductService{
    private ProductRepository productRepository;
    SelfProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public Product getAllProduct(Long id) {
        Optional<Product> optionalproduct = productRepository.findById(id);
        if (optionalproduct.isEmpty()){
            return null;
        }
        else{
            return optionalproduct.get();
        }
    }

    @Override
    public List<Product> getAllProducts( ) {
        return productRepository.findAll();
    }

    @Override
    public Product createProduct() {
        return null;
    }

    @Override
    public Product updateProduct(Long id) {
        return null;
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(Long id);

    }
}
