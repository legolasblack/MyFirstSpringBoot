package com.marketapp.dependencyinyection.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.marketapp.dependencyinyection.models.Product;
import com.marketapp.dependencyinyection.services.ProductService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/v1/Products/")
public class ProductRestController {

    @GetMapping("/helloWord")
    public String getSaludo() {
        return "hello word Productos";
    }

    @GetMapping
    public List<Product> getAllProducts() {
        ProductService service = new ProductService();
        return service.findAll();
    }
    
    

}
