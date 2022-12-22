package com.example.idnp_v3.Usuario;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.idnp_v3.R;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;


public class FragmentUsuario extends Fragment {


    BottomNavigationView bottomNavigationView;

    FragmentHomeUsuario fragmentHomeUsuario;
    FragmentEstadisticasUsuario fragmentEstadisticasUsuario;
    FragmentPerfilMuroUsuario fragmentPerfilMuroUsuario;
    FragmentPerfilSettingUsuario fragmentPerfilSettingUsuario;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_usuario, container, false);
        fragmentHomeUsuario = new FragmentHomeUsuario();
        fragmentEstadisticasUsuario = new FragmentEstadisticasUsuario();
        fragmentPerfilSettingUsuario = new FragmentPerfilSettingUsuario();
        fragmentPerfilMuroUsuario = new FragmentPerfilMuroUsuario();

        getParentFragmentManager().beginTransaction().replace(R.id.containerFragmentContent,fragmentHomeUsuario).commit();

        bottomNavigationView = v.findViewById(R.id.bottom_navigation_usuario);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.homeUsuario:
                        getParentFragmentManager().beginTransaction().replace(R.id.containerFragmentContent,fragmentHomeUsuario).commit();
                        return true;

                    case R.id.estadisticasUsuario:
                        getParentFragmentManager().beginTransaction().replace(R.id.containerFragmentContent,fragmentEstadisticasUsuario).commit();
                        return true;

                    case R.id.muroUsuario:
                        getParentFragmentManager().beginTransaction().replace(R.id.containerFragmentContent,fragmentPerfilMuroUsuario).commit();
                        return true;

                    case R.id.perfilUsuario:
                        getParentFragmentManager().beginTransaction().replace(R.id.containerFragmentContent,fragmentPerfilSettingUsuario).commit();
                        return true;
                }
                return false;
            }
        });

        return v;
    }
}