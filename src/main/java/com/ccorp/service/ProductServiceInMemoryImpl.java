package com.ccorp.service;

import com.ccorp.form.ProductUpdateForm;
import com.ccorp.model.Product;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


public class ProductServiceInMemoryImpl implements ProductService{

    static Map<Long, Product> productDB = new HashMap<>();

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productDB.values());
    }

    @Override
    public Product findById(Long id) {
        return null;
    }

    @Override
    public List<Product> saveAll(List<Product> products) {
        Long nextId = getNextId();
        for (Product product : products) {
            if (product.getId() == 0) {
                product.setId(nextId++);
            }
        }

        Map<Long, Product> productMap = products.stream()
                .collect(Collectors.toMap(Product::getId, Function.identity()));

        productDB.putAll(productMap);
        return products;
    }

    @Override
    public void save(Product product) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Product update(Long id, ProductUpdateForm form) {
        Product x = new Product();
        return x ;
    }


    private Long getNextId() {
            return productDB.keySet()
                    .stream()
                    .mapToLong(value -> value)
                    .max()
                    .orElse(0) + 1;
        }
    }
