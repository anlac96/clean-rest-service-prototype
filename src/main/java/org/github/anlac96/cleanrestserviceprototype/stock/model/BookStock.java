package org.github.anlac96.cleanrestserviceprototype.stock.model;

import lombok.Data;
import org.github.anlac96.cleanrestserviceprototype.book.model.Book;

@Data
public class BookStock {
    private Book book;
    private int quantity;
}
