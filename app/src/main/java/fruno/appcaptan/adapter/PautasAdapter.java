package fruno.appcaptan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import fruno.appcaptan.R;
import fruno.appcaptan.entity.Pauta;

public class PautasAdapter extends ArrayAdapter<Pauta> {
    private Context context;
    private ArrayList<Pauta> listaPautas;

    public PautasAdapter(Context context, ArrayList<Pauta> listaPautas) {
        super(context, R.layout.lista_pautas_item);

        this.context = context;
        this.listaPautas = listaPautas;
    }

    @Override
    public int getCount() {
        return listaPautas.size();
    }

    @Override
    public Pauta getItem(int position) {
        return listaPautas.get(position);
    }

    static class ViewHolder {
        @BindView(R.id.item_Titulo) TextView titulo;
        @BindView(R.id.item_BreveDescricao) TextView breveDescricao;
        @BindView(R.id.item_Autor) TextView autor;
        @BindView(R.id.item_Descricao) TextView descricao;
        @BindView(R.id.item_Botao) Button botao;
        @BindView(R.id.item_MaisDetalhes) View maisDetalhes;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (view != null) {
            holder = (ViewHolder) view.getTag();
        } else {
            view = inflater.inflate(R.layout.lista_pautas_item, parent, false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }

        Pauta item = getItem(position);

        System.out.println(item.getTitulo());

        holder.titulo.setText           (item.getTitulo());
        holder.breveDescricao.setText   (item.getBreveDescricao());
        holder.autor.setText            (item.getAutor());
        holder.descricao.setText        (item.getDescricao());

        if (item.getStatus().equals("ABERTA"))
            holder.botao.setText("FECHAR PAUTA");
        else
            holder.botao.setText("REABRIR PAUTA");

        if (item.isSelecionado())
            holder.maisDetalhes.setVisibility(View.VISIBLE);
        else
            holder.maisDetalhes.setVisibility(View.GONE);

        return view;
    }
}
