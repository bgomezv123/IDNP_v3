package com.example.idnp_v3.Afiliado;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.idnp_v3.R;
<<<<<<< HEAD
public class FragmentAfiliado extends Fragment {
=======
import com.example.idnp_v3.Usuario.FragmentEstadisticasUsuario;
import com.example.idnp_v3.Usuario.FragmentHomeUsuario;
import com.example.idnp_v3.Usuario.FragmentPerfilSettingUsuario;
import com.example.idnp_v3.Usuario.FragmentPerfilUsuario;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;


public class FragmentAfiliado extends Fragment {
    FragmentCanjeAfiliado fragmentCanjeAfiliado;
    FragmentAfiliado fragmentAfiliado;
    FragmentRegistarServicio fragmentRegistarServicio;
    BottomNavigationView bottomNavigationView;
>>>>>>> 3f6528398503746cd204d94f2fa483467bfd9f60
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {/*
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Afiliado");
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_afiliado, container, false);*/
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_afiliado, container, false);
        fragmentAfiliado = new FragmentAfiliado();
        fragmentCanjeAfiliado = new FragmentCanjeAfiliado();
        fragmentRegistarServicio = new FragmentRegistarServicio();
        getParentFragmentManager().beginTransaction().replace(R.id.containerFragmentContent,fragmentCanjeAfiliado).commit();

        bottomNavigationView = v.findViewById(R.id.bottom_navigation_afiliado);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.homeAfiliado:
                        getParentFragmentManager().beginTransaction().replace(R.id.containerFragmentContent,fragmentCanjeAfiliado).commit();
                        return true;

                    case R.id.perfilAfiliado:
                        //getParentFragmentManager().beginTransaction().replace(R.id.containerFragmentContent,fragmentAfiliado).commit();
                        return true;

                    case R.id.registrarAfiliado:
                        getParentFragmentManager().beginTransaction().replace(R.id.containerFragmentContent,fragmentRegistarServicio).commit();
                        return true;

                }
                return false;
            }
        });

        return v;
    }
}