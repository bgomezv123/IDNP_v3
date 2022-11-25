package com.example.idnp_v3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.idnp_v3.Monitor.FragmentMonitor;
import com.example.idnp_v3.Afiliado.FragmentAfiliado;
import com.example.idnp_v3.Usuario.FragmentUsuario;

public class MainActivity2 extends AppCompatActivity {
    private FragmentMonitor fragmentAdministrador;
    private FragmentAfiliado fragmentAfiliado;
    private FragmentUsuario fragmentUsuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        int value=0;
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
             value = extras.getInt("key");
        }
        Log.d("hola",String.valueOf(value));
        fragmentAdministrador = new FragmentMonitor();
        fragmentUsuario = new FragmentUsuario();
        fragmentAfiliado = new FragmentAfiliado();
        switch (value){
            case 1:
                Log.d("lugar","Monitor");
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.containerFragmentBar, fragmentAdministrador)
                        .commit();
                break;
            case 2:
                Log.d("lugar","Afiliado");
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.containerFragmentBar, fragmentAfiliado)
                        .commit();
                break;
            case 3:
                Log.d("lugar","usuario");
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.containerFragmentBar, fragmentUsuario)
                        .commit();
                break;
            case 0:
        }




    }
}