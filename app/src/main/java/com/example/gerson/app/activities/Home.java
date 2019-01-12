package com.example.gerson.app.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.example.gerson.app.R;
import com.example.gerson.app.activities.auth.RegisterActivity;
import com.example.gerson.app.adapters.ArtefactoCardItemAdapter;
import com.example.gerson.app.models.Artefacto;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {
    public List<Artefacto> artefactos;
    private Toolbar toolbar;
    private Button liscel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        toolbar = (Toolbar)findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
         liscel=(Button)findViewById(R.id.idis);
         liscel.setOnClickListener(new View.OnClickListener() {


             @Override
             public void onClick(View v) {
                 Intent i=new Intent(Home.this,RegisterActivity.class);
                 startActivity(i);
             }
         });
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
        artefactosList.setFocusable(false);
        ArtefactoCardItemAdapter adapter = new ArtefactoCardItemAdapter(this,artefactos, null);
        artefactosList.setLayoutManager(new GridLayoutManager(this,2));
        artefactosList.setAdapter(adapter);

    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.my_menu,menu);
        return true;
    }
    public  void ircel(View view){
        Intent i=new Intent(Home.this,ResultadoBusqueda.class);
        startActivity(i);
    }

    public void listtable(View view) {
        Intent i=new Intent(Home.this,ResultadoTablet.class);
        startActivity(i);
    }
}
