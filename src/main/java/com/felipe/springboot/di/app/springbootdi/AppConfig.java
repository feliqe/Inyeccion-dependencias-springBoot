package com.felipe.springboot.di.app.springbootdi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;

import com.felipe.springboot.di.app.springbootdi.repositories.ProductRepository;
import com.felipe.springboot.di.app.springbootdi.repositories.ProductRepositoryJson;

@Configuration
@PropertySource("classpath:config.properties")
public class AppConfig {

    //@Value - se declara la ruta donde esta el Json se realiza en esta hoja ya que es un componente de spring
    @Value("classpath:json/product.json")
    //private - para que solo esta hoja tome el valor de json y se a enviado a la funcion
    private Resource resource;

    // @Bean - es para que sea un componente de spring
    // alias en bean para cambiar el nombre del procesos
    @Bean("productJson")
    ProductRepository productRepositoryJson(){
        return new ProductRepositoryJson(resource);
    }

}
