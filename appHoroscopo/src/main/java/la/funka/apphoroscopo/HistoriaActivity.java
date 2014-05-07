package la.funka.apphoroscopo;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;


public class HistoriaActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historia);

        Button btn_traer = (Button) findViewById(R.id.btn_traer_historia);
        btn_traer.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LeerDeInternet leer = new LeerDeInternet();
                leer.execute("http://alumnos.itmaster.com.ar/horoscopo.txt");
            }
        });
    }

    /**
     *  LeerDeInternet
     */
    public class LeerDeInternet extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... urls) {
            InputStream inputStream = null;
            String result = "";
            try {
                HttpClient httpclient = new DefaultHttpClient();
                HttpResponse httpResponse = httpclient.execute(new HttpGet(urls[0]));
                inputStream = httpResponse.getEntity().getContent();
                if(inputStream != null) {
                    BufferedReader buffer = new BufferedReader( new InputStreamReader(inputStream));
                    String line = "";
                    while ((line = buffer.readLine()) != null)
                        result += line;

                    inputStream.close();
                } else {
                    // ERROR;
                }

            } catch (Exception e) {
                // ERROR;
                Log.d("InputStream", e.getLocalizedMessage());
            }
            return result;
        }

        @Override
        protected void onPostExecute(String resultado) {
            // En result está el texto que viene de Internet
            TextView texto_historia = (TextView) findViewById(R.id.texto_historia);
            texto_historia.setText(resultado);
        }
    }
}


