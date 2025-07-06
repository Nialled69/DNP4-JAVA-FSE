package com.example.service;

import com.example.entity.Product;
import com.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;
    
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }
    
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
    
    public List<Product> getProductsByName(String name) {
        return productRepository.findByName(name);
    }
    
    public List<Product> getProductsByCategory(String category) {
        return productRepository.findByCategory(category);
    }
    
    public List<Product> getProductsMoreExpensiveThan(Double price) {
        return productRepository.findByPriceGreaterThan(price);
    }
    
    public List<Product> getProductsByPriceRange(Double minPrice, Double maxPrice) {
        return productRepository.findByPriceBetween(minPrice, maxPrice);
    }
    
    public List<Product> getProductsMoreExpensiveThanQuery(Double price) {
        return productRepository.findProductsMoreExpensiveThan(price);
    }
    
    public Long countProductsByCategory(String category) {
        return productRepository.countProductsByCategory(category);
    }
    
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
} 