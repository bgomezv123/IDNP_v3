package com.example.idnp_v3.Usuario;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.idnp_v3.ManagerBD;
import com.example.idnp_v3.R;


public class FragmentPerfilSettingUsuario extends Fragment {

    Button btn;
    Intent intent;
    TextView nombreT;
    TextView punt;
    TextView totalRe;
    EditText user;
    EditText contra;
    EditText nombres;
    EditText apel;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_perfil_setting_usuario, container, false);

        String id = getActivity().getIntent().getExtras().getString("DataUsrId");
        String nombreComplet = getActivity().getIntent().getExtras().getString("DataUsrNom") + " " + getActivity().getIntent().getExtras().getString("DataUsrApe");

        String puntosR = String.valueOf(getActivity().getIntent().getExtras().getInt("DataUsrRecPuntos"));
        //getActivity().getIntent().getExtras().getString("DataUsrRecPuntos") ;
        String totalRecl = String.valueOf(getActivity().getIntent().getExtras().getInt("DataUsrRecTotal"));
        String contraseña = getActivity().getIntent().getExtras().getString("DataUsrCon");
        String Usuario = getActivity().getIntent().getExtras().getString("DataUsrUsr");
        String nombre = getActivity().getIntent().getExtras().getString("DataUsrNom");
        String apellidos = getActivity().getIntent().getExtras().getString("DataUsrApe");


        nombreT = v.findViewById(R.id.nombre);
        punt = v.findViewById(R.id.puntosR);
        totalRe = v.findViewById(R.id.totalReciclado);
        user = v.findViewById(R.id.ingUsuario);
        contra = v.findViewById(R.id.Contraseña);
        nombres = v.findViewById(R.id.nombres);
        apel = v.findViewById(R.id.apellidos);

        nombreT.setText(nombreComplet);
        punt.setText(puntosR);
        totalRe.setText(totalRecl);
        user.setText(Usuario);
        contra.setText(contraseña);
        nombres.setText(nombre);
        apel.setText(apellidos);
        // Inflate the layout for this fragment


        final ManagerBD managerBD = new ManagerBD(v.getContext());

        btn = v.findViewById(R.id.btnPerfilConfig);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                managerBD.actulizarPerfil(id, user.getText().toString(), contra.getText().toString(), nombres.getText().toString(), apel.getText().toString());
                Cursor dataUsuario = managerBD.buscarUsuario(user.getText().toString(), contra.getText().toString());

                if (dataUsuario != null) {

                    nombreT.setText(dataUsuario.getString(3) + " " + dataUsuario.getString(4));
                    user.setText(dataUsuario.getString(1));
                    contra.setText(dataUsuario.getString(2));
                    nombres.setText(dataUsuario.getString(3));
                    apel.setText(dataUsuario.getString(4));
                    Toast.makeText(v.getContext(), "Datos Guardados Correctamente", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(v.getContext(), "Datos Erroneos de Usuario", Toast.LENGTH_SHORT).show();
                }
            }

        });
        return v;
    }
}