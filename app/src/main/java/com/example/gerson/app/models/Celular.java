package com.example.gerson.app.models;

import com.example.gerson.app.CelDb;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

@Table(database = CelDb.class)
public class Celular extends BaseModel {
    @PrimaryKey(autoincrement =true)
    private long id;

    public  static final String ORDEN="orden";
    //  private Double precio;
    @Column
    private String procesador;
    @Column
    private String gpu;
    @Column
    private Double camara;
    @Column
    private String pantalla;
    @Column
    private String ram;
    @Column
    private String capacidad;
    @Column
    private String bateria;
    //   private int id_img;




    //AUMENTAR
    @Column
    public String name;
    @Column
    public  int poster;
    @Column
    public double precio;
    @Column
    public  String descripcion;
    public Celular(){

    }

    public Celular(String procesador, String gpu, Double camara, String pantalla, String ram, String capacidad, String bateria, String name, int poster, double precio, String descripcion) {
        this.procesador = procesador;
        this.gpu = gpu;
        this.camara = camara;
        this.pantalla = pantalla;
        this.ram = ram;
        this.capacidad = capacidad;
        this.bateria = bateria;
        this.name = name;
        this.poster = poster;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    public Celular(String name, int poster, double precio, String descripcion, String procesador, String gpu, Double camara, String pantalla, String ram, String capacidad, String bateria){
        this.name=name;
        this.camara=camara;
        this.pantalla=pantalla;
        this.ram=ram;
        this.gpu=gpu;
        this.procesador=procesador;
        this.capacidad=capacidad;
        this.bateria=bateria;
        this.poster=poster;
        this.precio=precio;
        this.descripcion=descripcion;
    }

    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
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

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getProcesador() {
        return procesador;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
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

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion( String descripcion) {
        this.descripcion=descripcion;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
