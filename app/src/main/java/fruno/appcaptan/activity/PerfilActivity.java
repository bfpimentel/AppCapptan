package fruno.appcaptan.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import fruno.appcaptan.R;

public class PerfilActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.perfil_activity);
        ButterKnife.bind(this);
    }


}
