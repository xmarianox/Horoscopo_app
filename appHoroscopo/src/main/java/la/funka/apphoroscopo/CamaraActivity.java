package la.funka.apphoroscopo;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;


public class CamaraActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camara);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.camara, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {

            case R.id.camara_action:
                Intent intent_foto = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent_foto, 10);
            break;

            case R.id.ver_action:
                Intent intent_web = new Intent(Intent.ACTION_VIEW);
                intent_web.setData(Uri.parse("http://developer.android.com/"));
                try {
                    startActivity(intent_web);
                } catch (Exception e) {
                    Toast.makeText(this, "No hay visores", Toast.LENGTH_LONG).show();
                }
            break;

            case R.id.ayuda_action:
                Intent intent_web_ayuda = new Intent(Intent.ACTION_VIEW);
                intent_web_ayuda.setData(Uri.parse("http://funka.la/"));
                try {
                    startActivity(intent_web_ayuda);
                } catch (Exception e) {
                    Toast.makeText(this, "No hay visores", Toast.LENGTH_LONG).show();
                }
            break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int codigoPedido, int codigoResultado, Intent data) {
        if (codigoPedido == 10) {
            if (codigoResultado == RESULT_OK) {
                Toast.makeText(this, "Llegó la foto", Toast.LENGTH_SHORT).show();

                Bundle extras = data.getExtras();
                Bitmap foto = (Bitmap) extras.get("data");

                ImageView content_foto = (ImageView) findViewById(R.id.content_foto);
                content_foto.setImageBitmap(foto);
            } else {
                Toast.makeText(this, "Cancelaste la acción, no hay foto", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
