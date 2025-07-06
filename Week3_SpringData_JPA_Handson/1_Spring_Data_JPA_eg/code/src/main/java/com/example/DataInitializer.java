package com.example;

import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    
    @Autowired
    private UserService userService;
    
    @Override
    public void run(String... args) throws Exception {
        System.out.println("=== Spring Data JPA Example ===");
        System.out.println("Initializing sample data...");
        
        User user1 = new User("John Doe", "john@example.com", 25);
        User user2 = new User("Jane Smith", "jane@example.com", 30);
        User user3 = new User("Bob Johnson", "bob@example.com", 35);
        User user4 = new User("Alice Brown", "alice@example.com", 28);
        
        userService.saveUser(user1);
        userService.saveUser(user2);
        userService.saveUser(user3);
        userService.saveUser(user4);
        
        System.out.println("Sample data created successfully!");
        System.out.println("Total users: " + userService.getAllUsers().size());
        System.out.println("Users older than 25: " + userService.getUsersOlderThan(25).size());
        System.out.println("Users between 25-35: " + userService.getUsersByAgeRange(25, 35).size());
        
        System.out.println("=== Application Ready ===");
        System.out.println("Access the API at: http://localhost:8080/api/users");
    }
} 