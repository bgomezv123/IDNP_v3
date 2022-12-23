package com.example.idnp_v3.Usuario;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.idnp_v3.R;


public class FragmentEstadisticasUsuario extends Fragment {
    PieView pieView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        int totalReciclado  = getActivity().getIntent().getExtras().getInt("DataUsrRecTotal");
        int totalPuntos  = getActivity().getIntent().getExtras().getInt("DataUsrRecPuntos");
        View v =  inflater.inflate(R.layout.fragment_estadisticas_usuario, container, false);

        pieView = v.findViewById(R.id.dialView);

        pieView.setValues(totalReciclado,totalPuntos);



        EditText totalRecicladoEditText = v.findViewById(R.id.totalRecicladoEditText);
        EditText totalPuntosEditText = v.findViewById(R.id.puntosActualesEditText);

        totalRecicladoEditText.setText(Integer.toString(totalReciclado));
        totalPuntosEditText.setText(Integer.toString(totalPuntos));
        return v;
    }
}