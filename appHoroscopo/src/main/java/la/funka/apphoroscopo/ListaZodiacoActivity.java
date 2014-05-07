package la.funka.apphoroscopo;

import android.app.ListActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class ListaZodiacoActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_zodiaco);

        Resources res = getResources();
        String[] signos_zodiaco_list = res.getStringArray(R.array.signos_zodiaco_list);

        ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, signos_zodiaco_list);
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        String signo_seleccionado = l.getItemAtPosition(position).toString();

        //Toast.makeText(this,"El signo seleccionado es: " + signo_seleccionado, Toast.LENGTH_SHORT).show();
        Intent intent_signo = new Intent(this, OraculoZodiacoActivity.class);
        intent_signo.putExtra("signo", signo_seleccionado);
        this.startActivity(intent_signo);
    }
}
