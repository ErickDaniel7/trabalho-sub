package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aaaaa.R;

import java.util.ArrayList;
import java.util.List;

import model.Pais;

public class AdapterPais extends RecyclerView.Adapter<AdapterPais.ViewHolder> {

    private ArrayList<Pais> listaPaises;
    private LayoutInflater inflater;

    public AdapterPais(Context context, ArrayList<Pais> listaPaises) {
        this.inflater = LayoutInflater.from(context);
        this.listaPaises = listaPaises;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_list_pais, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Pais pais = listaPaises.get(position);

        holder.tvCodigo.setText(String.valueOf(pais.getCodio()));
        holder.tvDescricao.setText(pais.getDescricao());
    }

    @Override
    public int getItemCount() {
        return listaPaises.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvCodigo, tvDescricao;

        public ViewHolder(View itemView) {
            super(itemView);
            tvCodigo = itemView.findViewById(R.id.tvCodigo);
            tvDescricao = itemView.findViewById(R.id.tvDescricao);
        }
    }
}
