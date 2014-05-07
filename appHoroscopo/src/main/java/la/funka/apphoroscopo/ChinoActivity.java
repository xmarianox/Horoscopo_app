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


public class ChinoActivity extends Activity {

    public SignoChino signoChino;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chino);

        final Intent intent_signo = new Intent(ChinoActivity.this, SignoChinoActivity.class);

        String signo_guardado = "";
        SharedPreferences user_prefs = PreferenceManager.getDefaultSharedPreferences(this);
        signo_guardado = user_prefs.getString("signo-user-chino","");

        if (!signo_guardado.equals("")) {
            signoChino = new SignoChino(signo_guardado);
            String nombre_signo = signoChino.getNombreSigno().toString();
            intent_signo.putExtra("Signo", nombre_signo);
            startActivity(intent_signo);
            finish();
        }

        // Button para calcular el signo del usuario.
        Button btn_chino_calcular = (Button) findViewById(R.id.btn_calcular_chino);
        btn_chino_calcular.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /** Traemos el año actual.
                Calendar calendario = Calendar.getInstance();
                int anio_actual = calendario.get(Calendar.YEAR);
                */
                signoChino = new SignoChino();

                // Traemos el año que ingreso el usuario para calcular el signo.
                EditText input_anio = (EditText) findViewById(R.id.input_anio_chino);
                String anio_ingresado = input_anio.getText().toString().trim();
                int anio = Integer.parseInt(anio_ingresado);

                String signo = signoChino.dameSigno(anio);

                // Pasamos el signo al proximo activity.
                intent_signo.putExtra("Signo", signo);

                // Guardamos el signo del usuario de manera persistente.
                SharedPreferences user_prefs = PreferenceManager.getDefaultSharedPreferences(ChinoActivity.this);
                SharedPreferences.Editor editor = user_prefs.edit();
                editor.putString("signo-user-chino", signo);
                editor.commit();

                //Abrimos un nuevo activity.
                startActivity(intent_signo);

                /**
                if ( anio > anio_actual || anio > (anio_actual - 100) ) {
                    Toast.makeText(ChinoActivity.this, "El año no puede ser superior al año actual y tampoco mayor a 200 años", Toast.LENGTH_SHORT).show();
                } else {
                    String signo = signoChino.dameSigno(anio);
                    Toast.makeText(ChinoActivity.this, "Tu signo es " + signo, Toast.LENGTH_SHORT).show();
                    // Abrimos un nuevo activity con los datos del signo
                    Intent intent_signo = new Intent(ChinoActivity.this, SignoChinoActivity.class);
                    intent_signo.putExtra("Signo", signo);
                    startActivity(intent_signo);
                }
                */
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.lista_de_signos_chinos, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_lista_chinos) {
            Intent lista_intent_chino = new Intent(this, ListaChinoActivity.class);
            this.startActivity(lista_intent_chino);
        }
        return super.onOptionsItemSelected(item);
    }
}