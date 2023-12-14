package com.example.trabalhopaises.view;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trabalhopaises.R;
import com.example.trabalhopaises.adapter.PaisListAdapter;
import com.example.trabalhopaises.controller.PaisController;
import com.example.trabalhopaises.model.Pais;

import java.util.ArrayList;

public class ListaPaises extends AppCompatActivity {
    private TextView tvCodigo;
    private TextView tvDescricao;
    private PaisController controller;
    private RecyclerView rvPais;

    @Override
    protected void OnCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_paises);

        rvPais = findViewById(R.id.rvPais);
        carregarListaPaises();

        private void carregarListaPaises(){
            ArrayList<Pais> listaPais = controller.retornar(this);
            PaisListAdapter adapter = new PaisListAdapter(this, listaPais);

            rvPais.setLayoutManager(new LinearLayoutManager(this));
            rvPais.setAdapter(adapter);
        }
    }
}
