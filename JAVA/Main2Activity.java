package com.example.alan.proyecto;

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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main2Activity extends AppCompatActivity {

    EditText edtnombre, edtapellido,edttelefono,edtemail, edtestado;
    Button btnagregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        edtnombre=(EditText)findViewById(R.id.et1);
        edtapellido=(EditText)findViewById(R.id.et2);
        edttelefono=(EditText)findViewById(R.id.et3);
        edtemail=(EditText)findViewById(R.id.et4);
        edtestado=(EditText)findViewById(R.id.et5);
        btnagregar=(Button)findViewById(R.id.btn);

        btnagregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregarUsuario();
            }
        });
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

    public void agregarUsuario(){

        String nombree = edtnombre.getText().toString();
        String apellidoo = edtapellido.getText().toString();
        String notelefono = edttelefono.getText().toString();
        String emaill = edtemail.getText().toString();
        if (nombree.trim().equals("")){
            Toast.makeText(getApplicationContext(), "Agrega un nombre", Toast.LENGTH_SHORT).show();
        }
        else {
            if (apellidoo.trim().equals("")){
                Toast.makeText(getApplicationContext(), "Agrega un apellido", Toast.LENGTH_SHORT).show();
            }
            else {
              if (emaill.trim().equals("")){
                  Toast.makeText(getApplicationContext(), "Agrega un correo", Toast.LENGTH_SHORT).show();
              }
              else {
                  if(notelefono.trim().equals("")){
                      Toast.makeText(getApplicationContext(), "Agrega un numero de telefono", Toast.LENGTH_SHORT).show();
                  }
                  else {
                      try {

                          String query = "select * from nombres where telefono=" + notelefono.toString();
                          Statement stmt = conexionBD().createStatement();
                          ResultSet rs = stmt.executeQuery(query);

                          if (rs.next()){

                              Toast.makeText(getApplicationContext(), "Ese numero de telefono ya existe en la base de datos", Toast.LENGTH_SHORT).show();
                          }
                          else {
                              try{
                                  PreparedStatement pst=conexionBD().prepareStatement("insert into nombres values(?,?,?,?,?)");
                                  pst.setString(1, edtnombre.getText().toString());
                                  pst.setString(2, edtapellido.getText().toString());
                                  pst.setString(3, edttelefono.getText().toString());
                                  pst.setString(4, edtemail.getText().toString());
                                  pst.setString(5, edtestado.getText().toString());
                                  pst.executeUpdate();

                                  Toast.makeText(getApplicationContext(),"REGISTRO AGREGADO CORRECTAMENTE",Toast.LENGTH_SHORT).show();
                              }catch (SQLException e){
                                  Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
                              }
                          }
                      }catch (Exception e){
                          Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
                      }


                  }
              }
            }
        }



    }
}
