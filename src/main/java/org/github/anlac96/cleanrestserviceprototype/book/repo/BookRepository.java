package org.github.anlac96.cleanrestserviceprototype.book.repo;

import org.github.anlac96.cleanrestserviceprototype.book.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
    Book create(Book book);

    Optional<Book> findById(String bookId);

    List<Book> findAll();

    Book update(Book book);

    void deleteById(String bookId);
}
