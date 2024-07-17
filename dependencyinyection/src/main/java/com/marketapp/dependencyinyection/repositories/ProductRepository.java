package com.marketapp.dependencyinyection.repositories;

import java.util.Arrays;
import java.util.List;
import com.marketapp.dependencyinyection.models.Product;

public class ProductRepository {

    private List<Product> data;

    public ProductRepository() {
        this.data = Arrays.asList(
            new Product(1L,"funkopop Ragnar",1000L),
            new Product(2L,"mouse ocellot",45L),
            new Product(3L,"silla ocelot",3500L),
            new Product(4l, "cpu intel core i9", 9500L),
            new Product(5l, "cpu intel core i7", 7500L)
        );
    }

    public List<Product> findAll(){ 
        return data;
    }

    public Product findById(Long id){
        return data.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow();
    }
}
