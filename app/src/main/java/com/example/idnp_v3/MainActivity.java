package com.example.idnp_v3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    EditText editText;
    Button buttonAfiliado,buttonAdministrador,buttonUsuario;
    Intent intent;


    Spinner opcionesSpinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAdministrador = findViewById(R.id.Administrador);
        buttonAfiliado = findViewById(R.id.Afiliado);
        buttonUsuario = findViewById(R.id.Usuario);



        buttonAdministrador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(),MainActivity2.class);
                intent.putExtra("key",1);
                startActivity(intent);
            }
        });

        buttonAfiliado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(),MainActivity2.class);
                startActivity(intent);
                intent.putExtra("key",2);
                startActivity(intent);
            }
        });

        buttonUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(),MainActivity2.class);
                startActivity(intent);
                intent.putExtra("key",3);
                startActivity(intent);
            }
        });


    }
}