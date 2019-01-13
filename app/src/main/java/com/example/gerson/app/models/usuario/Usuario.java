package com.example.gerson.app.models.usuario;

public class Usuario {
    private static long count = 0;
    private long _id;
    private String nombre;
    private String apellido;
    private String contraseña;
    private String email;
    private String dni;
    private String telefono;
    private String codigoDeCiudad;
    private Direccion direccion;
    private Tarjeta tarjeta;

    public Usuario(String nombre, String apellido, String contraseña, String email, String dni,
                   String telefono, String codigoDeCiudad, Direccion direccion, Tarjeta tarjeta) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.contraseña = contraseña;
        this.email = email;
        this.dni = dni;
        this.telefono = telefono;
        this.codigoDeCiudad = codigoDeCiudad;
        this.direccion = direccion;
        this.tarjeta = tarjeta;
        this._id = Usuario.count++;
    }

    public Boolean pagarConTarjeta(String nombre, String dni, String email, Double valor, Tarjeta tarjeta){
        return false;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCodigoDeCiudad() {
        return codigoDeCiudad;
    }

    public void setCodigoDeCiudad(String codigoDeCiudad) {
        this.codigoDeCiudad = codigoDeCiudad;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }


}
