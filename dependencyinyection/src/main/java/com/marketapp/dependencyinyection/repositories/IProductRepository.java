package com.marketapp.dependencyinyection.repositories;

import java.util.List;

import com.marketapp.dependencyinyection.models.Product;

public interface IProductRepository {
    List<Product> findAll();
    Product findById(Long id);


}
