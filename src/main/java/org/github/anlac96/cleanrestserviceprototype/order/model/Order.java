package org.github.anlac96.cleanrestserviceprototype.order.model;

import lombok.Data;

import java.util.List;

import java.util.Date;

@Data
public class Order {
    private int orderId;
    private String customerId;
    private Date orderDate;
    private List<OrderRecord> books;
    private double totalAmount;
}

