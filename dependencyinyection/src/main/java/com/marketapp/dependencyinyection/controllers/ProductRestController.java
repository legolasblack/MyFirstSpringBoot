package com.marketapp.dependencyinyection.controllers;

import org.springframework.web.bind.annotation.RestController;
import com.marketapp.dependencyinyection.models.Product;
import com.marketapp.dependencyinyection.services.IProductService;
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
/*Esta practica esta dedicada a ver los diferentes tipos de inyeccion que se puede tener dentro 
 * de una clase en concreto para desacoplar de una manera mas facil una implementacion y meter 
 * ota sin mover nada de codigo
 * 
 * metodo numero 1
 * 
 * por medio de la clase y el un @autowired
*/
    @Autowired
    IProductService service;

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
