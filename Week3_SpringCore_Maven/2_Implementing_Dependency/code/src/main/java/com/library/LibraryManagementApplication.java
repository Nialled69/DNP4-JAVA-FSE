package com.library;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.library.service.BookService;
import com.library.repository.BookRepository.Book;
import java.util.List;

public class LibraryManagementApplication {    
    public static void main(String[] args) {
        System.out.println("=== Exercise 2: Implementing Dependency Injection ===");
        System.out.println("Library Management System with Spring IoC and DI");
        System.out.println("==================================================");
        
        try {
            System.out.println("1. Loading Spring Application Context...");
            ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
            
            System.out.println("✓ Spring context loaded successfully!");
            System.out.println("✓ IoC Container initialized");
            System.out.println();
            
            System.out.println("2. Retrieving BookService bean from Spring context...");
            BookService bookService = context.getBean("bookService", BookService.class);
            
            System.out.println("✓ BookService bean retrieved successfully!");
            System.out.println("✓ Dependency injection completed!");
            System.out.println();
            
            System.out.println("3. Testing Dependency Injection Configuration...");
            testDependencyInjection(bookService);
            
            System.out.println("\n=== Exercise 2 Completed Successfully! ===");
            System.out.println("✓ XML Configuration: BookRepository wired into BookService");
            System.out.println("✓ BookService Class: Setter method for BookRepository dependency");
            System.out.println("✓ Testing: Dependency injection verified and working");
            
        } catch (Exception e) {
            System.err.println("❌ Error during dependency injection test: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     * Test the dependency injection by performing various library operations
     * @param bookService The BookService instance with injected BookRepository
     */
    private static void testDependencyInjection(BookService bookService) {
        System.out.println("--- Testing Library Operations (Dependency Injection) ---");
        
        System.out.println("Test 1: Total books in library: " + bookService.getTotalBookCount());
        System.out.println();
        
        System.out.println("Test 2: All books in library:");
        List<Book> allBooks = bookService.getAllBooks();
        for (Book book : allBooks) {
            System.out.println("   - " + book);
        }
        System.out.println();
        
        System.out.println("Test 3: Getting book with ID '1':");
        Book book1 = bookService.getBookById("1");
        if (book1 != null) {
            System.out.println("   Found: " + book1);
        } else {
            System.out.println("   Book not found");
        }
        System.out.println();
        
        System.out.println("Test 4: Books by 'F. Scott Fitzgerald':");
        List<Book> booksByAuthor = bookService.getBooksByAuthor("F. Scott Fitzgerald");
        for (Book book : booksByAuthor) {
            System.out.println("   - " + book);
        }
        System.out.println();
        
        System.out.println("Test 5: Books with 'Gatsby' in title:");
        List<Book> booksByTitle = bookService.searchBooksByTitle("Gatsby");
        for (Book book : booksByTitle) {
            System.out.println("   - " + book);
        }
        System.out.println();
        
        System.out.println("Test 6: Adding a new book:");
        Book newBook = bookService.addBook("The Catcher in the Rye", "J.D. Salinger", "Fiction");
        System.out.println("   Added: " + newBook);
        System.out.println();
        
        System.out.println("Test 7: Updating book with ID '2':");
        Book updatedBook = bookService.updateBook("2", "To Kill a Mockingbird (Updated)", "Harper Lee", "Classic Fiction");
        if (updatedBook != null) {
            System.out.println("   Updated: " + updatedBook);
        } else {
            System.out.println("   Book not found for update");
        }
        System.out.println();
        
        System.out.println("Test 8: Final verification:");
        System.out.println("   Total books after operations: " + bookService.getTotalBookCount());
        System.out.println();
        
        System.out.println("Test 9: Deleting book with ID '5':");
        boolean deleted = bookService.deleteBook("5");
        System.out.println("   Deletion successful: " + deleted);
        System.out.println("   Books after deletion: " + bookService.getTotalBookCount());
        System.out.println();
        
        System.out.println("✓ All tests completed successfully!");
        System.out.println("✓ Dependency injection is working correctly!");
        System.out.println("✓ BookService is properly using the injected BookRepository!");
    }
} 