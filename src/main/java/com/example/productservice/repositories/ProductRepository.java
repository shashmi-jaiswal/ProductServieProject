package com.example.productservice.repositories;

import com.example.productservice.models.Category;
import com.example.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.PropertyPermission;

public interface ProductRepository
    extends JpaRepository<Product,Long > {

    Optional<Product> findById(Long id);
    List<Product> findAll();
    List<Product> findByCategory(Category category);

    Optional<Product> findProductByTitle(String title);

    Optional<Product> findProductByTitleAAndCategory(String title, String category);
    List<Product> findTopThreeByTitle(String title); //Limit top 3 results

    void deleteById(Long id);
    void deleteByCategory(Category category);
    void  deleteByTitle(String title);
    Product save(Product product);

}
    /*
    C Create
    R Replace
    U Update
    D Delete

    Product save(Product product);
      */