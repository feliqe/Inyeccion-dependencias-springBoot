package com.felipe.springboot.di.app.springbootdi.repositories;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.felipe.springboot.di.app.springbootdi.models.Product;

public class ProductRepositoryJson implements ProductRepository{

    private List<Product> list;

    //usar dos metodos declarativo y programatica

    //FORMA PROGRAMATICA
    public ProductRepositoryJson(){
        // extraer la informacion del json del archivo
        Resource resource = new ClassPathResource("json/product.json");
        // reutilizamos el campos con la gestion de tomar los datos del JSON
        readValueJson(resource);
    }

    //FORMA DECLARATIVA
    //repositorio donde se toma el archivo como valor recibido
    public ProductRepositoryJson(Resource resource){
        // reutilizamos el campos con la gestion de tomar los datos del JSON
        readValueJson(resource);
    }

    private void readValueJson(Resource resource){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // listar el valor indicando que lo tomamos por el archivo getFile
            list = Arrays.asList(objectMapper.readValue(resource.getInputStream(), Product[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    // mostrar todo los productos
    public List<Product> findAll() {
        return list;
    }

    @Override
    // buscar por el id
    public Product findById(Long id) {
        return list.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow();
    }

}
