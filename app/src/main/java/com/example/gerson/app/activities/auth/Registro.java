package com.example.gerson.app.activities.auth;

import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.gerson.app.R;

public class Registro extends AppCompatActivity {
    private TextView iniciarSesion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        iniciarSesion = (TextView) findViewById(R.id.iniciar_sesion);
        iniciarSesion.setPaintFlags(iniciarSesion.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
    }
}
