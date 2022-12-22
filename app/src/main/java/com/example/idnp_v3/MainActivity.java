package com.example.idnp_v3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

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


        buttonMonitor.setOnClickListener(new View.OnClickListener() {
            @Override
            //EntrarComoMonitor
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(),MainActivity2.class);
                intent.putExtra("key",1);
                startActivity(intent);
            }
        });

        buttonAfiliado.setOnClickListener(new View.OnClickListener() {
            @Override
            //Entrar Como Afiliado
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(),MainActivity2.class);
                startActivity(intent);
                intent.putExtra("key",2);
                startActivity(intent);
            }
        });
            //Entrar Como Usuario
        buttonUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                managerBD.buscarCurso("1");
                intent = new Intent(getApplicationContext(),MainActivity2.class);
                startActivity(intent);
                intent.putExtra("key",3);
                startActivity(intent);
            }
        });

        textRegistroUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(),MainActivity2.class);
                startActivity(intent);
                intent.putExtra("key",4);
                startActivity(intent);
            }
        });


    }
}