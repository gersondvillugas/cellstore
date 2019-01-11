package com.example.gerson.app.activities;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gerson.app.R;
import com.example.gerson.app.models.Celular;
import com.squareup.picasso.Picasso;

public class Main2Activity extends AppCompatActivity {
    private  Celular mCelular;
    private  ImageView imgFoto;
    private  TextView  etCosto;
    private  TextView etDescripcion;
    private  TextView etMarca;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        imgFoto=(ImageView)findViewById(R.id.imageviewcel);
        etCosto=(TextView) findViewById(R.id.textViewCost);
        etDescripcion=(TextView) findViewById(R.id.textViewDescripcion);
        etMarca=(TextView) findViewById(R.id.textViewMarca);



        configActionBar();
        Intent intent=getIntent();
        configArtista();

    }
    private void configActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }
    private void configArtista() {
        mCelular = MainActivity.sPhone;
        mCelular.setDescripcion("adadad a");
        etMarca.setText(mCelular.getName());
        etDescripcion.setText(mCelular.getDescripcion());
        etCosto.setText(mCelular.getPrecio().toString());
        imgFoto.setImageResource(mCelular.getPoster());

    }



}

