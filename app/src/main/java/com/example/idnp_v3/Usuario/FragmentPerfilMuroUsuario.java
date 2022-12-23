package com.example.idnp_v3.Usuario;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.example.idnp_v3.databinding.FragmentPerfilMuroUsuarioBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class FragmentPerfilMuroUsuario extends Fragment {

    private FragmentPerfilMuroUsuarioBinding binding;
    private RecyclerView listaFotos;
    private FotoAdapter adapter;
    private List<Bitmap> fotos= new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding= FragmentPerfilMuroUsuarioBinding.inflate(inflater,container,false);
        View root=binding.getRoot();


        listaFotos=binding.listaFotos;

        adapter=new FotoAdapter(fotos,getContext());
        listaFotos.setLayoutManager(new GridLayoutManager(getContext(), 4));
        listaFotos.setAdapter(adapter);

        FloatingActionButton btn =binding.fotografiar;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hacerFoto();
            }
        });
        return root;
    }
    public void cargarFotos(){
        File directorio=getContext().getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File[] ficheros=directorio.listFiles();
        //if()
        for (File f:ficheros){
            Bitmap image= BitmapFactory.decodeFile(f.getAbsolutePath());
            if(f.getName().endsWith(".jpg")){
                // String s=f.getName();

                Log.d("imagenesaa",image.toString());
                fotos.add(image);
            }

        }
    }
    private File archivo;
    public void hacerFoto(){
        try{
            Intent i= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            archivo=crearFichero();
            Uri foto= FileProvider.getUriForFile(getContext(),"com.example.idnp_v3.fileprovider",archivo);
            i.putExtra(MediaStore.EXTRA_OUTPUT,foto);
            startActivityForResult(i,1);
        }catch (IOException e){
            Toast.makeText(getContext(),"Error:"+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode==1){
            if(resultCode== Activity.RESULT_OK){
                Bitmap image= BitmapFactory.decodeFile(archivo.getAbsolutePath());
                fotos.add(image);
                adapter.notifyDataSetChanged();
            }else{
                archivo.delete();
            }
        }else{
            super.onActivityResult(requestCode, resultCode, data);
        }

    }

    public File crearFichero() throws IOException {
        String pre="foto_";
        File directorio=getContext().getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File img=File.createTempFile(pre+ UUID.randomUUID().toString(),".jpg",directorio);
        return img;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding=null;
    }
}