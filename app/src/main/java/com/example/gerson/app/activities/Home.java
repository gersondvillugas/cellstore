package com.example.gerson.app.activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

import com.example.gerson.app.R;
import com.example.gerson.app.activities.auth.LoginActivity;
import com.example.gerson.app.activities.auth.RegisterActivity;
import com.example.gerson.app.adapters.ArtefactoCardItemAdapter;
import com.example.gerson.app.models.Artefacto;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
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
     //   ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawer,toolbar,"open navegation drawer","close navigation draver");



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
        Intent i=new Intent(Home.this,ResultadoBusqueda.class);
        startActivity(i);
    }

    public void listtable(View view) {
        Intent i=new Intent(Home.this,ResultadoTablet.class);
        startActivity(i);
    }
    /*public  boolean onNavigationItenSelected(MenuItem item){


    }*/
    private  void setToolbar(){
        Toolbar toolbar=(Toolbar)findViewById(R.id.my_toolbar);
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


}
