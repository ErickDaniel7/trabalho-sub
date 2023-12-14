package com.example.trabalhopaises.view;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.trabalhopaises.R;
import com.example.trabalhopaises.adapter.PaisListAdapter;
import com.example.trabalhopaises.controller.PaisController;

import kotlin.Suppress;

public class MainActivity extends AppCompatActivity {

    private Button btBuscar;
    private Button btAbrirLista;
    private TextView tvCodigo;
    private TextView tvDescricao;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCodigo = findViewById(R.id.tvCodigo);
        tvDescricao = findViewById(R.id.tvDescricao);
        btBuscar = findViewById(R.id.btBuscar);
        btAbrirLista = findViewById(R.id.btAbrirLista);

        btBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PaisController.getViaPais(MainActivity.this);

        }
        });
        btAbrirLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PaisListAdapter.class);
            }
        });
    }

}