package com.ccorp.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Item {

    private Integer orderItem;
    private Order order;
    private Product product;
    private Integer quantity;
    private Double unPrice;
    private Double totalPrice;


}
