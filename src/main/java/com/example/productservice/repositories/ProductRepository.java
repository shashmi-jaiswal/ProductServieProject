package com.example.productservice.repositories;

import com.example.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.PropertyPermission;

public interface ProductRepository
    extends JpaRepository<Product,Long > {

    Optional<Product> findById(Long id);

}
