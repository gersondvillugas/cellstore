package com.example.gerson.app.activities;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.example.gerson.app.R;
import com.example.gerson.app.adapters.ArtefactoCardItemAdapter;
import com.example.gerson.app.models.Artefacto;

import java.util.ArrayList;
import java.util.List;

public class ResultadoBusqueda extends AppCompatActivity {
    public List<Artefacto> artefactos;
    private ScrollView scroll;
    private Dialog dialog;
    private LinearLayout carrito;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_busqueda);

        scroll = (ScrollView)findViewById(R.id.scroll);
        scroll.fullScroll(ScrollView.FOCUS_UP);

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
        ArtefactoCardItemAdapter adapter = new ArtefactoCardItemAdapter(this,artefactos, dialog);
        artefactosList.setLayoutManager(new GridLayoutManager(this,2));
        artefactosList.setAdapter(adapter);

    }
}
