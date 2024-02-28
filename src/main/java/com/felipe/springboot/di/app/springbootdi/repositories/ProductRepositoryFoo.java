package com.felipe.springboot.di.app.springbootdi.repositories;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.felipe.springboot.di.app.springbootdi.models.Product;

@Repository
//implements - es para poder usar otra implementacion o repositorio en este caso usar el repositorio
public class ProductRepositoryFoo implements ProductRepository {

    @Override
    public List<Product> findAll() {
        return Collections.singletonList(new Product(1L,"Monitor Asus 27", 600L));
    }

    @Override
    public Product findById(Long id) {
        return new Product(1L,"Monitor Asus 27", 600L);
    }
}
