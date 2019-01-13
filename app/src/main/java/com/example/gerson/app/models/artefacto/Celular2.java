package com.example.gerson.app.models.artefacto;

import com.example.gerson.app.models.artefacto.agregados.Operador;

import java.util.List;

public class Celular2 extends Dispositivo{

    public Celular2(String nombre, String urlImg, Double precio, String procesador, String gpu,
                    String pantalla, int capacidad, int bateria) {
        super(nombre, urlImg, precio, procesador, gpu, pantalla, capacidad, bateria);
    }

    public List<Operador> getOperadores(){
        return null;
    }
}
