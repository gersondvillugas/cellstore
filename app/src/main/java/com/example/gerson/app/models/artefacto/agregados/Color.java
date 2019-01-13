package com.example.gerson.app.models.artefacto.agregados;

public class Color {

    private static long count = 0;

    protected long _id;
    protected String nombre;

    public Color(String nombre) {
        this.nombre = nombre;
        this._id = count++;
    }

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
}
