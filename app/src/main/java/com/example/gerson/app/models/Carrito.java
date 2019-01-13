package com.example.gerson.app.models;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.gerson.app.R;
import com.example.gerson.app.models.artefacto.Artefacto;

import java.util.ArrayList;
import java.util.List;

public class Carrito {

    private List<Artefacto> carrito;

    ///////////// SINGLETON //////////////
    private static Carrito instance;

    private Carrito(){
        carrito = new ArrayList<>();
    }

    public static Carrito getInstance(){
        if(instance == null){
            instance = new Carrito();
        }
        return instance;
    }
    /////////////////////////////////////////
    public List<Artefacto> getCarrito() {
        return carrito;
    }

    public void setCarrito(List<Artefacto> carrito) {
        this.carrito = carrito;
    }

    public void addArtefacto(Artefacto artefacto){
        this.carrito.add(artefacto);
    }
    public void removeArtefacto(Artefacto artefacto){
        this.carrito.remove(artefacto);
    }
    public void vaciarCarrito(){
        this.carrito = new ArrayList<>();
    }
    public View getCarritoViewContent(Context context){
        LayoutInflater inflater = LayoutInflater.from(context);
        View content;

        int size = Carrito.getInstance().getCarrito().size();

        if(size > 0){
            content = (RelativeLayout)inflater.inflate(R.layout.activity_search_carrito_icon_number,null);
            TextView carritoText = (TextView)content.findViewById(R.id.carrito_text_id);
            carritoText.setText(String.valueOf(size));
        }else{
            content = (LinearLayout)inflater.inflate(R.layout.activity_search_carrito_icon_letras,null);
        }
        return content;

    }
}
