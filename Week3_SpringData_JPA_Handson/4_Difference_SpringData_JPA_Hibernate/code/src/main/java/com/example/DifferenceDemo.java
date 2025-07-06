package com.example;

import com.example.entity.Product;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DifferenceDemo implements CommandLineRunner {
    
    @Autowired
    private ProductService productService;
    
    @Override
    public void run(String... args) throws Exception {
        System.out.println("=== Spring Data JPA vs Hibernate Differences Demo ===");
        System.out.println("==================================================");
        
        System.out.println("1. Creating sample products...");
        Product product1 = new Product("Laptop", 999.99, "Electronics", "High-performance laptop");
        Product product2 = new Product("Smartphone", 599.99, "Electronics", "Latest smartphone model");
        Product product3 = new Product("Book", 29.99, "Books", "Programming book");
        Product product4 = new Product("Headphones", 199.99, "Electronics", "Wireless headphones");
        
        productService.saveProduct(product1);
        productService.saveProduct(product2);
        productService.saveProduct(product3);
        productService.saveProduct(product4);
        
        System.out.println("✓ Sample products created successfully");
        
        System.out.println("\n2. Demonstrating Spring Data JPA features:");
        System.out.println("   - Method name queries (findByCategory)");
        System.out.println("   - Custom queries with @Query annotation");
        System.out.println("   - Automatic CRUD operations");
        
        System.out.println("\n3. All products:");
        productService.getAllProducts().forEach(System.out::println);
        
        System.out.println("\n4. Electronics products (using findByCategory):");
        productService.getProductsByCategory("Electronics").forEach(System.out::println);
        
        System.out.println("\n5. Products more expensive than $500 (using findByPriceGreaterThan):");
        productService.getProductsMoreExpensiveThan(500.0).forEach(System.out::println);
        
        System.out.println("\n6. Products in price range $100-$300 (using findByPriceBetween):");
        productService.getProductsByPriceRange(100.0, 300.0).forEach(System.out::println);
        
        System.out.println("\n7. Products more expensive than $200 (using custom @Query):");
        productService.getProductsMoreExpensiveThanQuery(200.0).forEach(System.out::println);
        
        System.out.println("\n8. Count of Electronics products (using custom @Query):");
        Long count = productService.countProductsByCategory("Electronics");
        System.out.println("Number of Electronics products: " + count);
        
        System.out.println("\n=== Key Differences Demonstrated ===");
        System.out.println("Spring Data JPA provides:");
        System.out.println("- Method name queries (findByCategory, findByPriceGreaterThan)");
        System.out.println("- Custom queries with @Query annotation");
        System.out.println("- Automatic CRUD operations (save, findAll, findById, deleteById)");
        System.out.println("- Repository pattern implementation");
        System.out.println("- Reduced boilerplate code");
        System.out.println("- Type-safe queries");
        
        System.out.println("\nHibernate (underlying ORM) provides:");
        System.out.println("- JPA implementation");
        System.out.println("- Object-relational mapping");
        System.out.println("- Database abstraction");
        System.out.println("- Query execution");
        
        System.out.println("\nSpring Data JPA builds on top of Hibernate to provide:");
        System.out.println("- Higher-level abstractions");
        System.out.println("- Repository pattern");
        System.out.println("- Query method generation");
        System.out.println("- Simplified data access");
    }
} 