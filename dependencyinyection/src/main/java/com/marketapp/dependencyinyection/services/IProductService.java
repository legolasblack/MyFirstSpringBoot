package com.marketapp.dependencyinyection.services;

import java.util.List;
import com.marketapp.dependencyinyection.models.Product;

public interface IProductService {
    
    public List<Product> findAll();
    public Product findById(Long id);
}
