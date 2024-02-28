package com.felipe.springboot.di.app.springbootdi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felipe.springboot.di.app.springbootdi.models.Product;
import com.felipe.springboot.di.app.springbootdi.services.ProductService;

@RestController
@RequestMapping("/api")
public class SomeController {

    //@Autowired - ya no se isntancia con = new ProductServiceImpl(); ya que usamos el compoenete donde los crear ya la instanciamos de new
    @Autowired
    private ProductService service;
    // private ProductServiceImpl service;
    //traemos la intancia de contendor de services
    // private ProductServiceImpl service = new ProductServiceImpl();

    //mostramos todo usando la funcion del contenedor de services
    @GetMapping
    public List<Product> list(){
        return service.findAll();
    }

    //GetMapping -  indicamos el id que deseamos buscar en el contenedor de services
    @GetMapping("/{id}")
    public Product show(@PathVariable Long id){
        return service.findById(id);
    }
}