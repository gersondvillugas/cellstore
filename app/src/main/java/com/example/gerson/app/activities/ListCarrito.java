package com.example.gerson.app.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.example.gerson.app.R;
import com.example.gerson.app.adapters.ArtefactoCarritoItemAdapter;
import com.example.gerson.app.models.Carrito;
import com.example.gerson.app.models.artefacto.Artefacto;

import java.util.List;

public class ListCarrito extends AppCompatActivity {
    public List<Artefacto> artefactos;
    private RecyclerView listArtefactosView;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_carrito);

        toolbar = (Toolbar)findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        artefactos = Carrito.getInstance().getCarrito();

        listArtefactosView = findViewById(R.id.list_artefactos);
        listArtefactosView.setFocusable(false);
        ArtefactoCarritoItemAdapter adapter = new ArtefactoCarritoItemAdapter(this,artefactos);
        listArtefactosView.setLayoutManager(new GridLayoutManager(this,1 ));
        listArtefactosView.setAdapter(adapter);

    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.my_menu,menu);
        return true;
    }
}
