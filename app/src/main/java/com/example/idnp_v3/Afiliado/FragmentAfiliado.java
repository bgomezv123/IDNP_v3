package com.example.idnp_v3.Afiliado;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.idnp_v3.R;


public class FragmentAfiliado extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Afiliado");
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_afiliado, container, false);
    }
}