package com.example.gerson.app.models.artefacto;

import android.app.Dialog;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.gerson.app.R;

public class Accesorio extends Artefacto {
    public Accesorio(String nombre, String urlImg, Double precio) {
        super(nombre, urlImg, precio);
    }
    public void configDialog(Dialog dialog){
        TextView nombreView = (TextView)dialog.findViewById(R.id.artefacto_nombre);
        TextView precioView = (TextView)dialog.findViewById(R.id.artefacto_precio);
        ImageView imgView = (ImageView)dialog.findViewById(R.id.artefacto_img);
        TextView cantidadView = (TextView)dialog.findViewById(R.id.artefacto_cantidad);

        nombreView.setText( nombre);
        precioView.setText(     String.format("S/ %.2f",precio));
        Glide.with(dialog.getContext()).load(urlImg).into(imgView);
        cantidadView.setText("2");
    }
}
