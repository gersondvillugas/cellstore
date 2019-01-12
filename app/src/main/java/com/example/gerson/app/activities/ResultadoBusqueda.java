package com.example.gerson.app.activities;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorLong;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.gerson.app.R;
import com.example.gerson.app.adapters.ArtefactoCardItemAdapter;
import com.example.gerson.app.models.Artefacto;
import com.example.gerson.app.models.Carrito;

import java.util.ArrayList;
import java.util.List;

public class ResultadoBusqueda extends AppCompatActivity {
    public List<Artefacto> artefactos;
    private Dialog dialog;
    private LinearLayout carrito;
    private Toolbar toolbar;

    private TextView resultadosView;
    private LinearLayout filtroView;
    private LinearLayout carritoView;
    private ImageView carritoImageView;
    private TextView carritoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_busqueda);

        resultadosView = findViewById(R.id.resultados_id);
        filtroView = findViewById(R.id.filtro_id);
        carritoView = findViewById(R.id.carrito_id);
        carritoImageView = findViewById(R.id.carrito_img_id);
        carritoTextView = findViewById(R.id.carrito_text_id);

        toolbar = (Toolbar)findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        dialog = new Dialog(this);
        dialog.setContentView(R.layout.artefacto_detalles);
        carrito = (LinearLayout)findViewById(R.id.carrito_id);

        artefactos = new ArrayList<>();
        artefactos.add(new Artefacto("Xiami Pocophone F1", 1479.00,
                "Snapdragon 660 octa-core Kryo 2.2 + 1.8 Ghz", "Adreno 512",
                20.0, "IPS, 5.99’’", "4 / 6 GB", "32 / 64 / 128",
                "3.010 mAh Quick Charge 3.0", R.drawable.sansung
        ));
        artefactos.add(new Artefacto("Xiaomi Mia A2", 789.00,
                "Snapdragon 660 octa-core Kryo 2.2 + 1.8 Ghz", "Adreno 512",
                20.0, "IPS, 5.99’’", "4 / 6 GB", "32 / 64 / 128",
                "3.010 mAh Quick Charge 3.0", R.drawable.xiaomi
        ));
        artefactos.add(new Artefacto("LG V35 ThinQ", 1599.00,
                "Snapdragon 845 octa-core", "Adreno 512",
                16.0, "IPS, 6’’", "6 GB", "64",
                "3.300 mAh", R.drawable.lg_v35_thinq
        ));
        artefactos.add(new Artefacto("Xiaomi Redmi 6", 529.00,
                "Helio P22 de ocho nucleos", "Adreno 512",
                12.0, "IPS, 5.45’’", "3 GB", "32",
                "3.000 mAh Quick Charge 3.0", R.drawable.xiaomi_redmi_6
        ));
        artefactos.add(new Artefacto("Xiami Pocophone F1", 1479.00,
                "Snapdragon 660 octa-core Kryo 2.2 + 1.8 Ghz", "Adreno 512",
                20.0, "IPS, 5.99’’", "4 / 6 GB", "32 / 64 / 128",
                "3.010 mAh Quick Charge 3.0", R.drawable.sansung
        ));
        artefactos.add(new Artefacto("Xiaomi Mia A2", 789.00,
                "Snapdragon 660 octa-core Kryo 2.2 + 1.8 Ghz", "Adreno 512",
                20.0, "IPS, 5.99’’", "4 / 6 GB", "32 / 64 / 128",
                "3.010 mAh Quick Charge 3.0", R.drawable.xiaomi
        ));

        RecyclerView artefactosList = (RecyclerView)findViewById(R.id.ArtefactosList);
        artefactosList.setFocusable(false);
        ArtefactoCardItemAdapter adapter = new ArtefactoCardItemAdapter(this,artefactos, dialog);
        artefactosList.setLayoutManager(new GridLayoutManager(this,2));
        artefactosList.setAdapter(adapter);

        resultadosView.setText("Resultados: " + artefactos.size());
        Carrito.getInstance().carritoFeedBack(this);
    }

    public void verificarCambios(){
        for(Artefacto artefacto : artefactos){

        }
    }



    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.my_menu,menu);
        return true;
    }

    public void onClickCarrito(View view){
        Intent intent = new Intent(this, ListCarrito.class);
        startActivity(intent);
    }

    public List<Artefacto> getArtefactos() {
        return artefactos;
    }

    public void setArtefactos(List<Artefacto> artefactos) {
        this.artefactos = artefactos;
    }

    public Dialog getDialog() {
        return dialog;
    }

    public void setDialog(Dialog dialog) {
        this.dialog = dialog;
    }

    public LinearLayout getCarrito() {
        return carrito;
    }

    public void setCarrito(LinearLayout carrito) {
        this.carrito = carrito;
    }

    public TextView getResultadosView() {
        return resultadosView;
    }

    public void setResultadosView(TextView resultadosView) {
        this.resultadosView = resultadosView;
    }

    public LinearLayout getFiltroView() {
        return filtroView;
    }

    public void setFiltroView(LinearLayout filtroView) {
        this.filtroView = filtroView;
    }

    public LinearLayout getCarritoView() {
        return carritoView;
    }

    public void setCarritoView(LinearLayout carritoView) {
        this.carritoView = carritoView;
    }

    public ImageView getCarritoImageView() {
        return carritoImageView;
    }

    public void setCarritoImageView(ImageView carritoImageView) {
        this.carritoImageView = carritoImageView;
    }

    public TextView getCarritoTextView() {
        return carritoTextView;
    }

    public void setCarritoTextView(TextView carritoTextView) {
        this.carritoTextView = carritoTextView;
    }

}
