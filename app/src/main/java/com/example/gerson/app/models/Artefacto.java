package com.example.gerson.app.models;

public class Artefacto {
    private String nombre;
    private Double precio;
    private String procesador;
    private String gpu;
    private Double camara;
    private String pantalla;
    private String ram;
    private String capacidad;
    private String bateria;
    private int id_img;


    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getProcesador() {
        return procesador;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public int getId_img() {
        return id_img;
    }

    public void setId_img(int id_img) {
        this.id_img = id_img;
    }

    public Double getCamara() {
        return camara;
    }

    public void setCamara(Double camara) {
        this.camara = camara;
    }

    public String getPantalla() {
        return pantalla;
    }

    public void setPantalla(String pantalla) {
        this.pantalla = pantalla;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }

    public String getBateria() {
        return bateria;
    }

    public void setBateria(String bateria) {
        this.bateria = bateria;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Artefacto(
            String nombre,
            Double precio,

            String procesador,
            String gpu,
            Double camara,
            String pantalla,
            String ram,
            String capacidad,
            String bateria,
            int id_img
    ){
        this.nombre = nombre;
        this.precio = precio;
        this.procesador = procesador;
        this.gpu = gpu;
        this.camara = camara;
        this.pantalla = pantalla;
        this.ram = ram;
        this.capacidad = capacidad;
        this.bateria = bateria;
        this.id_img = id_img;
    }
}
