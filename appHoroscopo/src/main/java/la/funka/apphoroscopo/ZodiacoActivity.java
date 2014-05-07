package la.funka.apphoroscopo;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
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
        SharedPreferences user_prefs = PreferenceManager.getDefaultSharedPreferences(this);

        String signo_guardado = "";
        signo_guardado = user_prefs.getString("signo-user-zodiaco","");

        if (!signo_guardado.equals("")) {
            signoZodiaco = new SignoZodiaco(signo_guardado);
            String nombre_signo = signoZodiaco.getNombreSigno().toString();
            intent_oraculo.putExtra("signo", nombre_signo);
            startActivity(intent_oraculo);
            finish();
        }

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

                // Guardamos el signo del usuario de manera persistente.
                SharedPreferences user_prefs = PreferenceManager.getDefaultSharedPreferences(ZodiacoActivity.this);
                SharedPreferences.Editor editor = user_prefs.edit();
                editor.putString("signo-user-zodiaco", signo);
                editor.commit();

                // Abrimos el nuevo activity
                startActivity(intent_oraculo);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.lista_de_signos_zodiaco, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_lista_zodiaco) {
            Intent lista_intent_zodiaco = new Intent(this, ListaZodiacoActivity.class);
            this.startActivity(lista_intent_zodiaco);
        }
        return super.onOptionsItemSelected(item);
    }

}
