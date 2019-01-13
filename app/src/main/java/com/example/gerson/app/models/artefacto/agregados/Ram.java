package com.example.gerson.app.models.artefacto.agregados;

public class Ram {

    private static long count = 0;

    private long _id;
    private int valor;

    public Ram(int valor) {
        this.valor = valor;
        this._id = count++;
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
