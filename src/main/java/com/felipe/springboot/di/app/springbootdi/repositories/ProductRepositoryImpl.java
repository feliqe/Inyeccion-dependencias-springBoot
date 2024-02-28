package com.felipe.springboot.di.app.springbootdi.repositories;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
// import org.springframework.web.context.annotation.SessionScope;

import com.felipe.springboot.di.app.springbootdi.models.Product;

//los componente existen por la sessiones del navegador
// @SessionScope

//@Primary - define cual es el primero en este caso es cuando hay un @Repository
@Primary
//un alias para poder usarlo en Qualifier
@Repository("productList")
public class ProductRepositoryImpl implements ProductRepository {

    private List<Product> data;

    public ProductRepositoryImpl(){
        this.data = Arrays.asList(
            new Product(1L,"Memoria corsair 32",300L),
            new Product(2L,"Cpu Intel core 19",850L),
            new Product(3L,"Teclado Razer Mini 60%",180L),
            new Product(4L,"Motherboard Gigabyte",490L)
        );
    }

    //mostrar todos los campos de Productos
    @Override
    public List<Product> findAll(){
        return data;
    }

    //buscar por id
    @Override
    public Product findById(Long id){
        //filter - filtrar
        //findFirst - un resultado
        //orElse -  si no encuentra datos enviar un null
        return data.stream().filter(p->p.getId().equals(id)).findFirst().orElse(null);
    }
}
