package com.ccorp.controller;

import com.ccorp.dto.ProductDto;
import com.ccorp.dto.ProductListCreateDto;
import com.ccorp.form.ProductForm;
import com.ccorp.form.ProductUpdateForm;
import com.ccorp.model.Product;
import com.ccorp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService ProductService;

    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<?> getAll(){
        List<Product> products = ProductService.findAll();
        return ResponseEntity.ok(ProductDto.converter(products));
    }


    @GetMapping("/{id}")
    @ResponseBody
    public ProductDto detail(@PathVariable Long id){
        Product product = ProductService.findById(id);
        return new ProductDto(product);
    }

    //Thymeleaf
    @GetMapping("/thall")
    public String showAll(Model model){
        model.addAttribute("products", ProductService.findAll());
        return "product/allProducts";
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<ProductDto> cadastrar(@RequestBody @Valid ProductForm productForm, UriComponentsBuilder uriBuilder){
        Product product = productForm.converter();
        ProductService.save(product);

        URI uri = uriBuilder.path("/product/{id}").buildAndExpand(product.getId()).toUri();

        return ResponseEntity.created(uri).body(new ProductDto(product));
    }

    @GetMapping("/register/form")
    public String viewRegisterProductForm(Model model, Integer quantity){

        Product product = new Product();
        List<Product> productList = new ArrayList<>();
        model.addAttribute("productList", productList);
        model.addAttribute("product", product);
        model.addAttribute("quantity", quantity);

        ProductListCreateDto productform = new ProductListCreateDto();
        for(int i = 1; i<= quantity; i++){
            productform.addproduct(new Product());
        }

        model.addAttribute("form", productform);
        return "registerproductform";
    }

    @PostMapping("/register")
    public String registerProduct(@ModelAttribute ProductListCreateDto form, Model model){
        Double total = 0.0;
        List<Product> productList = form.getProducts();

        List<Product> savedProducts = ProductService.saveAll(productList);

        for (Product product: savedProducts){
            total += product.getPrice() * product.getStock();
        }

        model.addAttribute("products", savedProducts);
        model.addAttribute("total", total);
        return "product/allProducts";
    }

    @RequestMapping("")
    public String viewProductPage(){
        return "productpage";
    }

    @RequestMapping("/register/formquantity")
    public String viewProductQuantityForm(){
        return "productquantityform";
    }


    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<ProductDto> updateProduct(@PathVariable Long id, @RequestBody @Valid ProductUpdateForm form){

        return ResponseEntity.ok(new ProductDto(ProductService.update(id, form)));
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> deleteProduct(@PathVariable Long id){
        ProductService.delete(id);
        return ResponseEntity.ok().build();
    }





}
