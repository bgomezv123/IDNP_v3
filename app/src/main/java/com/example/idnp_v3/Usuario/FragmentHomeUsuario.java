package com.example.idnp_v3.Usuario;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.idnp_v3.ManagerBD;
import com.example.idnp_v3.R;


public class FragmentHomeUsuario extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        String a = getActivity().getIntent().getExtras().getString("DataUsrId");
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Usuario");
        View v = inflater.inflate(R.layout.fragment_home_usuario, container, false);
        final ManagerBD managerBD= new ManagerBD(v.getContext());

        TextView data = v.findViewById(R.id.dataUsuarioTextView);

        data.setText(a);
        return v;
    }
}