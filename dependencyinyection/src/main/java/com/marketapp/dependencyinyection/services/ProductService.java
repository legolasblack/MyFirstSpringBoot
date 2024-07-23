package com.marketapp.dependencyinyection.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.marketapp.dependencyinyection.models.Product;
import com.marketapp.dependencyinyection.repositories.IProductRepository;


@Component
public class ProductService implements IProductService{

    @Autowired
    private IProductRepository repository;

    public List<Product> findAll(){
        return repository.findAll().stream().map(p -> {
            Double priceTax = p.getPrice() * 1.25d;
            Product newProduct  = (Product)p.clone();
            newProduct.setPrice(priceTax.longValue());
            return p;
        }).collect(Collectors.toList());
    }

    public Product findById(Long id){
        return repository.findById(id);
    }
}
