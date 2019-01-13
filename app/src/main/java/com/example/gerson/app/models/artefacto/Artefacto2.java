package com.example.gerson.app.models.artefacto;

public class Artefacto2 {

    public static int count = 0;

    private long _id;
    private String nombre;
    private String urlImg;
    private Double precio;
    private String descripcion;

    public Artefacto2(String nombre, String urlImg, Double precio, String descripcion) {
        this.nombre = nombre;
        this.urlImg = urlImg;
        this.precio = precio;
        this.descripcion = descripcion;
        this._id = Artefacto2.count++;
    }

    public Artefacto2(String nombre, String urlImg, Double precio) {
        this.nombre = nombre;
        this.urlImg = urlImg;
        this.precio = precio;
        this._id = Artefacto2.count++;
    }
}
