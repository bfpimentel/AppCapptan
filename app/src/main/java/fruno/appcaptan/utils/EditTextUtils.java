package fruno.appcaptan.utils;

import android.widget.EditText;

public class EditTextUtils {

    public static boolean validaCampos(EditText[] campos) {
        boolean isEmpty = false;

        for (EditText campo: campos) {
            if (campo.getText().toString().trim().length() == 0) {
                campo.setError("Campo obrigatório!");
                isEmpty = true;
            }
        }

        return isEmpty;
    }
}
