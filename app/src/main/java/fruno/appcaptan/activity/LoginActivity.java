package fruno.appcaptan.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fruno.appcaptan.utils.EditTextUtils;
import fruno.appcaptan.R;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.login_CampoEmail) EditText campoEmail;
    @BindView(R.id.login_CampoSenha) EditText campoSenha;

    private EditText[] campos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        ButterKnife.bind(this);

        campos = new EditText[] { campoEmail, campoSenha };
    }

    @OnClick({R.id.login_BotaoEntrar, R.id.login_BotaoCadastro})
    protected void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_BotaoEntrar:
                tentaEntrar();
                break;
            case R.id.login_BotaoCadastro:
                Snackbar.make(view, "Teste", Snackbar.LENGTH_LONG).setAction("Ação", null).show();
                break;
        }
    }

    public void tentaEntrar() {
        if (!EditTextUtils.validaCampos(campos))
            return;

        startActivity(new Intent(this, ListaPautasActivity.class));
    }

}
