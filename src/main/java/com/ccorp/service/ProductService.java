package com.ccorp.service;

import com.ccorp.model.Product;
import java.util.List;

public interface ProductService {
    List<Product> findAll();
    void saveAll(List<Product> products);
}
