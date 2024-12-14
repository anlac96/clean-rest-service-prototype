package org.github.anlac96.cleanrestserviceprototype.book.restapi.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class CreateBookRequest {
    private String title;
    private String author;
    private String genre;
    private double price;
}
