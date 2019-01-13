package com.example.gerson.app.models.artefacto;

import android.app.Dialog;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.gerson.app.R;
<<<<<<< HEAD
import com.example.gerson.app.models.artefacto.agregados.Camara;
import com.example.gerson.app.models.artefacto.agregados.Color;
import com.example.gerson.app.models.artefacto.agregados.Ram;

import java.util.ArrayList;
import java.util.List;
=======
import com.example.gerson.app.models.artefacto.agregados.Marca;
>>>>>>> 4cfca7774ac40303370d5821d880f0e6a73f5364

public class Accesorio extends Artefacto {
    public Accesorio(String nombre, String urlImg, Double precio) {
        super(nombre, urlImg, precio);
    }

<<<<<<< HEAD
=======
    public Accesorio(String nombre, String urlImg, Double precio, String marca) {
        super(nombre, urlImg, precio, marca);
    }
>>>>>>> 4cfca7774ac40303370d5821d880f0e6a73f5364

    public void configDialog(Dialog dialog){
        dialog.setContentView(R.layout.accesorios_detalles);

        TextView nombreView = (TextView)dialog.findViewById(R.id.acessorio_nombre);

        TextView precioView = (TextView)dialog.findViewById(R.id.acessorio_precio);
        ImageView imgView = (ImageView)dialog.findViewById(R.id.accesorio_img);
        TextView cantidadView = (TextView)dialog.findViewById(R.id.acessorio_cantidad);

        nombreView.setText( nombre);

        precioView.setText(     String.format("S/ %.2f",precio));
        Glide.with(dialog.getContext()).load(urlImg).into(imgView);
        cantidadView.setText("2");
    }
}
