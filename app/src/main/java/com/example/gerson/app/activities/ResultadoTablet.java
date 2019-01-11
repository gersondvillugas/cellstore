package com.example.gerson.app.activities;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.LinearLayout;

import com.example.gerson.app.R;
import com.example.gerson.app.adapters.ArtefactoCardItemAdapter;
import com.example.gerson.app.adapters.TabletCardItemAdapter;
import com.example.gerson.app.models.Artefacto;

import java.util.ArrayList;
import java.util.List;

public class ResultadoTablet extends AppCompatActivity {

    public List<Artefacto> artefactos;
    private Dialog dialog;
    private LinearLayout carrito;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_tablet);

        toolbar = (Toolbar)findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        dialog = new Dialog(this);
        dialog.setContentView(R.layout.tablet_detalles);
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
                "3.010 mAh Quick Charge 3.0", R.drawable.huawei
        ));
        RecyclerView artefactosList = (RecyclerView)findViewById(R.id.TabletList);
        artefactosList.setFocusable(false);
        TabletCardItemAdapter adapter = new TabletCardItemAdapter(this,artefactos, dialog);
        artefactosList.setLayoutManager(new GridLayoutManager(this,2));
        artefactosList.setAdapter(adapter);

    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.my_menu,menu);
        return true;
    }
}
