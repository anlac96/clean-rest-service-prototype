package org.github.anlac96.cleanrestserviceprototype.book.impl;

import jakarta.enterprise.context.ApplicationScoped;
import org.github.anlac96.cleanrestserviceprototype.book.model.Book;
import org.github.anlac96.cleanrestserviceprototype.book.repo.BookRepository;
import org.github.anlac96.cleanrestserviceprototype.book.service.BookService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book createBook(Book book) {
        book.setBookId(UUID.randomUUID().toString());
        return bookRepository.create(book);
    }

    @Override
    public Optional<Book> getBookById(String bookId) {
        return bookRepository.findById(bookId);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book updateBook(Book book) {
        if (bookRepository.findById(book.getBookId()).isPresent()) {
            return bookRepository.update(book);
        } else {
            throw new IllegalArgumentException("Book not found with ID: " + book.getBookId());
        }
    }

    @Override
    public void deleteBook(String bookId) {
        bookRepository.findById(bookId)
                .ifPresentOrElse(
                        book -> bookRepository.deleteById(bookId),
                        () -> {
                            throw new IllegalArgumentException("Book not found with ID: " + bookId);
                        }
                );
    }
}
