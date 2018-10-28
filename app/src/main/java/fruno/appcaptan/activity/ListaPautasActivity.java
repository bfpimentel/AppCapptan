package fruno.appcaptan.activity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RadioButton;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fruno.appcaptan.R;
import fruno.appcaptan.adapter.PautasAdapter;
import fruno.appcaptan.entity.Pauta;

public class ListaPautasActivity extends ListActivity {

    private ArrayAdapter<Pauta> adapter;
    private ArrayList<Pauta> listaPauta;

    private int ultimoItem = -1;

    @BindView(R.id.lista_AbaAbertas) RadioButton abaAbertas;
    @BindView(R.id.lista_AbaFechadas) RadioButton abaFechadas;
    @BindView(R.id.lista_SeletorAbaAbertas) View seletorAbaAbertas;
    @BindView(R.id.lista_SeletorAbaFechadas) View seletorAbaFechadas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_pautas_activity);
        ButterKnife.bind(this);

        criaLista();
        criaAdapter();
    }

    @OnClick({R.id.lista_AbaAbertas, R.id.lista_AbaFechadas, R.id.lista_BotaoPerfil})
    protected void onClick(View view) {
        trocaAba(view);
    }

    private void trocaAba(View view) {
        switch (view.getId()) {
            case R.id.lista_AbaAbertas:
                if (abaAbertas.isChecked()) {
                    seletorAbaAbertas.setVisibility(View.VISIBLE);
                    seletorAbaFechadas.setVisibility(View.INVISIBLE);
                }
                break;
            case R.id.lista_AbaFechadas:
                if (abaFechadas.isChecked()) {
                    seletorAbaFechadas.setVisibility(View.VISIBLE);
                    seletorAbaAbertas.setVisibility(View.INVISIBLE);
                }
                break;
            case R.id.lista_BotaoPerfil:
                startActivity(new Intent(this, PerfilActivity.class));
                break;
        }
    }

    private void criaLista() {
        listaPauta = new ArrayList<>();

        Pauta p1 = new Pauta(
                "Teste Titulo",
                "Teste Breve Descrição",
                "Teste Descrição",
                "Teste autor",
                "ABERTA"
        );

        listaPauta.add(p1);
    }

    private void criaAdapter() {
        adapter = new PautasAdapter(this, listaPauta);
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView list, View view, int position, long id) {
        super.onListItemClick(list, view, position, id);

        selecionaItem(position);
    }

    private void selecionaItem(int position) {
        if (listaPauta.get(position).isSelecionado()) {
            listaPauta.get(position).setSelecionado(false);

            if (listaPauta.get(ultimoItem).isSelecionado())
                listaPauta.get(ultimoItem).setSelecionado(false);
        } else {
            if (ultimoItem != -1)
                listaPauta.get(ultimoItem).setSelecionado(false);

            ultimoItem = position;
            listaPauta.get(position).setSelecionado(true);
        }

        adapter.notifyDataSetChanged();
    }


}
