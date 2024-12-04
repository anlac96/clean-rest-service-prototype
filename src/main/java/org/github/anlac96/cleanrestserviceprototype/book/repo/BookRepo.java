package org.github.anlac96.cleanrestserviceprototype.book.repo;

import org.github.anlac96.cleanrestserviceprototype.book.model.Book;

import java.util.List;

public interface BookRepo {

    Book findBookById(String id);

    Book createBook(Book book);

    Book updateBook(Book book);

    Book deleteBook(Book book);

    List<Book> findBook(Long limit, Long offset);
}
