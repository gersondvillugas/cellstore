package com.example.gerson.app.models;

import java.util.ArrayList;
import java.util.List;

public class Carrito {

    private List<Artefacto> carrito;

    ///////////// SINGLETON //////////////
    private static Carrito instance;

    private Carrito(){
        carrito = new ArrayList<>();
    }

    public static Carrito getInstance(){
        if(instance == null){
            instance = new Carrito();
        }
        return instance;
    }
    /////////////////////////////////////////
    public List<Artefacto> getCarrito() {
        return carrito;
    }

    public void setCarrito(List<Artefacto> carrito) {
        this.carrito = carrito;
    }

    public void addArtefacto(Artefacto artefacto){
        this.carrito.add(artefacto);
    }
    public void removeArtefacto(Artefacto artefacto){

    }
    public void vaciarCarrito(){
        this.carrito = new ArrayList<>();
    }
}
