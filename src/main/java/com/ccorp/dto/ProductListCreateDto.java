package com.ccorp.dto;

import com.ccorp.model.Product;
import java.util.ArrayList;
import java.util.List;

public class ProductListCreateDto {

    private List<Product> products;

    public ProductListCreateDto(List<Product> products) {
        this.products = products;
    }

    public ProductListCreateDto() {
        this.products = new ArrayList<>();
    }

    public void addproduct(Product product) {
        this.products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

}
