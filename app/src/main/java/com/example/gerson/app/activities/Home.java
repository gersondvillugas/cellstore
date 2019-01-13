package com.example.gerson.app.activities;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.gerson.app.R;
import com.example.gerson.app.activities.Search.OnClickSearchItemListener;
import com.example.gerson.app.activities.Search.Search;
import com.example.gerson.app.activities.Search.SearchItemAdapter;
import com.example.gerson.app.activities.auth.LoginActivity;
import com.example.gerson.app.activities.auth.RegisterActivity;
import com.example.gerson.app.models.artefacto.Artefacto;
import com.example.gerson.app.models.artefacto.Celular;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener,
        OnClickSearchItemListener,
        ContainerArtefactos {
    public List<Artefacto> artefactos;
    private Toolbar toolbar;
    private Button liscel;
    private NavigationView navigationView;
    private  DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        setToolbar();

        drawerLayout=(DrawerLayout)findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.setDrawerListener(toggle);

        toggle.syncState();

        navigationView=(NavigationView)findViewById(R.id.navigationId);
        navigationView.setNavigationItemSelectedListener(this);

        liscel=(Button)findViewById(R.id.idis);
        liscel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Home.this,LoginActivity.class);
                startActivity(i); }
        });

        generarData();

        RecyclerView artefactosList = (RecyclerView)findViewById(R.id.list_id);
        artefactosList.setFocusable(false);
        SearchItemAdapter adapter = new SearchItemAdapter(this,artefactos);
        artefactosList.setLayoutManager(new GridLayoutManager(this,2));
        artefactosList.setAdapter(adapter);
        //   ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawer,toolbar,"open navegation drawer","close navigation draver");



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


    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.my_menu,menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
       switch (item.getItemId()){
           case android.R.id.home:
               //
               drawerLayout.openDrawer(GravityCompat.START);
               return  true;
       }

        return super.onOptionsItemSelected(item);
    }
    public  void ircel(View view){
        Intent i=new Intent(Home.this,Search.class);
        startActivity(i);
    }

    public void listtable(View view) {
        Intent i=new Intent(Home.this,Search.class);
        startActivity(i);
    }
    /*public  boolean onNavigationItenSelected(MenuItem item){


    }*/
    private  void setToolbar(){
        toolbar=(Toolbar)findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_home);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        //here is the main place where we need to work on.
        int id=item.getItemId();
        switch (id){

            case R.id.inicioMenuId:
                Intent h= new Intent(Home.this,Home.class);
                startActivity(h);
                break;
            case R.id.miCuentaMenuId:
                Intent i= new Intent(Home.this,RegisterActivity.class);
                startActivity(i);
                break;


            // this is done, now let us go and intialise the home page.
            // after this lets start copying the above.
            // FOLLOW MEEEEE>>>
        }



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void onClickItemLupa(Artefacto artefacto) {

    }

    @Override
    public void onClickItemDardo(Artefacto artefacto) {

    }

    @Override
    public void addViewHolders(SearchItemAdapter.ViewHolder viewHolder) {

    }
}
