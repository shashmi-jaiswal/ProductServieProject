package com.example.productservice.services;

import com.example.productservice.exceptions.InvalidProductIdException;
import com.example.productservice.models.Category;
import com.example.productservice.models.Product;
import com.example.productservice.repositories.CategoryRepository;
import com.example.productservice.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")
public class SelfProductService implements ProductService {
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    SelfProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public Product getAllProductbyId(Long id) throws InvalidProductIdException {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isEmpty()){
            throw new InvalidProductIdException();
            //throw new RuntimeException("This is an error in the getProductbyId");
            //return null;
        }
        else{
            return optionalProduct.get();
        }
    }

    @Override
    public List<Product> getAllProducts( ) {
        return productRepository.findAll();
    }

    @Override
    public Product createProduct(Product product) {
        Category category = product.getCategory();

        if (category.getId() == null) {
            //first save the category in the DB
            Category savedCategory = categoryRepository.save(category);
            product.setCategory(savedCategory);
        }

        return  productRepository.save(product);
        //return null;
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isEmpty()) throw new RuntimeException();

        if (product == null) throw new RuntimeException("Invalid input exception to update method");

        Product currentProduct = optionalProduct.get();

        if (product.getTitle() != null) {
            //If title isn't null that means we want to update the title.
            currentProduct.setTitle(product.getTitle());
        }

        if (product.getDescription() != null) {
            currentProduct.setDescription(product.getDescription());
        }

        return productRepository.save(currentProduct);
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }

    @Override
    public void deleteProduct(Long id) {
        //productRepository.deleteById(Long id);

    }
}
