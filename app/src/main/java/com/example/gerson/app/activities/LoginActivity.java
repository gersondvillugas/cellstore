package com.example.gerson.app.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
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
}
