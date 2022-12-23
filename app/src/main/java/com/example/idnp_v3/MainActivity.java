package com.example.idnp_v3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView textRegistroUsuario;
    EditText editText;
    Button buttonAfiliado,buttonMonitor,buttonUsuario;
    Intent intent;


    Spinner opcionesSpinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Inicio de sesion");
        buttonMonitor = findViewById(R.id.Monitor);
        buttonAfiliado = findViewById(R.id.Afiliado);
        buttonUsuario = findViewById(R.id.Usuario);
        textRegistroUsuario = findViewById(R.id.textRegistroUsuario);
        final ManagerBD managerBD= new ManagerBD(getApplicationContext());

        EditText usrUsr = findViewById(R.id.usrInicioSesion);
        EditText usrCon = findViewById(R.id.conInicioSesion);

        buttonMonitor.setOnClickListener(new View.OnClickListener() {
            @Override
            //EntrarComoMonitor
            public void onClick(View view) {
                managerBD.listarUsuarios();
                Cursor dataMonitor = managerBD.buscarMonitor(usrUsr.getText().toString(),usrCon.getText().toString());

                if(dataMonitor!=null){
                    intent = new Intent(getApplicationContext(),MainActivity2.class);
                    intent.putExtra("key",1);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(),"Datos Erroneos de Usuario", Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonAfiliado.setOnClickListener(new View.OnClickListener() {
            @Override
            //Entrar Como Afiliado
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(),MainActivity2.class);
                intent.putExtra("key",2);
                startActivity(intent);
            }
        });
        //Entrar Como Usuario
        buttonUsuario.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                managerBD.listarUsuarios();
                Cursor dataUsuario = managerBD.buscarUsuario(usrUsr.getText().toString(),usrCon.getText().toString());

                if(dataUsuario!=null){
                    intent = new Intent(getApplicationContext(),MainActivity2.class);
                    intent.putExtra("key",3);
                    intent.putExtra("DataUsrId",dataUsuario.getString(0));
                    intent.putExtra("DataUsrUsr",dataUsuario.getString(1));
                    intent.putExtra("DataUsrCon",dataUsuario.getString(2));
                    intent.putExtra("DataUsrNom",dataUsuario.getString(3));
                    intent.putExtra("DataUsrApe",dataUsuario.getString(4));
                    intent.putExtra("DataUsrRecTotal",Integer.parseInt(dataUsuario.getString(5)));
                    intent.putExtra("DataUsrRecPuntos",Integer.parseInt(dataUsuario.getString(6)));
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(),"Datos Erroneos de Usuario", Toast.LENGTH_SHORT).show();
                }


            }
        });

        textRegistroUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(),MainActivity2.class);
                intent.putExtra("key",4);
                startActivity(intent);
            }
        });


    }
}