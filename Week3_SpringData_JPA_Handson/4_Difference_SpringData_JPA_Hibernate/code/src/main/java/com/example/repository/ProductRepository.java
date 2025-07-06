package com.example.repository;

import com.example.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    
    List<Product> findByName(String name);
    
    List<Product> findByCategory(String category);
    
    List<Product> findByPriceGreaterThan(Double price);
    
    List<Product> findByPriceBetween(Double minPrice, Double maxPrice);
    
    @Query("SELECT p FROM Product p WHERE p.price > :price")
    List<Product> findProductsMoreExpensiveThan(@Param("price") Double price);
    
    @Query("SELECT COUNT(p) FROM Product p WHERE p.category = :category")
    Long countProductsByCategory(@Param("category") String category);
} 