package com.example.gerson.app.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gerson.app.DatabaseHelper;
import com.example.gerson.app.R;

public class RegisterActivity extends AppCompatActivity {

    EditText e1,e2,e3;
    TextView b2;
    Button b1;
    DatabaseHelper db;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        db=new DatabaseHelper(this);
        e1=(EditText)findViewById(R.id.email);
        e2=(EditText)findViewById(R.id.pass);
        e3=(EditText)findViewById(R.id.cpass);

        b1=(Button)findViewById(R.id.register);
        b2=(TextView)findViewById(R.id.login);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(i);

            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=e1.getText().toString();
                String s2=e2.getText().toString();
                String s3=e3.getText().toString();
                if (s1.equals("") || s2.equals("") || s3.equals("")) {
                    Toast.makeText(getApplicationContext(),"Fields are empty",Toast.LENGTH_SHORT).show();

                }
                else {
                    if (s2.equals(s3)){
                        Boolean chkemail=db.chkemail(s1);
                        if (chkemail==true){
                            Boolean insert=db.insert(s1,s2);
                            if (insert==true){
                                Toast.makeText(getApplicationContext(),"Register succesfully",Toast.LENGTH_SHORT).show();

                            }

                        }
                        else{
                            Toast.makeText(getApplicationContext(),"Email already exits",Toast.LENGTH_SHORT).show();
                        }

                    }
                    else {Toast.makeText(getApplicationContext(),"Password dont not match",Toast.LENGTH_SHORT).show();}
                }
            }
        });
    }
}
