package com.example.gerson.app.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.gerson.app.R;
import com.example.gerson.app.adapters.MyAdapter;
import com.example.gerson.app.models.Celular;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private List<Celular> celulars;
    public static final Celular sPhone = new Celular();

    private RecyclerView mRecyclerView;
    private int counter = 0;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        celulars = this.getAllCelulares();
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(this);
//mLayoutManager=new GridLayoutManager(this,2);
//mLayoutManager=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        mAdapter = new MyAdapter(celulars, R.layout.recicler_view_item, new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Celular celular, int posicion) {
                //  removeMovie(posicion);
                sPhone.setName(celular.getName());
                sPhone.setPrecio(celular.getPrecio());
                sPhone.setDescripcion(celular.getDescripcion());
                sPhone.setPoster(celular.getPoster());

                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra(Celular.ORDEN, mAdapter.getItemCount() + 1);
                startActivity(intent);
            }


        }) {
            @Override
            public void onEntrada(Object entrada, View view) {

            }
        };
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(mLayoutManager);
    }


    private List<Celular> getAllCelulares() {
        final String[] nombres = {"HUAWEI", "IPHONE 6", "SAMSUNG S6", "MOTO G4"};
        final Integer[] poster = {R.drawable.huawei, R.drawable.iphone, R.drawable.samsung, R.drawable.huawei2};
        final Double[] precio = {169.90, 600.80, 250.90, 459.5};
        final String[] descripcion = {"", "", "", ""};
        final String[] procesador = {"p", "p", "p", "p"};
        final String[] gpu = {"gp", "gpu", "gpu", "gpu"};
        final Double[] camara = {13.0, 13.0, 13.0, 13.0};
        final String[] pantalla = {"5 pulgas ", "6 pulgadas", "6 pulgadas", "7 pulgadas"};
        final String[] ram = {"4 gb ", " 8 gb", "6 gb", " 4 gb"};
        final String[] capacidad = {"5 pulgas ", "6 pulgadas", "6 pulgadas", "7 pulgadas"};
        final String[] bateria = {"5 pulgas ", "6 pulgadas", "6 pulgadas", "7 pulgadas"};
        return new ArrayList<Celular>() {
            {
                //   add(new Celular("HUAWEI",R.drawable.huawei,100,"",""));
                // add(new Celular("SAMSUNG",R.drawable.samsung,"$400",""));
                //  add(new Celular("IPHONE",R.drawable.iphone,"$1000",""));
                for (int i = 0; i < 4; i++) {
                    add(new Celular(nombres[i], poster[i], precio[i], descripcion[i], procesador[i], gpu[i], camara[i]
                            , pantalla[i], ram[i], capacidad[i], bateria[i]));

                    try {
                        sPhone.save();
                        Log.i("Dbflow", "insertion good of date");
                    } catch (Exception e) {
                        e.printStackTrace();
                        Log.i("Dbflow", "wrong to insert data");

                    }
                }


        }};

    }
}