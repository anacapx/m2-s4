package com.ccorp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "product_tb")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @NotBlank(message = "O campo 'Nome' é obrigatório.")
    @Column(name = "product_name")
    private String name;

    @NotBlank(message = "O campo 'Descrição' é obrigatório.")
    @Column(name = "product_description")
    private String description;

    @NotNull(message = "O campo 'Preço' é obrigatório.")
    @Column(name = "product_price")
    private Double price;

    @NotNull(message = "O campo 'Estoque' é obrigatório.")
    @Column(name = "product_stock")
    private Integer stock;

    @OneToMany(mappedBy = "product")
    @JsonIgnoreProperties("product")
    private List<Item> itemList;

    public Product(String name, String description, Double price, Integer stock) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }
}
