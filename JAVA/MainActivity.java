package com.example.sayra.proyecto;

import android.app.Activity;
import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MainActivity extends AppCompatActivity {


Button btnagregar, btnconsul, btnedit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnagregar=(Button)findViewById(R.id.btnagregarusuarios);
        btnconsul=(Button)findViewById(R.id.btnconsultar);


        btnagregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ventana1();
            }
        });
        btnconsul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ventana2();
            }
        });



    }

    public void ventana1(){

        Intent intent=new Intent(MainActivity.this, Main2Activity.class);
        startActivity(intent);
    }

    public void ventana2(){

        Intent intent=new Intent(MainActivity.this, Main3Activity.class);
        startActivity(intent);
    }





}
