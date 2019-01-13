package com.example.gerson.app.models.usuario;

public class Tarjeta {

    private static long count = 0;

    private long _id;
    private String numeroDeTarjeta;
    private String fechaExpiracion;
    private String cvc2;

    public Tarjeta(String numeroDeTarjeta, String fechaExpiracion, String cvc2) {
        this.numeroDeTarjeta = numeroDeTarjeta;
        this.fechaExpiracion = fechaExpiracion;
        this.cvc2 = cvc2;
        this._id = Tarjeta.count++;
    }
}
