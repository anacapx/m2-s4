package com.ccorp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "order_tb")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @JoinColumn(name = "order_status", columnDefinition = "smallint")
    @ManyToOne
    @JsonIgnoreProperties("orderList")
    private OrderStatus status;

    @JoinColumn(name = "customer_id")
    @ManyToOne
    @JsonIgnoreProperties("orderList")
    private Customer customer;

    @Column(name = "order_date")
    private LocalDateTime created = LocalDateTime.now();

    @Column(name = "total_before_discount")
    private Double totalBeforeDiscount;

    @Column(name = "discount")
    private Double discount;

    @Column(name = "total_after_discount")
    private Double totalAfterDiscount;

    @OneToMany (mappedBy = "order")
    @JsonIgnoreProperties("order")
    private List<Item> itemList;


}
