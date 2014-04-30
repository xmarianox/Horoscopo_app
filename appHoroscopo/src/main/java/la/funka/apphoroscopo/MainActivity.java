package la.funka.apphoroscopo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         *   Istanciamos una nueva actividad para la pantalla de ChinoActivity.
         */
        final Intent intent_chino = new Intent(this, ChinoActivity.class);
        /**
         *   Istanciamos una nueva actividad para la pantalla de ZodiacoActivity.
         */
        final Intent intent_zodiaco = new Intent(this, ZodiacoActivity.class);
        /**
         *   Traemos una referencian del btn_chino.
         *   Escuchamos el click del btn_chino y abrimos la actividad ChinoActivity.
         */
        Button btn_chino = (Button) findViewById(R.id.btn_chino);
        btn_chino.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.startActivity(intent_chino);
            }
        });
        /**
         *   Traemos una referencian del btn_zodiaco.
         *   Escuchamos el click del btn_zodiaco y abrimos la actividad ZodiacoActivity.
         */
        Button btn_zodiaco = (Button) findViewById(R.id.btn_zodiaco);
        btn_zodiaco.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.startActivity(intent_zodiaco);
            }
        });
        /**
         *
         */
        final Intent intent_camara = new Intent(this, CamaraActivity.class);
        Button btn_open_cam = (Button) findViewById(R.id.btn_cam_activity);
        btn_open_cam.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.startActivity(intent_camara);
            }
        });
    }
}
