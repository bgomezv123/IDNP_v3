package com.example.idnp_v3.Monitor;

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


public class FragmentPerfilSettingMonitor extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_perfil_setting_monitor, container, false);
        final ManagerBD managerBD= new ManagerBD(v.getContext());

        EditText MonitorIdText = v.findViewById(R.id.MonitorIdText);
        EditText monitorPuntosText = v.findViewById(R.id.monitorPuntosText);
        Button registrar = v.findViewById(R.id.registrarUsuarioButton);

        Spinner comboTipoPlastico = v.findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(v.getContext(),R.array.comboTipoPlastico,android.R.layout.simple_spinner_item);
        comboTipoPlastico.setAdapter(adapter1);

        Spinner comboTipoPresentacion = v.findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(v.getContext(),R.array.comboPresentacion,android.R.layout.simple_spinner_item);
        comboTipoPresentacion.setAdapter(adapter2);


        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cursor = managerBD.buscarUsuarioPorID(Integer.parseInt(MonitorIdText.getText().toString()));
                managerBD.actualizarUsuarioReciclajePuntos(Integer.parseInt(MonitorIdText.getText().toString()),
                        Integer.parseInt(monitorPuntosText.getText().toString())+Integer.parseInt(cursor.getString(5)),
                        Integer.parseInt(monitorPuntosText.getText().toString())*2 + Integer.parseInt(cursor.getString(6))

                );
                Toast.makeText(v.getContext(),"Datos Guardados", Toast.LENGTH_SHORT).show();
            }
        });

        return v;
    }
}