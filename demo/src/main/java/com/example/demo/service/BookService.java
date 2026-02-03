package com.example.demo.service;

import com.example.demo.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private final List<Book> books = new ArrayList<>();
    private long nextId = 1;

    public BookService() {
        // dữ liệu mẫu giống slide (Spring Boot, ...), bạn có thể đổi
        addBook(new Book(null, "Spring Boot", "Huy Cuong"));
        addBook(new Book(null, "Spring Boot 2", "V Anh"));
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public Book findById(Long id) {
        if (id == null) return null;
        for (Book b : books) {
            if (b.getId().equals(id)) return b;
        }
        return null;
    }

    public void addBook(Book book) {
        if (book == null) return;
        book.setId(nextId++);
        books.add(book);
    }

    public boolean updateBook(Book updated) {
        if (updated == null || updated.getId() == null) return false;

        Book existing = findById(updated.getId());
        if (existing == null) return false;

        existing.setTitle(updated.getTitle());
        existing.setAuthor(updated.getAuthor());
        return true;
    }

    public boolean deleteBook(Long id) {
        Book existing = findById(id);
        if (existing == null) return false;
        return books.remove(existing);
    }
}