package la.funka.apphoroscopo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class ZodiacoActivity extends Activity {

    public SignoZodiaco signoZodiaco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zodiaco);

        signoZodiaco = new SignoZodiaco();

        final Intent intent_oraculo = new Intent(this, OraculoZodiacoActivity.class);

        Button btn_calcuclar = (Button) findViewById(R.id.btn_calcular_zodiaco);
        btn_calcuclar.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Traemos una referencia de la fecha ingresada por el usuario
                EditText dia_nac = (EditText) findViewById(R.id.input_dia_zodiaco);
                EditText mes_nac = (EditText) findViewById(R.id.input_mes_zodiaco);

                // Traemos el valor de la fecha que ingreso el usuario
                String dia_ingresado = dia_nac.getText().toString().trim();
                String mes_ingresado = mes_nac.getText().toString().trim();

                // Convertimos a enteros los valores ingresados.
                int dia = Integer.parseInt(dia_ingresado);
                int mes = Integer.parseInt(mes_ingresado);

                // El metodo dame_signo_zodiaco devuelve el signo del usuario.
                String signo = signoZodiaco.dameSigno(dia, mes);

                // Pasamos el dato del signo actual al otro activity
                intent_oraculo.putExtra("signo", signo);

                // Abrimos el nuevo activity
                startActivity(intent_oraculo);
            }
        });

    }

}
