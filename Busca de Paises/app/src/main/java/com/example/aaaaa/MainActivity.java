package com.example.aaaaa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import adapter.AdapterPais;
import controller.PaisController;
import model.Pais;

public class MainActivity extends AppCompatActivity {

    private Button botaoBuscar;
    private Button botaoAbrirLista;
    private TextView tvCodigo;
    private TextView tvDescricao;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCodigo = findViewById(R.id.tvCodigo);
        tvDescricao = findViewById(R.id.tvDescricao);
        botaoBuscar = findViewById(R.id.botaoBuscar);
        botaoAbrirLista = findViewById(R.id.botaoAbrirLista);

        botaoBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PaisController.getViaPais(MainActivity.this);
            }
        });

        botaoAbrirLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Listagem.class);
                startActivity(intent);

            }
        });
    }
}