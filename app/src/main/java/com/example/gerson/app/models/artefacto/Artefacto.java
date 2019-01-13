package com.example.gerson.app.models.artefacto;

import android.app.Dialog;
import android.content.Context;

import com.example.gerson.app.models.artefacto.agregados.Marca;

public class Artefacto {

    public static int count = 0;

    protected long _id;
    protected String nombre;
    protected String urlImg;
    protected Double precio;
    protected String marca;

    public void configDialog(Dialog dialog){}

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Artefacto(String nombre, String urlImg, Double precio, String marca) {
        this.nombre = nombre;
        this.urlImg = urlImg;
        this.precio = precio;
        this.marca = marca;
    }

    public Artefacto(String nombre, String urlImg, Double precio) {
        this.nombre = nombre;
        this.urlImg = urlImg;
        this.precio = precio;
        this._id = Artefacto.count++;
    }
}
