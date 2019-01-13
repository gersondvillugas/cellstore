package com.example.gerson.app.models.artefacto;

import android.app.Dialog;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.gerson.app.R;
import com.example.gerson.app.models.artefacto.agregados.Camara;
import com.example.gerson.app.models.artefacto.agregados.Color;
import com.example.gerson.app.models.artefacto.agregados.Ram;

import java.util.ArrayList;
import java.util.List;

public class Dispositivo extends Artefacto {
    protected String procesador;
    protected String gpu;
    protected String pantalla;
    protected int capacidad;
    protected int bateria;

    public Dispositivo(String nombre, String urlImg, Double precio, String procesador,
                       String gpu, String pantalla, int capacidad, int bateria) {
        super(nombre, urlImg, precio);
        this.procesador = procesador;
        this.gpu = gpu;
        this.pantalla = pantalla;
        this.capacidad = capacidad;
        this.bateria = bateria;
    }

    public String getCamaras(){
        List<Camara> camaras = new ArrayList<>();
        camaras.add(new Camara(12));
        camaras.add(new Camara(16));
        String out = "";
        for(Camara camara: camaras){
            out += String.valueOf(camara.getValor()) + " / ";
        }
        out = out.substring(0,out.length()-3);
        return out;
    }
    public String getRams(){
        List<Ram> rams = new ArrayList<>();
        rams.add(new Ram(2));
        rams.add(new Ram(4));

        String out = "";
        for(Ram ram: rams){
            out += String.valueOf(ram.getValor()) + " / ";
        }
        out = out.substring(0,out.length()-3);
        return out;
    }
    public String getColores(){
        List<Color> colores = new ArrayList<>();
        colores.add(new Color("#FF00FF"));
        colores.add(new Color("#00FF00"));
        String out = "";
        for(Color color: colores){
            out += color.getNombre() + " / ";
        }
        out = out.substring(0,out.length()-3);
        return out;
    }

    public void configDialog(Dialog dialog){
        dialog.setContentView(R.layout.dispositivo_detalles);

        TextView nombreView = (TextView)dialog.findViewById(R.id.artefacto_nombre);
        TextView procesadorView = (TextView)dialog.findViewById(R.id.artefacto_procesador);
        TextView gpuView = (TextView)dialog.findViewById(R.id.artefacto_gpu);
        TextView camaraView = (TextView)dialog.findViewById(R.id.artefacto_camara);
        TextView pantallaView = (TextView)dialog.findViewById(R.id.artefacto_pantalla);
        TextView ramView = (TextView)dialog.findViewById(R.id.artefacto_ram);
        TextView capacidadView = (TextView)dialog.findViewById(R.id.artefacto_capacidad);
        TextView bateriaView = (TextView)dialog.findViewById(R.id.artefacto_bateria);
        TextView precioView = (TextView)dialog.findViewById(R.id.artefacto_precio);
        ImageView imgView = (ImageView)dialog.findViewById(R.id.artefacto_img);
        TextView cantidadView = (TextView)dialog.findViewById(R.id.artefacto_cantidad);

        nombreView.setText( nombre);
        procesadorView.setText( "Procesador: " + procesador);
        gpuView.setText(        "GPU: " + gpu);
        camaraView.setText(     "Camara: " + getCamaras() + " GB");
        pantallaView.setText(   "Pantalla: " + pantalla);
        ramView.setText(        "RAM: " + getRams() + " GB");
        capacidadView.setText(  "Capacidad : " + capacidad + "GB");
        bateriaView.setText(    "Bateria: " + bateria + " mAh");
        precioView.setText(     String.format("S/ %.2f",precio));
        Glide.with(dialog.getContext()).load(urlImg).into(imgView);
        cantidadView.setText("2");
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

    public String getPantalla() {
        return pantalla;
    }

    public void setPantalla(String pantalla) {
        this.pantalla = pantalla;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getBateria() {
        return bateria;
    }

    public void setBateria(int bateria) {
        this.bateria = bateria;
    }
}
