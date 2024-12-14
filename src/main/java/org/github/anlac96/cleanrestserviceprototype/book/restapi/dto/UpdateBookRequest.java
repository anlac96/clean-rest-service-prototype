package org.github.anlac96.cleanrestserviceprototype.book.restapi.dto;

import lombok.Data;

@Data
public class UpdateBookRequest {
    private String title;
    private String author;
    private String genre;
    private double price;
}
