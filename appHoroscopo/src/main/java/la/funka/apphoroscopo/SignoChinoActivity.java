package la.funka.apphoroscopo;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.protocol.HTTP;

public class SignoChinoActivity extends Activity {

    public SignoChino signoChino;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signo_chino);

        // Traemos el signo desde la actividad anterior.
        String signo = getIntent().getStringExtra("Signo");

        // Setemos el signo.
        TextView mostrar_signo = (TextView) findViewById(R.id.text_signo);
        mostrar_signo.setText(signo);

        // Instanciamos un nuevo objeto signo.
        signoChino = new SignoChino(signo);
        String nombreSigno = signoChino.getNombreSigno().toString();

        // Traemos el imagen.
        ImageView img_signo = (ImageView) findViewById(R.id.img_signo);
        // Seteamos la imagen de manera dinamica gracias al objeto signoChino.
        img_signo.setImageResource(signoChino.setUrlIcon(nombreSigno));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.signo_chino, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // Traemos el signo desde la actividad anterior.
        String signo = getIntent().getStringExtra("Signo");

        // Setemos el signo.
        TextView mostrar_signo = (TextView) findViewById(R.id.text_signo);
        mostrar_signo.setText(signo);

        // Instanciamos un nuevo objeto signo.
        signoChino = new SignoChino(signo);
        String nombreSigno = signoChino.getNombreSigno().toString();

        // Traemos el textview a donde vamos a setear las predicciones.
        TextView text_prediccion = (TextView) findViewById(R.id.text_prediccion);

        switch (item.getItemId()) {
            case  R.id.action_amor:
                text_prediccion.setText(signoChino.prediccionAmor(nombreSigno));
                break;
            case R.id.action_salud:
                text_prediccion.setText(signoChino.prediccionSalud(nombreSigno));
                break;
            case R.id.action_dinero:
                text_prediccion.setText(signoChino.prediccionDinero(nombreSigno));
                break;
            case R.id.action_enviar_sms:
                Intent intent_sms = new Intent(Intent.ACTION_SEND);
                intent_sms.setType("text/plain");
                intent_sms.putExtra(Intent.EXTRA_PHONE_NUMBER, "3030");
                intent_sms.putExtra(Intent.EXTRA_TEXT, text_prediccion.getText().toString());
                try {
                    startActivity(intent_sms);
                } catch (Exception e) {
                    Toast.makeText(this, "No se pudo enviar el mensaje.", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.action_enviar_email:
                Intent intent_email = new Intent(Intent.ACTION_SEND);
                intent_email.setType(HTTP.PLAIN_TEXT_TYPE);
                intent_email.putExtra(Intent.EXTRA_EMAIL, new String[]{"molina.mariano23@gmail.com"});
                intent_email.putExtra(Intent.EXTRA_SUBJECT, "Predicciones Del Horoscopo Chino");
                intent_email.putExtra(Intent.EXTRA_TEXT, text_prediccion.getText().toString());
                try {
                    startActivity(intent_email);
                } catch (Exception e) {
                    Toast.makeText(this, "No se pudo enviar el mensaje.", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.action_compartir:
                Intent intent_share = new Intent(Intent.ACTION_SEND);
                intent_share.setType("text/plain");
                intent_share.putExtra(Intent.EXTRA_TEXT, text_prediccion.getText().toString());
                try {
                    startActivity(intent_share);
                } catch (Exception e) {
                    Toast.makeText(this, "No se pudo compartir.", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.action_otro_signo:
                Intent intent_nuevo_signo = new Intent(this, ChinoActivity.class);
                // Borramos el dato para que el usuario pueda seleccionar otro signo.
                SharedPreferences user_prefs = PreferenceManager.getDefaultSharedPreferences(SignoChinoActivity.this);
                SharedPreferences.Editor editor = user_prefs.edit();
                editor.putString("signo-user-chino","");
                editor.commit();
                this.startActivity(intent_nuevo_signo);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

}
