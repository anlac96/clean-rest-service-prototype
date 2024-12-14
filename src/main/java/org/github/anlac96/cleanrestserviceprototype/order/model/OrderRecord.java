package org.github.anlac96.cleanrestserviceprototype.order.model;

import lombok.Data;
import org.github.anlac96.cleanrestserviceprototype.book.model.Book;

@Data
public class OrderRecord {
    private Book book;
    int quantity;
}
