package com.ccorp.form;

import com.ccorp.model.Product;




import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductForm {

    @NotBlank(message = "O campo 'Nome' é obrigatório.")
    private String name;

    @NotBlank(message = "O campo 'Descrição' é obrigatório.")
    private String description;

    @NotNull(message = "O campo 'Preço' é obrigatório.")
    private Double price;

    @NotNull(message = "O campo 'Estoque' é obrigatório.")
    private Integer stock;

    public Product converter(){
        return new Product(name, description, price, stock);
    }
}
