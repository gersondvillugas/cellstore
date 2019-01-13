package com.example.gerson.app.models.artefacto;

import com.example.gerson.app.models.artefacto.agregados.Camara;
import com.example.gerson.app.models.artefacto.agregados.Color;
import com.example.gerson.app.models.artefacto.agregados.Ram;

import java.util.List;

public class Dispositivo extends Artefacto2{
    private String procesador;
    private String gpu;
    private String pantalla;
    private int capacidad;
    private int bateria;

    public Dispositivo(String nombre, String urlImg, Double precio, String procesador,
                       String gpu, String pantalla, int capacidad, int bateria) {
        super(nombre, urlImg, precio);
        this.procesador = procesador;
        this.gpu = gpu;
        this.pantalla = pantalla;
        this.capacidad = capacidad;
        this.bateria = bateria;
    }
    public List<Camara> getCamaras(){
        return null;
    }
    public List<Ram> getRams(){
        return null;
    }
    public List<Color> getColores(){
        return null;
    }
}
