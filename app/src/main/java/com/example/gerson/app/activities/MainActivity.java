package com.example.gerson.app.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
    private int counter=0;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        celulars=this.getAllCelulares();
        mRecyclerView=(RecyclerView) findViewById(R.id.recyclerView);
        mLayoutManager=new LinearLayoutManager(this);
//mLayoutManager=new GridLayoutManager(this,2);
//mLayoutManager=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        mAdapter= new MyAdapter(celulars, R.layout.recicler_view_item, new MyAdapter.OnItemClickListener() {


            @Override
            public void onItemClick(Celular celular, int posicion) {
                //  removeMovie(posicion);
                sPhone.setName(celular.getName());
                sPhone.setPrecio(celular.getPrecio());
                sPhone.setDescripcion(celular.getDescripcion());
                sPhone.setPoster(celular.getPoster());


                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra(Celular.ORDEN,mAdapter.getItemCount()+1);
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




    private List<Celular>getAllCelulares(){
        return new ArrayList<Celular>(){{
            add(new Celular("HUAWEI",R.drawable.huawei,"$100",""));
            add(new Celular("SAMSUNG",R.drawable.samsung,"$400",""));
            add(new Celular("IPHONE",R.drawable.iphone,"$1000",""));


        }};
    }

}