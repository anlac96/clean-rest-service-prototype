package org.github.anlac96.cleanrestserviceprototype.book.service;

import org.github.anlac96.cleanrestserviceprototype.book.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    Book createBook(Book book);

    Optional<Book> getBookById(String bookId);

    List<Book> getAllBooks();

    Book updateBook(Book book);

    void deleteBook(String bookId);
}
