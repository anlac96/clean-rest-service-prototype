package org.github.anlac96.cleanrestserviceprototype.book.impl;

import jakarta.enterprise.context.ApplicationScoped;
import org.github.anlac96.cleanrestserviceprototype.book.model.Book;
import org.github.anlac96.cleanrestserviceprototype.book.repo.BookRepository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@ApplicationScoped
public class InMemoryBookRepository implements BookRepository {

    private final Map<String, Book> bookStore = new ConcurrentHashMap<>();

    @Override
    public Book create(Book book) {
        if (bookStore.containsKey(book.getBookId())) {
            throw new IllegalArgumentException("Book with ID " + book.getBookId() + " already exists.");
        }
        bookStore.put(book.getBookId(), book);
        return book;
    }

    @Override
    public Optional<Book> findById(String bookId) {
        return Optional.ofNullable(bookStore.get(bookId));
    }

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(bookStore.values());
    }

    @Override
    public Book update(Book book) {
        if (!bookStore.containsKey(book.getBookId())) {
            throw new IllegalArgumentException("Book with ID " + book.getBookId() + " does not exist.");
        }
        bookStore.put(book.getBookId(), book);
        return book;
    }

    @Override
    public void deleteById(String bookId) {
        if (!bookStore.containsKey(bookId)) {
            throw new IllegalArgumentException("Book with ID " + bookId + " does not exist.");
        }
        bookStore.remove(bookId);
    }
}
