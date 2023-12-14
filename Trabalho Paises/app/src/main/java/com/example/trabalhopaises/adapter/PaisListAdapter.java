package com.example.trabalhopaises.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trabalhopaises.R;
import com.example.trabalhopaises.model.Pais;

import java.util.ArrayList;

public class PaisListAdapter extends RecyclerView.Adapter<PaisListAdapter.ViewHolder> {

    private ArrayList<Pais> listaPaises;

    private LayoutInflater inflater;

    public PaisListAdapter(Context context, ArrayList<Pais> listaPaises) {
        this.inflater = LayoutInflater.from(context);
        this.listaPaises = listaPaises;
    }
    @Override
    public RecyclerView.ViewHolder onCreteViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_list_pais, parent,false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        Pais pais = listaPaises.get(position);

        holder.tvCodigo.setText(String.valueOf(pais.getCodigo()));
        holder.tvDescricao.setText(pais.getDescricao());
    }

    @Override
    public class ViewHolder extends  RecyclerView.ViewHolder {
        private TextView tvCodigo, tvDescricao;

        public ViewHolder(View itemView){
            super(itemView);
            tvCodigo = itemView.findViewById(R.id.tvCodigo);
            tvDescricao = itemView.findViewById(R.id.tvDescricao);
        }
    }


}
