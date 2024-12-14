package org.github.anlac96.cleanrestserviceprototype.book.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Book {
    private String bookId;
    private String title;
    private String author;
    private String genre;
    private double price;
}


