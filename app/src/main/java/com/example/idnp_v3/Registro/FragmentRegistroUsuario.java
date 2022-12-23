package com.example.idnp_v3.Registro;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.idnp_v3.ManagerBD;
import com.example.idnp_v3.R;

import java.util.zip.Inflater;


public class FragmentRegistroUsuario extends Fragment {


    EditText usrId,usrUsr,usrCon,usrNom, usrApe;
    Button registarUsuario;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View  v = inflater.inflate(R.layout.fragment_registro_usuario, container, false);
        final ManagerBD managerBD= new ManagerBD(v.getContext());
        usrId = v.findViewById(R.id.usrIdForm);
        usrUsr = v.findViewById(R.id.usrUsrForm);
        usrCon = v.findViewById(R.id.usrConForm);
        usrNom = v.findViewById(R.id.usrNomForm);
        usrApe = v.findViewById(R.id.usrApeForm);
        registarUsuario = v.findViewById(R.id.registrarUsuarioButton);

        registarUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Contraseña",usrCon.getText().toString());
                managerBD.agregarUsuario(usrId.getText().toString(),usrUsr.getText().toString(),usrCon.getText().toString(),usrNom.getText().toString(),usrApe.getText().toString());
                Toast.makeText(v.getContext(),"Datos Guardados", Toast.LENGTH_SHORT).show();
            }
        });


        return v;
    }
}