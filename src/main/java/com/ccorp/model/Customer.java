package com.ccorp.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Customer {

    private Integer id;
    private String email;
    private String name;
    private String cpf;
    private String cep;
    private String password;
    private List<Order> orderList;
}
