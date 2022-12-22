package com.example.idnp_v3.Monitor;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.idnp_v3.Afiliado.FragmentAfiliado;
import com.example.idnp_v3.Afiliado.FragmentHomeCanjeAfiliado;
import com.example.idnp_v3.Afiliado.FragmentPerfilSettingAfiliado;
import com.example.idnp_v3.Afiliado.FragmentRegistarServicio;
import com.example.idnp_v3.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class FragmentMonitor extends Fragment {

    FragmentHomeMonitor fragmentHomeMonitor;
    FragmentPerfilSettingMonitor fragmentPerfilSettingMonitor;

    BottomNavigationView bottomNavigationView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Monitor");

        View v= inflater.inflate(R.layout.fragment_monitor, container, false);
        fragmentHomeMonitor = new FragmentHomeMonitor();
        fragmentPerfilSettingMonitor = new FragmentPerfilSettingMonitor();

        getParentFragmentManager().beginTransaction().replace(R.id.containerFragmentContent,fragmentHomeMonitor).commit();

        bottomNavigationView = v.findViewById(R.id.bottom_navigation_monitor);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.homeMonitor:
                        getParentFragmentManager().beginTransaction().replace(R.id.containerFragmentContent,fragmentHomeMonitor).commit();
                        return true;

                    case R.id.perfilMonitor:
                        getParentFragmentManager().beginTransaction().replace(R.id.containerFragmentContent,fragmentPerfilSettingMonitor).commit();
                        return true;
                }
                return false;
            }
        });

        return v;
    }
}