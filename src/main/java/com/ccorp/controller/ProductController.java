package com.ccorp.controller;


import com.ccorp.DTO.ProductListCreateDTO;
import com.ccorp.model.Product;
import com.ccorp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {



    @Autowired
    ProductService ProductService;

    @RequestMapping("/")
    public String viewMainPage(){
        return "mainpage";
    }

    @RequestMapping("/product")
    public String viewProductPage(){
        return "productpage";
    }


//    @RequestMapping("/product/all")
//    public List<Product> getAllProducts(){
//
//    }

    @RequestMapping("/product/register/formquantity")
    public String viewProductQuantityForm(){
        return "productquantityform";
    }

    @GetMapping("/product/register/form")
    public String viewRegisterProductForm(Model model, Integer quantity){

        Product product = new Product();
        List<Product> productList = new ArrayList<>();
        model.addAttribute("productList", productList);
        model.addAttribute("product", product);
        model.addAttribute("quantity", quantity);
        model.addAttribute("name", "name");
        model.addAttribute("description", "description");
        model.addAttribute("price", "price");
        model.addAttribute("stock", "stock");

        ProductListCreateDTO productform = new ProductListCreateDTO();
        for(int i = 1; i<= quantity; i++){
            productform.addproduct(new Product());
        }

        model.addAttribute("form", productform);

        return "registerproductform";
    }

    @GetMapping("/product/all")
    public String showAll(Model model){
        model.addAttribute("products", ProductService.findAll());
        return "product/allProducts";
    }


    @PostMapping("/product/register")
    public String registerProduct(@ModelAttribute ProductListCreateDTO form, Model model){

        //ProductService.saveAll(form.getProducts());

        System.out.println(form.getProducts());

        List<Product> productList = form.getProducts();

        model.addAttribute("products", productList);
        return "product/allProducts";


    }
}
