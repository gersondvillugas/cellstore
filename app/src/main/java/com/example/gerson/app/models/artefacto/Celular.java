package com.example.gerson.app.models.artefacto;

import com.example.gerson.app.models.artefacto.agregados.Marca;
import com.example.gerson.app.models.artefacto.agregados.Operador;

import java.util.List;

public class Celular extends Dispositivo{
    public Celular(String nombre, String urlImg, Double precio, String marca, String procesador,
                   String gpu, String pantalla, int capacidad, int bateria) {
        super(nombre, urlImg, precio, marca, procesador, gpu, pantalla, capacidad, bateria);
    }

    public Celular(String nombre, String urlImg, Double precio, String procesador, String gpu,
                   String pantalla, int capacidad, int bateria) {
        super(nombre, urlImg, precio, procesador, gpu, pantalla, capacidad, bateria);
    }

    public List<Operador> getOperadores(){
        return null;
    }
}
