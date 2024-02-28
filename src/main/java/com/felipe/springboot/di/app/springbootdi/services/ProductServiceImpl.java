package com.felipe.springboot.di.app.springbootdi.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.felipe.springboot.di.app.springbootdi.models.Product;
import com.felipe.springboot.di.app.springbootdi.repositories.ProductRepository;

@Service
//acceden a los datos del repositorio
public class ProductServiceImpl implements ProductService {

    //@Autowired - ya no se isntancia con = new ProductRepositoryImpl(); ya que usamos el componente donde los crear ya la instancia de new
    @Autowired
    //Environment - para realizar la conexion de la hoja de AppConfig
    private Environment environment;
    private ProductRepository repository;

    //acceso a los datos de reposotorio
    // private ProductRepositoryImpl repository = new ProductRepositoryImpl();

    //Qualifier -  seleccionar el componente por su nombre
    public ProductServiceImpl(@Qualifier("productJson") ProductRepository repository){
        this.repository = repository;
    }

    @Override
    public List<Product> findAll(){
        //cambiar el valor de los precios
        return repository.findAll().stream().map(p->{
            ////Double - transformar los datos a un double por el resultado de decimales de la multiplicacion
            //environment - indicamos el nombre del campo con el valor a multiplicar, se traforma a la clase de Double
            Double priceImp = p.getPrice() * environment.getProperty("config.price.tax",Double.class);
            ////longValue - tranfromamos el valor a un Long nuevamnete
            //p.setPrice(priceImp.longValue());
            ////return p;
            ////newProd -  solo lo realiza la la list pero no para las demas acciones como el buscar por id, siempre se crea una nueva instancia
            //Product newProd = new Product(p.getId(), p.getName(), priceImp.longValue());

            //(Product) p.clone() - usamos la funciomn del modelos clone ((Buena practica))
            Product newProd = (Product) p.clone();
            newProd.setPrice(priceImp.longValue());
            return newProd;
            ////collect - convertir Stream a una lista con toList
        }).collect(Collectors.toList());
    }

    @Override
    public Product findById(Long id){
        return repository.findById(id);
    }
}
