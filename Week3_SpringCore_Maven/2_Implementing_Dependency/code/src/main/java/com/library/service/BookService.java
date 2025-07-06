package com.library.service;

import com.library.repository.BookRepository;
import com.library.repository.BookRepository.Book;
import java.util.List;

public class BookService {
    
    private BookRepository bookRepository;
    
    public BookService() {
        System.out.println("BookService: Constructor called - BookService instance created");
    }
    
    /**
     * Setter method for dependency injection
     * This method will be called by Spring to inject the BookRepository dependency
     * @param bookRepository The BookRepository instance to inject
     */
    public void setBookRepository(BookRepository bookRepository) {
        System.out.println("BookService: setBookRepository() called - Dependency injection happening!");
        System.out.println("BookService: Injecting BookRepository: " + bookRepository);
        this.bookRepository = bookRepository;
    }
    
    /**
     * Get a book by its ID
     * @param id The book ID
     * @return The book if found, null otherwise
     */
    public Book getBookById(String id) {
        System.out.println("BookService: Retrieving book with ID: " + id);
        return bookRepository.findById(id);
    }
    
    /**
     * Get all books
     * @return List of all books
     */
    public List<Book> getAllBooks() {
        System.out.println("BookService: Retrieving all books");
        return bookRepository.findAll();
    }
    
    /**
     * Add a new book
     * @param title The book title
     * @param author The book author
     * @param genre The book genre
     * @return The created book
     */
    public Book addBook(String title, String author, String genre) {
        String newId = String.valueOf(bookRepository.getBookCount() + 1);
        Book newBook = new Book(newId, title, author, genre);
        System.out.println("BookService: Adding new book: " + newBook);
        return bookRepository.save(newBook);
    }
    
    /**
     * Update an existing book
     * @param id The book ID
     * @param title The new title
     * @param author The new author
     * @param genre The new genre
     * @return The updated book, or null if not found
     */
    public Book updateBook(String id, String title, String author, String genre) {
        Book existingBook = bookRepository.findById(id);
        if (existingBook != null) {
            existingBook.setTitle(title);
            existingBook.setAuthor(author);
            existingBook.setGenre(genre);
            System.out.println("BookService: Updating book: " + existingBook);
            return bookRepository.save(existingBook);
        }
        System.out.println("BookService: Book not found with ID: " + id);
        return null;
    }
    
    /**
     * Delete a book by ID
     * @param id The book ID to delete
     * @return true if deleted, false if not found
     */
    public boolean deleteBook(String id) {
        System.out.println("BookService: Deleting book with ID: " + id);
        return bookRepository.deleteById(id);
    }
    
    /**
     * Find books by author
     * @param author The author name
     * @return List of books by the author
     */
    public List<Book> getBooksByAuthor(String author) {
        System.out.println("BookService: Finding books by author: " + author);
        return bookRepository.findByAuthor(author);
    }
    
    /**
     * Get the total number of books
     * @return The count of books
     */
    public int getTotalBookCount() {
        int count = bookRepository.getBookCount();
        System.out.println("BookService: Total book count: " + count);
        return count;
    }
    
    /**
     * Search books by title (case-insensitive)
     * @param title The title to search for
     * @return List of books matching the title
     */
    public List<Book> searchBooksByTitle(String title) {
        System.out.println("BookService: Searching books by title: " + title);
        List<Book> allBooks = bookRepository.findAll();
        List<Book> matchingBooks = new java.util.ArrayList<>();
        
        for (Book book : allBooks) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                matchingBooks.add(book);
            }
        }
        
        return matchingBooks;
    }
} 