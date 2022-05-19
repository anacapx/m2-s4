package com.ccorp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "order_status_tb")
public class OrderStatus {

    @Id
    @Column(name = "status_id")
    private Integer id;

    @Column(name = "status_name")
    private String name;

    @Column(name = "status_description")
    private String description;

    @OneToMany(mappedBy = "status")
    @JsonIgnoreProperties("status")
    List<Order> orderList;

}
