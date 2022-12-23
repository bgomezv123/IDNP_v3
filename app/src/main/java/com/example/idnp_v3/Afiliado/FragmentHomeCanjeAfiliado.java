package com.example.idnp_v3.Afiliado;

import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.idnp_v3.ManagerBD;
import com.example.idnp_v3.R;

public class FragmentHomeCanjeAfiliado extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_canje_afiliado, container, false);
        final ManagerBD managerBD= new ManagerBD(v.getContext());

        EditText AfiliadoIdText = v.findViewById(R.id.usrIdCanjeAfiliado);
        EditText AfiliadoPuntosText = v.findViewById(R.id.puntosCajeAfiliado);
        Button registrar = v.findViewById(R.id.canjeButton);

        Spinner comboServicio = v.findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(v.getContext(),R.array.comboServicio,android.R.layout.simple_spinner_item);
        comboServicio.setAdapter(adapter);


        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cursor = managerBD.buscarUsuarioPorID(Integer.parseInt(AfiliadoIdText.getText().toString()));
                managerBD.actualizarUsuarioReciclajePuntos(Integer.parseInt(AfiliadoIdText.getText().toString()),
                        Integer.parseInt(cursor.getString(5))-Integer.parseInt(AfiliadoPuntosText.getText().toString()),
                        Integer.parseInt(cursor.getString(6))-Integer.parseInt(AfiliadoPuntosText.getText().toString())*2

                );
                Toast.makeText(v.getContext(),"Datos Guardados", Toast.LENGTH_SHORT).show();
            }
        });



        return v;
    }
}