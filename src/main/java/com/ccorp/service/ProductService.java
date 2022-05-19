package com.ccorp.service;

import com.ccorp.form.ProductUpdateForm;
import com.ccorp.model.Product;
import java.util.List;

public interface ProductService {

    List<Product> findAll();
    Product findById(Long id);

    List<Product> saveAll(List<Product> products);
    void save(Product product);

    void delete(Long id);

    Product update(Long id, ProductUpdateForm form);

}
