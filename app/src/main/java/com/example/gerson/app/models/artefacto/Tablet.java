package com.example.gerson.app.models.artefacto;

import com.example.gerson.app.models.artefacto.agregados.Marca;

public class Tablet extends Dispositivo{
    public Tablet(String nombre, String urlImg, Double precio, String marca, String procesador,
                  String gpu, String pantalla, int capacidad, int bateria) {
        super(nombre, urlImg, precio, marca, procesador, gpu, pantalla, capacidad, bateria);
    }

    public Tablet(String nombre, String urlImg, Double precio, String procesador,
                  String gpu, String pantalla, int capacidad, int bateria) {
        super(nombre, urlImg, precio, procesador, gpu, pantalla, capacidad, bateria);
    }
}
