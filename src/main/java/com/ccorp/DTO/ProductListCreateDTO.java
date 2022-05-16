package com.ccorp.DTO;

import com.ccorp.model.Product;
import java.util.ArrayList;
import java.util.List;

public class ProductListCreateDTO {

    private List<Product> products;

    public ProductListCreateDTO(List<Product> products) {
        this.products = products;
    }

    public ProductListCreateDTO() {
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
