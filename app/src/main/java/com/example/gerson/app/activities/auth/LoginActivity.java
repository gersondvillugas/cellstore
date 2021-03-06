package com.example.gerson.app.activities.auth;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gerson.app.DatabaseHelper;
import com.example.gerson.app.R;

public class LoginActivity  extends AppCompatActivity{

    EditText e1,e2;
    Button b1;
    DatabaseHelper db;
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acvivity_login);

        configToolbar();

        db=new DatabaseHelper(this);

        e1=(EditText)findViewById(R.id.editext1);
        e2=(EditText)findViewById(R.id.editext2);
        b1=(Button)findViewById(R.id.btnlogin);

        b1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
            String email = e1.getText().toString();
            String password = e2.getText().toString();
            Boolean chkemailpass = db.emailpassword(email, password);
            if (chkemailpass == true)
                Toast.makeText(getApplicationContext(), "succesfully Login", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(getApplicationContext(), "wrong mail or passwor", Toast.LENGTH_SHORT).show();

           }
       });

    }

    private void configToolbar(){
        Toolbar toolbar = (Toolbar)findViewById(R.id.my_toolbar);
        toolbar.setTitle("Atentificacion");
        toolbar.setNavigationIcon(R.drawable.ic_backspace_black_24dp);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    public boolean onNavigationItemSelected(MenuItem item) {

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void onClickCrearCuenta(View view){
        startActivity(new Intent(this,RegisterActivity.class));
    }
}

