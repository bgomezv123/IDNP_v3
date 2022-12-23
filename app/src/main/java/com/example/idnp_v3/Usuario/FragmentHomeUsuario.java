package com.example.idnp_v3.Usuario;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.idnp_v3.ManagerBD;
import com.example.idnp_v3.R;

import com.example.idnp_v3.entidades.AfiliadoEntidad;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class FragmentHomeUsuario extends Fragment implements OnMapReadyCallback {
    private GoogleMap mMap;
    ManagerBD managerBD;
    String userId = "";
    TextView txtItems;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        userId = getActivity().getIntent().getExtras().getString("DataUsrId");
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Usuario");
        View v = inflater.inflate(R.layout.fragment_home_usuario, container, false);
         managerBD= new ManagerBD(v.getContext());
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        TextView txtReciclado = v.findViewById(R.id.txtCantReciclado);
        TextView txtActual = v.findViewById(R.id.txtCantActual);
        txtItems = v.findViewById(R.id.txtProducts);

        txtReciclado.setText(getActivity().getIntent().getExtras().getInt("DataUsrRecTotal") +"pts");
        txtActual.setText(getActivity().getIntent().getExtras().getInt("DataUsrRecPuntos")+"pts");

        return v;
    }


    @Override
    public void onMapReady(GoogleMap googleMap){
        mMap = googleMap;
        ArrayList<AfiliadoEntidad> listaAfiliado = managerBD.listaAfiliado();

        for (int i=0; i < listaAfiliado.size(); i++) {
            LatLng coordenadas = new LatLng(Float.parseFloat(listaAfiliado.get(i).getLat()),Float.parseFloat(listaAfiliado.get(i).getLon()));
            mMap.addMarker(new MarkerOptions()
                    .position(coordenadas)
                    .title(listaAfiliado.get(i).getNombre()));
        }
        LatLng coordenadasCamera = new LatLng(-16.391729,-71.514301);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(coordenadasCamera));


        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(@NonNull Marker marker) {
                LatLng positionLl =marker.getPosition();
                String txtItemsString = "";
                for (int i=0; i < listaAfiliado.size(); i++){
                    if (Float.parseFloat(listaAfiliado.get(i).getLat()) == positionLl.latitude &&
                            Float.parseFloat(listaAfiliado.get(i).getLon()) == positionLl.longitude){
                        txtItemsString = managerBD.itemsAfiliado(listaAfiliado.get(i).getId());
                    }
                }

                txtItems.setText(txtItemsString);

                //Toast.makeText(getContext(), "Lat: "+ positionLl.latitude + "Lon: " + positionLl.longitude, Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }
}