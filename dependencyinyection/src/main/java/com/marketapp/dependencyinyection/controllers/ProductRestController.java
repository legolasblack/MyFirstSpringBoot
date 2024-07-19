package com.marketapp.dependencyinyection.controllers;

import org.springframework.web.bind.annotation.RestController;
import com.marketapp.dependencyinyection.models.Product;
import com.marketapp.dependencyinyection.services.ProductService;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/v1")
public class ProductRestController {

    @Autowired
    ProductService service;

    @GetMapping("/helloWord")
    public Map<String, Object> getSaludo() {
        Map<String, Object> jsonResponse = new LinkedHashMap<>();
        jsonResponse.put("Status", "200");
        jsonResponse.put("http: ", "ok");
        jsonResponse.put("Message", "hello word");

        return jsonResponse;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Product getAProduct(@PathVariable Long id) {
        return service.findById(id);
    }

}
