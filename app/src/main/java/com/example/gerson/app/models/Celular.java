package com.example.gerson.app.models;

public class Celular {
    public  static final String ORDEN="orden";

    public String name;
    public  int poster;
    public String precio;
    public  String descripcion;
    public Celular(){

    }
    public Celular(String name ,int poster,String precio,String descripcion){
        this.name=name;
        this.poster=poster;
        this.precio=precio;
       this.descripcion=descripcion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion( String descripcion) {
        this.descripcion=descripcion;
    }
}
