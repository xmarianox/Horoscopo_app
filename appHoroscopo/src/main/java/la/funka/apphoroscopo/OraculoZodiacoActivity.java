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


public class OraculoZodiacoActivity extends Activity {


    public SignoZodiaco signoZodiaco;
    //private Drawable mActionBarBackgroundDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oraculo_zodiaco);

        String signo = getIntent().getStringExtra("signo");
        signoZodiaco = new SignoZodiaco(signo);

        String nombreSigno = signoZodiaco.getNombreSigno().toString();

        TextView title_oraculo = (TextView) findViewById(R.id.title_oraculo_zodiaco);
        title_oraculo.setText(nombreSigno);

        // Traemos el imagen.
        ImageView img_signo = (ImageView) findViewById(R.id.img_signo_zodiaco);
        img_signo.setImageResource(signoZodiaco.setUrlIcon(nombreSigno));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.signo_zodiaco, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        String signo = getIntent().getStringExtra("signo");
        signoZodiaco = new SignoZodiaco(signo);
        String nombreSigno = signoZodiaco.getNombreSigno().toString();

        // Traemos el textview a donde vamos a setear las predicciones.
        TextView text_prediccion = (TextView) findViewById(R.id.text_prediccion_zodiaco);

        switch (item.getItemId()) {
            case  R.id.action_amor_zodiaco:
                text_prediccion.setText(signoZodiaco.prediccionAmor(nombreSigno));
                break;
            case R.id.action_salud_zodiaco:
                text_prediccion.setText(signoZodiaco.prediccionSalud(nombreSigno));
                break;
            case R.id.action_dinero_zodiaco:
                text_prediccion.setText(signoZodiaco.prediccionDinero(nombreSigno));
                break;
            case R.id.action_enviar_sms_zodiaco:
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
            case R.id.action_enviar_email_zodiaco:
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
            case R.id.action_compartir_zodiaco:
                Intent intent_share = new Intent(Intent.ACTION_SEND);
                intent_share.setType("text/plain");
                intent_share.putExtra(Intent.EXTRA_TEXT, text_prediccion.getText().toString());
                try {
                    startActivity(intent_share);
                } catch (Exception e) {
                    Toast.makeText(this, "No se pudo compartir.", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.action_otro_signo_zodiaco:
                Intent intent_nuevo_signo = new Intent(this, ZodiacoActivity.class);
                // Borramos el dato para que el usuario pueda seleccionar otro signo.
                SharedPreferences user_prefs = PreferenceManager.getDefaultSharedPreferences(OraculoZodiacoActivity.this);
                SharedPreferences.Editor editor = user_prefs.edit();
                editor.putString("signo-user-zodiaco", "");
                editor.commit();
                this.startActivity(intent_nuevo_signo);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
