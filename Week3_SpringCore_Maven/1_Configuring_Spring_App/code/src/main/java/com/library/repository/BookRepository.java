package com.library.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class BookRepository {
    
    private Map<String, Book> books;
    
    public BookRepository() {
        this.books = new HashMap<>();
        initializeSampleBooks();
    }
    
    private void initializeSampleBooks() {
        books.put("1", new Book("1", "The Great Gatsby", "F. Scott Fitzgerald", "Fiction"));
        books.put("2", new Book("2", "To Kill a Mockingbird", "Harper Lee", "Fiction"));
        books.put("3", new Book("3", "1984", "George Orwell", "Dystopian"));
        books.put("4", new Book("4", "Pride and Prejudice", "Jane Austen", "Romance"));
        books.put("5", new Book("5", "The Hobbit", "J.R.R. Tolkien", "Fantasy"));
    }
    
    /**
     * Find a book by its ID
     * @param id The book ID
     * @return The book if found, null otherwise
     */
    public Book findById(String id) {
        return books.get(id);
    }
    
    /**
     * Find all books
     * @return List of all books
     */
    public List<Book> findAll() {
        return new ArrayList<>(books.values());
    }
    
    /**
     * Save a book
     * @param book The book to save
     * @return The saved book
     */
    public Book save(Book book) {
        books.put(book.getId(), book);
        return book;
    }
    
    /**
     * Delete a book by ID
     * @param id The book ID to delete
     * @return true if deleted, false if not found
     */
    public boolean deleteById(String id) {
        return books.remove(id) != null;
    }
    
    /**
     * Find books by author
     * @param author The author name
     * @return List of books by the author
     */
    public List<Book> findByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : books.values()) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                result.add(book);
            }
        }
        return result;
    }
    
    /**
     * Get the total number of books
     * @return The count of books
     */
    public int getBookCount() {
        return books.size();
    }
    
    public static class Book {
        private String id;
        private String title;
        private String author;
        private String genre;
        
        public Book(String id, String title, String author, String genre) {
            this.id = id;
            this.title = title;
            this.author = author;
            this.genre = genre;
        }
        
        public String getId() { return id; }
        public void setId(String id) { this.id = id; }
        
        public String getTitle() { return title; }
        public void setTitle(String title) { this.title = title; }
        
        public String getAuthor() { return author; }
        public void setAuthor(String author) { this.author = author; }
        
        public String getGenre() { return genre; }
        public void setGenre(String genre) { this.genre = genre; }
        
        @Override
        public String toString() {
            return "Book{" +
                    "id='" + id + '\'' +
                    ", title='" + title + '\'' +
                    ", author='" + author + '\'' +
                    ", genre='" + genre + '\'' +
                    '}';
        }
    }
} 