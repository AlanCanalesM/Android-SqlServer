package com.example.alan.proyecto;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Main3Activity extends AppCompatActivity {

    private RecyclerView recyclerViewUsuario;
    private RecyclerViewAdaptador adaptadorusuario;

    public Main3Activity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        recyclerViewUsuario=(RecyclerView)findViewById(R.id.recyclerusu);
        recyclerViewUsuario.setLayoutManager(new LinearLayoutManager(this));

        adaptadorusuario=new RecyclerViewAdaptador(obtenerusuarios());
        recyclerViewUsuario.setAdapter(adaptadorusuario);
    }
    public Connection conexionBD(){
        Connection conexion=null;
        try{
            StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
            conexion= DriverManager.getConnection("jdbc:jtds:sqlserver://10.0.1.15;databaseName=usuarios;user=sa;password=alan123;");

        }catch (Exception e){
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
        }
        return conexion;
    }

    public List<usuarioModelo>obtenerusuarios(){
        List<usuarioModelo> nombre=new ArrayList<>();
        try {
            Statement st=conexionBD().createStatement();
            ResultSet rs=st.executeQuery("select *from nombres");

            while (rs.next()){
                nombre.add(new usuarioModelo(rs.getString("nombre"), rs.getString("apellidos"), rs.getString("telefono"), rs.getString("email"), rs.getString("estado"), R.drawable.logo));
            }
        }catch (SQLException e){
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
        }
        return nombre;


    }




}
