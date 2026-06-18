package com.spring_fast.main.controller;

import com.spring_fast.main.model.Product;
import com.spring_fast.main.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductsController {

    private final ProductService productService;

    public ProductsController(
            ProductService productService
    ) {
        this.productService = productService;
    }


    @GetMapping("/products")
    public String viewProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);

        return "products.html";
    }


    @PostMapping("/products")
    public String addProduct(
            Product product,
            Model model
    ) {
        productService.addProduct(product);

        List<Product> productsList = productService.getAllProducts();

        model.addAttribute("products", productsList);

        return "products.html";
    }
}
