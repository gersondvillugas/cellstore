package com.example.gerson.app.activities.Search;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.gerson.app.R;
import com.example.gerson.app.activities.ContainerArtefactos;
import com.example.gerson.app.activities.ListCarrito;
import com.example.gerson.app.models.Carrito;
import com.example.gerson.app.models.artefacto.Artefacto;
import com.example.gerson.app.models.artefacto.Celular;

import java.util.ArrayList;
import java.util.List;

public class Search extends AppCompatActivity  implements
        OnClickSearchItemListener,
        ContainerArtefactos {

    private TextView resultadosView;
    private LinearLayout filtroView;
    private LinearLayout carritoView;

    private Dialog dialog;

    List<Artefacto> artefactos;
    List<SearchItemAdapter.ViewHolder> searchHolders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        configToolbar();

        bindView();

        dialog = new Dialog(this);

        searchHolders = new ArrayList<>();

        generarData();

        configRecycler();

    }

    private void configRecycler(){
        RecyclerView artefactosList = (RecyclerView)findViewById(R.id.list_id);
        SearchItemAdapter adapter = new SearchItemAdapter(this, artefactos);
        artefactosList.setLayoutManager(new GridLayoutManager(this, 2));
        artefactosList.setAdapter(adapter);
        artefactosList.setFocusable(false);

    }

    private void configToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Busqueda");
        toolbar.setNavigationIcon(R.drawable.ic_backspace_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                finish();
            }
        });
    }

    private void bindView(){
        resultadosView = (TextView) findViewById(R.id.resultados_id);
        filtroView = (LinearLayout) findViewById(R.id.filtro_id);
        carritoView = (LinearLayout) findViewById(R.id.carrito_id);
    }
    private void generarData(){
        artefactos = new ArrayList<>();
        artefactos.add(
                new Celular(
                "HUAWEI MATE 20 PRO",
                "https://latienda.pe/7160-large_default/huawei-mate-20-pro.jpg",
                2999.0,
                "Kirin 980 octa-core",
                "Snapdragon",
                "OLED QHD+ de 6.39",
                128,
                4200));
        artefactos.add(
                new Celular(
                        "HUAWEI MATE 20 PRO",
                        "https://latienda.pe/7160-large_default/huawei-mate-20-pro.jpg",
                        2999.0,
                        "Kirin 980 octa-core",
                        "Snapdragon",
                        "OLED QHD+ de 6.39",
                        128,
                        4200));
        artefactos.add(
                new Celular(
                        "HUAWEI MATE 20 PRO",
                        "https://latienda.pe/7160-large_default/huawei-mate-20-pro.jpg",
                        2999.0,
                        "Kirin 980 octa-core",
                        "Snapdragon",
                        "OLED QHD+ de 6.39",
                        128,
                        4200));
        artefactos.add(
                new Celular(
                        "HUAWEI MATE 20 PRO",
                        "https://latienda.pe/7160-large_default/huawei-mate-20-pro.jpg",
                        2999.0,
                        "Kirin 980 octa-core",
                        "Snapdragon",
                        "OLED QHD+ de 6.39",
                        128,
                        4200));
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        List<Artefacto> carrito = Carrito.getInstance().getCarrito();
        for(SearchItemAdapter.ViewHolder viewHolder: searchHolders){
            Artefacto artefacto = viewHolder.getArtefacto();
            viewHolder.setAgregadoAlCarro(carrito.indexOf(artefacto)!=-1);
            viewHolder.updateDardoImage();
        }
        this.onClickItemDardo(null);

    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.my_menu,menu);
        return true;
    }

    @Override
    public void onClickItemLupa(Artefacto artefacto) {
        artefacto.configDialog(dialog);
        dialog.show();
    }

    @Override
    public void onClickItemDardo(Artefacto artefacto) {
        View view = Carrito.getInstance().getCarritoViewContent(this);
        carritoView.removeAllViews();
        carritoView.addView(view);
    }

    public void onClickCarrito(View view){
        Intent intent = new Intent(this, ListCarrito.class);
        startActivity(intent);
    }

    @Override
    public void addViewHolders(SearchItemAdapter.ViewHolder viewHolder) {
        searchHolders.add(viewHolder);
    }
}
