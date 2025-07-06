package com.example.service;

import com.example.entity.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    public User saveUser(User user) {
        return userRepository.save(user);
    }
    
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
    
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    
    public List<User> getUsersByName(String name) {
        return userRepository.findByName(name);
    }
    
    public List<User> getUsersOlderThan(Integer age) {
        return userRepository.findByAgeGreaterThan(age);
    }
    
    public List<User> getUsersByAgeRange(Integer minAge, Integer maxAge) {
        return userRepository.findUsersByAgeRange(minAge, maxAge);
    }
    
    public Long countUsersOlderThan(Integer age) {
        return userRepository.countUsersOlderThan(age);
    }
    
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
} 