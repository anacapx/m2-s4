package com.ccorp.service;

import com.ccorp.dao.ProductDao;
import com.ccorp.exception.customException.ResourceNotFoundException;
import com.ccorp.form.ProductUpdateForm;
import com.ccorp.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Primary
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductDao dao;

    @Override
    public List<Product> findAll() {
        List<Product> products = dao.findAll();
        return products;
    }

    @Override
    public Product findById(Long id) {
        Optional<Product> optional = dao.findById(id);
        if (optional.isEmpty()){
            throw new ResourceNotFoundException("Produto não encontrado!");
        }
        return optional.get();
    }

    public void save(Product product){
        dao.save(product);
    }

    @Override
    public void delete(Long id) {
        Product product = findById(id);

        dao.deleteById(id);
    }

    @Override
    public Product update(Long id, ProductUpdateForm form) {
        Product product = findById(id);

        if(form.getDescription() != null && form.getDescription() != ""){
            product.setDescription(form.getDescription());
        }

        if(form.getPrice() != null && form.getPrice() >= 0){
            product.setPrice(form.getPrice());
        }

        if(form.getName() != null && form.getName() != ""){
            product.setName(form.getName());
        }

        if(form.getStock() != null && form.getStock() >= 0){
            product.setStock(form.getStock());
        }

        return dao.save(product);
    }


    @Override
    public List<Product> saveAll(List<Product> products) {
        List<Product> savedProducts = new ArrayList<>();
        for (Product product:
             products) {
            dao.save(product);
            savedProducts.add(product);
        }
        return savedProducts;
    }
}
