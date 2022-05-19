package com.ccorp.form;

import com.ccorp.dao.ProductDao;
import com.ccorp.model.Product;
import com.ccorp.service.ProductService;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ProductUpdateForm {

    private String name;

    private String description;

    private Double price;

    private Integer stock;

    public Product converter(){
        return new Product(name, description, price, stock);
    }


}
