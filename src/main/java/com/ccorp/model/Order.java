package com.ccorp.model;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order {

    private Integer id;
    private OrderStatus status = OrderStatus.ABERTO;
    private Customer customer;
    private LocalDateTime  created = LocalDateTime.now();
    private Double totalBeforeDiscount;
    private Double discount;
    private Double totalAfterDiscount;
    private List<Item> itemList;


}
