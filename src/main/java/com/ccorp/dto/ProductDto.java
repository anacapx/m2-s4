package com.ccorp.dto;

import com.ccorp.model.Product;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ProductDto {

    private Long id;
    private String name;
    private String description;
    private Double price;
    private Integer stock;

    public ProductDto(Product product){
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.stock = product.getStock();
    }

    public static List<ProductDto> converter(List<Product> produtos){
        return produtos.stream().map(ProductDto::new).collect(Collectors.toList());
    }




}
