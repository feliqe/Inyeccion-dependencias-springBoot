package com.felipe.springboot.di.app.springbootdi.models;


//implements Cloneable - para indicar que se realizar la clonacion
public class Product implements Cloneable{

    private Long id;
    private String name;
    private Long price;

    public Product() {

    }
    public Product(Long id, String name, Long price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getPrice() {
        return price;
    }
    public void setPrice(Long price) {
        this.price = price;
    }

    @Override
    // se deja como public para que se pueda acceder
    public Object clone()  {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            //en caso de un error se muestran los datos de prodcuto
            return new Product(id,name,price);
        }
    }
}
