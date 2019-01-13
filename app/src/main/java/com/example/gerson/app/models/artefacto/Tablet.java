package com.example.gerson.app.models.artefacto;

public class Tablet extends Dispositivo{

    public Tablet(String nombre, String urlImg, Double precio, String procesador,
                  String gpu, String pantalla, int capacidad, int bateria) {
        super(nombre, urlImg, precio, procesador, gpu, pantalla, capacidad, bateria);
    }
}
