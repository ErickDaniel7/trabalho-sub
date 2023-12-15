package com.example.aaaaa;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import adapter.AdapterPais;
import controller.PaisController;
import model.Pais;

public class Listagem extends AppCompatActivity {
    private TextView tvCodigo;
    private TextView tvDescricao;
    private PaisController controller;
    private RecyclerView rvPais;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem);

        rvPais = findViewById(R.id.rvPais);
        carregarListaAlunos();
    }

    private void carregarListaAlunos(){
        ArrayList<Pais> listaPais = controller.retornar(this);
        AdapterPais adapter = new AdapterPais(this, listaPais);

        rvPais.setLayoutManager(new LinearLayoutManager(this));
        rvPais.setAdapter(adapter);
    }
}