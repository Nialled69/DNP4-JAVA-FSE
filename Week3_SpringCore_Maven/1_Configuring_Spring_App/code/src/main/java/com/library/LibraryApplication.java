package com.library;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.library.service.BookService;
import com.library.repository.BookRepository.Book;
import java.util.List;


public class LibraryApplication {
    
    public static void main(String[] args) {
        System.out.println("=== Library Management System ===");
        System.out.println("Loading Spring Application Context...");
        
        try {
            ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
            
            System.out.println("✓ Spring context loaded successfully!");
            System.out.println();
            
            BookService bookService = context.getBean("bookService", BookService.class);
            System.out.println("✓ BookService bean retrieved from Spring context");
            System.out.println();
            
            testLibraryOperations(bookService);
            
            System.out.println("\n=== Application completed successfully! ===");
            
        } catch (Exception e) {
            System.err.println("Error loading Spring context: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     * Test various library operations
     * @param bookService The BookService instance
     */
    private static void testLibraryOperations(BookService bookService) {
        System.out.println("--- Testing Library Operations ---");
        
        System.out.println("1. Total books in library: " + bookService.getTotalBookCount());
        System.out.println();
        
        System.out.println("2. All books in library:");
        List<Book> allBooks = bookService.getAllBooks();
        for (Book book : allBooks) {
            System.out.println("   - " + book);
        }
        System.out.println();
        
        System.out.println("3. Getting book with ID '1':");
        Book book1 = bookService.getBookById("1");
        if (book1 != null) {
            System.out.println("   Found: " + book1);
        } else {
            System.out.println("   Book not found");
        }
        System.out.println();
        
        System.out.println("4. Books by 'F. Scott Fitzgerald':");
        List<Book> booksByAuthor = bookService.getBooksByAuthor("F. Scott Fitzgerald");
        for (Book book : booksByAuthor) {
            System.out.println("   - " + book);
        }
        System.out.println();
        
        System.out.println("5. Books with 'Gatsby' in title:");
        List<Book> booksByTitle = bookService.searchBooksByTitle("Gatsby");
        for (Book book : booksByTitle) {
            System.out.println("   - " + book);
        }
        System.out.println();
        
        System.out.println("6. Adding a new book:");
        Book newBook = bookService.addBook("The Catcher in the Rye", "J.D. Salinger", "Fiction");
        System.out.println("   Added: " + newBook);
        System.out.println();
        
        System.out.println("7. Updating book with ID '2':");
        Book updatedBook = bookService.updateBook("2", "To Kill a Mockingbird (Updated)", "Harper Lee", "Classic Fiction");
        if (updatedBook != null) {
            System.out.println("   Updated: " + updatedBook);
        } else {
            System.out.println("   Book not found for update");
        }
        System.out.println();
        
        System.out.println("8. Final total books: " + bookService.getTotalBookCount());
        System.out.println();
        
        System.out.println("9. Deleting book with ID '5':");
        boolean deleted = bookService.deleteBook("5");
        System.out.println("   Deletion successful: " + deleted);
        System.out.println("   Books after deletion: " + bookService.getTotalBookCount());
    }
} 