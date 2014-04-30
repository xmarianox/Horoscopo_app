package la.funka.apphoroscopo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class ChinoActivity extends Activity {

    public SignoChino signoChino;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chino);

        // Button para calcular el signo del usuario.
        Button btn_chino_calcular = (Button) findViewById(R.id.btn_calcular_chino);
        btn_chino_calcular.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /** Traemos el año actual.
                *   Calendar calendario = Calendar.getInstance();
                *   //Calendar.YEAR esta generando error
                *   int anio_actual = calendario.get(Calendar.YEAR);
                */
                signoChino = new SignoChino();

                // Traemos el año que ingreso el usuario para calcular el signo.
                EditText input_anio = (EditText) findViewById(R.id.input_anio_chino);
                String anio_ingresado = input_anio.getText().toString().trim();
                int anio = Integer.parseInt(anio_ingresado);

                String signo = signoChino.dameSigno(anio);
                Toast.makeText(ChinoActivity.this, "Tu signo es " + signo, Toast.LENGTH_SHORT).show();

                // Abrimos un nuevo activity con los datos del signo
                Intent intent_signo = new Intent(ChinoActivity.this, SignoChinoActivity.class);
                intent_signo.putExtra("Signo", signo);
                startActivity(intent_signo);

                /**
                *   if ( anio > anio_actual || anio > (anio_actual - 100) ) {
                *        Toast.makeText(ChinoActivity.this, "El anio no puede ser superior al anio de la fecha actual y tampoco mayor a 200 anios", Toast.LENGTH_SHORT).show();
                *   } else {
                *       String signo = dameSigno(anio);
                *       Toast.makeText(ChinoActivity.this, "Tu signo es " + signo, Toast.LENGTH_SHORT).show();
                *       // Abrimos un nuevo activity con los datos del signo
                *       intent_signo.putExtra("Signo", signo);
                *       startActivity(intent_signo);
                *   }
                */
            }
        });
    }
}