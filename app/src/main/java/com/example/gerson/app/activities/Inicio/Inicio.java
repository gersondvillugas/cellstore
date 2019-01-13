package com.example.gerson.app.activities.Inicio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.gerson.app.R;
import com.example.gerson.app.activities.Search.OnClickSearchItemListener;
import com.example.gerson.app.activities.Search.SearchItemAdapter;
import com.example.gerson.app.models.artefacto.Artefacto;
import com.example.gerson.app.models.artefacto.Celular;

import java.util.ArrayList;
import java.util.List;

public class Inicio extends AppCompatActivity implements OnClickSearchItemListener {
    public List<Artefacto> artefactos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        generarData();

        RecyclerView artefactosList = (RecyclerView)findViewById(R.id.list_id);
        SearchItemAdapter adapter = new SearchItemAdapter(this, artefactos);
        artefactosList.setLayoutManager(new GridLayoutManager(this, 2));
        artefactosList.setAdapter(adapter);
        artefactosList.setFocusable(false);


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
    public void onClickItemLupa(Artefacto artefacto) {

    }

    @Override
    public void onClickItemDardo(Artefacto artefacto) {

    }
}
