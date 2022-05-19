package com.ccorp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "item_tb")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;

    @Column(name = "order_item")
    private Integer orderItem;

    @ManyToOne
    @JoinColumn(name = "order_id")
    @JsonIgnoreProperties("itemList")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonIgnoreProperties("itemList")
    private Product product;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "un_price")
    private Double unPrice;

    @Column(name = "total_price")
    private Double totalPrice;


}
