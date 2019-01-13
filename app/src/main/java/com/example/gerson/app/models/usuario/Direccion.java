package com.example.gerson.app.models.usuario;

public class Direccion {

    private static long count;

    private long _id;
    private String departamento;
    private String provincia;
    private String distrito;

    public Direccion(String departamento, String provincia, String distrito) {
        this.departamento = departamento;
        this.provincia = provincia;
        this.distrito = distrito;
        this._id = Direccion.count++;
    }
}

