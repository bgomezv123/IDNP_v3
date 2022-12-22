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
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;





public class FragmentAfiliado extends Fragment {
    FragmentHomeCanjeAfiliado fragmentHomeCanjeAfiliado;
    FragmentAfiliado fragmentAfiliado;
    FragmentRegistarServicio fragmentRegistarServicio;
    BottomNavigationView bottomNavigationView;
    FragmentPerfilSettingAfiliado fragmentPerfilSettingAfiliado;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Afiliado");

        View v= inflater.inflate(R.layout.fragment_afiliado, container, false);
        fragmentAfiliado = new FragmentAfiliado();
        fragmentHomeCanjeAfiliado = new FragmentHomeCanjeAfiliado();
        fragmentRegistarServicio = new FragmentRegistarServicio();
        fragmentPerfilSettingAfiliado = new FragmentPerfilSettingAfiliado();
        getParentFragmentManager().beginTransaction().replace(R.id.containerFragmentContent,fragmentHomeCanjeAfiliado).commit();

        bottomNavigationView = v.findViewById(R.id.bottom_navigation_afiliado);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.homeAfiliado:
                        getParentFragmentManager().beginTransaction().replace(R.id.containerFragmentContent,fragmentHomeCanjeAfiliado).commit();
                        return true;

                    case R.id.perfilAfiliado:
                        getParentFragmentManager().beginTransaction().replace(R.id.containerFragmentContent,fragmentPerfilSettingAfiliado).commit();
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